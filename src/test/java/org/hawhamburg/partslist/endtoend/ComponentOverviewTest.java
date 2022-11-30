package org.hawhamburg.partslist.endtoend;

import org.hawhamburg.partslist.endtoend.pages.ComponentOverviewPage;
import org.hawhamburg.partslist.model.Component;
import org.hawhamburg.partslist.model.Material;
import org.hawhamburg.partslist.model.Product;
import org.hawhamburg.partslist.persistence.ComponentRegister;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ComponentOverviewTest extends BaseTest {

    @Test
    public void componentOverviewWithProductsAndMaterials() {
        //Arrange
        Material m1 = ComponentRegister.getInstance().createMaterial("m1", 1);
        Material m2 = ComponentRegister.getInstance().createMaterial("m2", 2);
        Product p1 = ComponentRegister.getInstance().createProduct("p1", 10, List.of("m1", "m2"), List.of(5, 10));

        var componentOverviewPage = new ComponentOverviewPage(baseURL, webDriver);

        //Act
        componentOverviewPage.load();

        //Assert
        List<List<String>> tableRows = componentOverviewPage.getTableRows();
        List<String> m1Row = tableRows.get(0);
        List<String> m2Row = tableRows.get(1);
        List<String> p1Row = tableRows.get(2);

        assertRowsAgainstComponent(m1Row, m1);
        assertRowsAgainstComponent(m2Row, m2);
        assertRowsAgainstComponent(p1Row, p1);
    }

    private void assertRowsAgainstComponent(List<String> row, Component component) {
        assertEquals(component.getName(), row.get(ComponentOverviewPage.NAME_COLUMN_INDEX));
        assertEquals(String.valueOf(component.getPrice()), row.get(ComponentOverviewPage.PRICE_COLUMN_INDEX));
        assertEquals(String.valueOf(component.fetchTotalPrice()), row.get(ComponentOverviewPage.TOTAL_PRICE_COLUMN_INDEX));
        assertEquals(component.getType(), row.get(ComponentOverviewPage.TYPE_COLUMN_INDEX));
    }
}
