package org.hawhamburg.partslist.endtoend;

import org.hawhamburg.partslist.endtoend.pages.CreateProductPage;
import org.hawhamburg.partslist.model.CyclicStructureException;
import org.hawhamburg.partslist.model.Material;
import org.hawhamburg.partslist.model.Product;
import org.hawhamburg.partslist.persistence.ComponentRegister;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateProductTest extends BaseTest {

    @Test
    public void createProduct() throws CyclicStructureException, InterruptedException {
        //Arrange
        Material m1 = ComponentRegister.getInstance().createMaterial("m1", 1);
        Material m2 = ComponentRegister.getInstance().createMaterial("m2", 2);

        var productName = "p1";
        var productPrice = "10";
        var componentAmount1 = "5";
        var componentAmount2 = "10";

        Product expectedProduct = new Product(productName, Integer.parseInt(productPrice));
        expectedProduct.addPart(m1, Integer.parseInt(componentAmount1));
        expectedProduct.addPart(m2, Integer.parseInt(componentAmount2));

        var createProductPage = new CreateProductPage(baseURL, webDriver);

        //Act
        createProductPage.load();
        createProductPage.addComponent(m1.getName(), componentAmount1);
        createProductPage.addComponent(m2.getName(), componentAmount2);
        createProductPage.creatProduct(productName, productPrice);

        //Assert
        Thread.sleep(100);
        Product actualProduct = ComponentRegister.getInstance().getProduct(productName);
        assertEquals(expectedProduct, actualProduct);
    }
}
