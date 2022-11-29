package org.hawhamburg.partslist.controller.dto;

import java.util.List;

public class ProductForm extends ComponentForm {

    private List<QuantifiedComponent> quantifiedComponents;

    public List<QuantifiedComponent> getQuantifiedComponents() {
        return quantifiedComponents;
    }

    public void setQuantifiedComponents(List<QuantifiedComponent> quantifiedComponents) {
        this.quantifiedComponents = quantifiedComponents;
    }
}
