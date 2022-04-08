package com.baron.dashboardapi.domain.chuckfacts.models;

public class ChuckFact {
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ChuckFact{" +
                "value='" + value + '\'' +
                '}';
    }
}
