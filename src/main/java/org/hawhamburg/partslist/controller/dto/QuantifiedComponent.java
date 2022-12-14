package org.hawhamburg.partslist.controller.dto;

public class QuantifiedComponent {
    private String name;
    private Integer amount;

    public QuantifiedComponent(String name, Integer amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
