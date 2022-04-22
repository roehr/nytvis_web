package de.rehpic.nytvis.model;

public class Keyword {
    private String name;
    private String value;

    public Keyword(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }
}
