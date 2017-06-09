package org.makarov.parser.load;

import org.makarov.parser.exception.XmlFileLoadException;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DefaultXmlFileLoader implements XmlFileLoader {

    private String filePath;

    private File xmlFile;

    public DefaultXmlFileLoader(String filePath) {
        this.filePath = filePath;
    }

    public DefaultXmlFileLoader(File xmlFile) {
        this.xmlFile = xmlFile;
    }

    @Override
    public String getXmlContent() {
        if (filePath != null) {
            xmlFile = getFileByFileName(filePath);
        }

        if (xmlFile == null) {
            xmlFile = getXmlFromClassPath(filePath);

            if (xmlFile == null) {
                throw new XmlFileLoadException("file: " + filePath + " - can't be a load");
            }
        }

        return getContextFromFile(xmlFile);
    }

    private File getFileByFileName(String filePath) {
        File file = getXmlFromSystemPath(filePath);

        if (file.isFile()) {
            return file;
        }

        return null;
    }

    private File getXmlFromSystemPath(String filePath) {
        return new File(filePath);
    }

    private File getXmlFromClassPath(String filePath) {
        if (!(filePath.contains("\\") || filePath.contains("/"))) {
            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            URL resource = classLoader.getResource(filePath);
            if (resource != null) {
                System.out.println(resource);
                String preparePath = resource.toString();
                preparePath = preparePath.substring(preparePath.indexOf("/"));
                return new File(preparePath);
            }
        }

        return null;
    }

    private String getContextFromFile(File file) {
        try {
            byte[] encoded = Files.readAllBytes(Paths.get(file.getAbsolutePath()));
            return new String(encoded, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
