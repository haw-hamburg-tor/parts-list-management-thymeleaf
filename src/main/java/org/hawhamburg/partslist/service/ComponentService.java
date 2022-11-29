package org.hawhamburg.partslist.service;

import org.hawhamburg.partslist.model.Component;
import org.hawhamburg.partslist.persistence.ComponentRegister;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComponentService {
    public List<Component> getAll() {
        return ComponentRegister.getInstance().getComponents();
    }

    public List<String> getAllComponentNames() {
        return ComponentRegister.getInstance().getComponentNames();
    }
}
