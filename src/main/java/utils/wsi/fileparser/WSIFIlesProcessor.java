package utils.wsi.fileparser;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Hello world!
 *
 */
public class WSIFIlesProcessor {

    private static final String ROOT_FOLDER = "D:\\stock\\ibm\\ibm_wsi_files_script\\files\\9BC7D51570B04C1C854C2F463AC0FED0-5\\9BC7D51570B04C1C854C2F463AC0FED0-5";
    private static final String OUT_FOLDER = ROOT_FOLDER + "\\out";

    public static void main(String[] args) throws Exception {
        Collection<File> xmlFiles = FileUtils.listFiles(new File(ROOT_FOLDER), new String[]{"xml"}, false);
        List<DocInfo> docs = new ArrayList<>();

        for (File xmlFile : xmlFiles) {
            try (StaxStreamProcessor processor = new StaxStreamProcessor(new FileInputStream(xmlFile))) {
                while (processor.startElement("DOCUMENT", "DOCUMENTS")) {
                    DocInfo doc = new DocInfo();
                    docs.add(doc);
                    while (!processor.ended("DOCUMENT")) {
                        if (processor.started("DOCINDEXFIELD")) {
                            String name = "";
                            String value = "";
                            while (!processor.ended("DOCINDEXFIELD")) {
                                if (processor.started("NAME")) {
                                    name = processor.getName();
                                }
                                if (processor.started("VALUE")) {
                                    value = processor.getValue();
                                }
                                processor.getReader().next();
                            }
                            doc.getAttributes().put(name, value);
                        }
                        if (processor.started("OBJECT")) {
                            while (!processor.ended("OBJECT")) {
                                if (processor.getReader().hasName() && processor.getReader().getLocalName().startsWith("FILE")) {
                                    String text = processor.getFile();
                                    if (StringUtils.isNotBlank(text)) {
                                        doc.getFileNames().add(text);
                                    }
                                }
                                processor.getReader().next();
                            }
                        }
                        processor.getReader().next();
                    }
                }
            }
        }

        int processedFiles = 0;
        for (DocInfo doc : docs) {
            if (doc.hasFiles()) {
                for (String fPath : doc.getFileNames()) {
                    File file = new File(ROOT_FOLDER + "\\" + fPath);
                    String newName = doc.getAttributes().get("VENDOR NAME")
                            + " - " + doc.getAttributes().get("INVOICE NUMBER")
                            + " - " + file.getName();
                    newName = newName
                            .replaceAll("/", "_")
                            .replaceAll(":", "_")
                            .replaceAll("\\*", "_")
                            .replaceAll("\\?", "_")
                            .replaceAll("\"", "_")
                            .replaceAll("<", "_")
                            .replaceAll(">", "_")
                            .replaceAll("\\|", "_")
                            .replaceAll("\\\\", "_");

                    File dst = new File(OUT_FOLDER + "\\" + newName);
                    System.out.println("from:" + file + "\nto:" + dst);
                    FileUtils.copyFile(file, dst);
                    processedFiles++;
                }
            }
        }

        System.out.println("Total processed: " + processedFiles);

    }



}
