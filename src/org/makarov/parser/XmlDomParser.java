package org.makarov.parser;

import org.makarov.parser.load.DefaultXmlFileLoader;
import org.makarov.parser.model.Document;

import java.io.File;


public class XmlDomParser {

    private Document document;

    private DefaultXmlFileLoader loader;

    public XmlDomParser(String filePath) {
        this.loader = new DefaultXmlFileLoader(filePath);
        parseXml();
    }

    private XmlDomParser(File xmlFile) {
        this.loader = new DefaultXmlFileLoader(xmlFile);
        parseXml();
    }

    private void parseXml() {




    }


    public Document getDocument() {
        return document;
    }
}
