package com.josineudo.Enums;
public enum Category {
    POP("Pop"), COUNTRY("Country");

    private String value;

    private Category(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return value;
    }
}