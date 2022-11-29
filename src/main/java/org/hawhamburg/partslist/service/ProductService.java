package org.hawhamburg.partslist.service;

import org.hawhamburg.partslist.model.Material;
import org.hawhamburg.partslist.model.Product;
import org.hawhamburg.partslist.persistence.ComponentRegister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    public Product createProduct(String name, Integer price, List<String> componentNames, List<Integer> componentAmounts) {
        return ComponentRegister.getInstance().createProduct(name, price, componentNames, componentAmounts);
    }

    public List<Material> getMaterialList(java.lang.String productName) {
        return ComponentRegister.getInstance().getProduct(productName).fetchMaterialList();
    }

    public List<java.lang.String> getAllNames() {
        return ComponentRegister.getInstance().getProductNames();
    }
}
