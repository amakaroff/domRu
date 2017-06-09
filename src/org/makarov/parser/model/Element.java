package org.makarov.parser.model;

import java.util.List;

public class Element {

    private String name;

    private String text;

    private List<Attribute> attributes;

    private List<Element> childes;

    public Element(String name, String text, List<Attribute> attributes, List<Element> childes) {
        this.name = name;
        this.text = text;
        this.attributes = attributes;
        this.childes = childes;
    }

    public String getName() {
        return name;
    }

    public String getText() {
        return text;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public List<Element> getChildes() {
        return childes;
    }
}
