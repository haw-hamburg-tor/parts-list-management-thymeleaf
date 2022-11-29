package org.hawhamburg.partslist.service;

import org.hawhamburg.partslist.model.Material;
import org.hawhamburg.partslist.persistence.ComponentRegister;
import org.springframework.stereotype.Service;

@Service
public class MaterialService {
    public Material createMaterial(java.lang.String name, Integer price) {
        return ComponentRegister.getInstance().createMaterial(name, price);
    }
}
