package utils.wsi.fileparser;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.InputStream;

/**
 * @author Mark Kuznetsov (mkuznetsov@evelopers.com)
 */
public class StaxStreamProcessor implements AutoCloseable {
    private static final XMLInputFactory FACTORY = XMLInputFactory.newInstance();

    private final XMLStreamReader reader;

    public StaxStreamProcessor(InputStream is) throws XMLStreamException {
        reader = FACTORY.createXMLStreamReader(is);
    }

    public XMLStreamReader getReader() {
        return reader;
    }

    @Override
    public void close() {
        if (reader != null) {
            try {
                reader.close();
            } catch (XMLStreamException e) { // empty
            }
        }
    }

    public boolean doUntil(int stopEvent, String value) throws XMLStreamException {
        while (reader.hasNext()) {
            int event = reader.next();
            if (event == stopEvent && value.equals(reader.getLocalName())) {
                return true;
            }
        }
        return false;
    }

    public boolean startElement(String element, String parent) throws XMLStreamException {
        while (reader.hasNext()) {
            int event = reader.next();
            if (parent != null && event == XMLEvent.END_ELEMENT &&
                    parent.equals(reader.getLocalName())) {
                return false;
            }
            if (event == XMLEvent.START_ELEMENT &&
                    element.equals(reader.getLocalName())) {
                return true;
            }
        }
        return false;
    }

    public String getName() throws XMLStreamException {
        return reader.getElementText();
    }

    public String getValue() throws XMLStreamException {
        return reader.getElementText();
    }

    public String getFile() throws XMLStreamException {
        return reader.getElementText();
    }

    public String getAttribute(String name) throws XMLStreamException {
        return reader.getAttributeValue(null, name);
    }
    public String getText() throws XMLStreamException {
        return reader.getElementText();
    }

    public boolean started(String docindexfield) {
        return XMLEvent.START_ELEMENT == reader.getEventType() && reader.getLocalName().equalsIgnoreCase(docindexfield);
    }

    public boolean ended(String docindexfield) {
        return XMLEvent.END_ELEMENT == reader.getEventType() && reader.getLocalName().equalsIgnoreCase(docindexfield);
    }
}
