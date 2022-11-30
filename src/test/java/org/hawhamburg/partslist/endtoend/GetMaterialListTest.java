package org.hawhamburg.partslist.endtoend;

import org.hawhamburg.partslist.endtoend.pages.MaterialListPage;
import org.hawhamburg.partslist.model.Component;
import org.hawhamburg.partslist.model.Material;
import org.hawhamburg.partslist.model.Product;
import org.hawhamburg.partslist.persistence.ComponentRegister;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GetMaterialListTest extends BaseTest {

    @Test
    public void getMaterialList() throws InterruptedException {
        //Arrange
        ComponentRegister.getInstance().createMaterial("m1", 1);
        ComponentRegister.getInstance().createMaterial("m2", 2);
        Product p1 = ComponentRegister.getInstance().createProduct("p1", 10, List.of("m1", "m2"), List.of(5, 10));

        var materialListPage = new MaterialListPage(baseURL, webDriver);
        Thread.sleep(100);

        //Act
        materialListPage.load();
        materialListPage.getMaterialList(p1.getName());

        //Assert
        List<String> nameColumn = materialListPage.getNameColumn();
        List<String> amountColumn = materialListPage.getAmountColumn();
        List<Material> actualMaterialList = IntStream.range(0, nameColumn.size())
                .mapToObj(i -> Collections.nCopies(Integer.parseInt(amountColumn.get(i)), ComponentRegister.getInstance().getMaterial(nameColumn.get(i))))
                .flatMap(List::stream)
                .sorted(Comparator.comparing(Component::getName))
                .toList();

        assertEquals(p1.fetchMaterialList(), actualMaterialList);
    }
}
