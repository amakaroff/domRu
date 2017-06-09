package org.makarov.parser.exception;

/**
 * Created by alma0317 on 09.06.2017.
 */
public class XmlFileLoadException extends RuntimeException {

    public XmlFileLoadException() {
    }

    public XmlFileLoadException(String message) {
        super(message);
    }

    public XmlFileLoadException(Throwable cause) {
        super(cause);
    }
}
