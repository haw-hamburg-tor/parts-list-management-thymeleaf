package org.hawhamburg.partslist.endtoend;

import org.hawhamburg.partslist.endtoend.pages.CreateMaterialPage;
import org.hawhamburg.partslist.model.Material;
import org.hawhamburg.partslist.persistence.ComponentRegister;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateMaterialTest extends BaseTest {

    @Test
    public void createMaterial() {
        // Arrange
        var materialName = "m1";
        var materialPrice = "5";
        var createMaterialPage = new CreateMaterialPage(baseURL, webDriver);

        // Act
        createMaterialPage.load();
        createMaterialPage.createMaterial(materialName, materialPrice);

        // Assert
        Material m1 = ComponentRegister.getInstance().getMaterial(materialName);
        assertEquals(materialName, m1.getName());
        assertEquals(Integer.parseInt(materialPrice), m1.getPrice());
    }

}
