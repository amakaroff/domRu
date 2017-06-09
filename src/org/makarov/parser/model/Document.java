package org.makarov.parser.model;

public class Document {

    private Element primaryElement;

    public Document(Element primaryElement) {
        this.primaryElement = primaryElement;
    }

    public Element getPrimaryElement() {
        return primaryElement;
    }
}
