package utils.wsi.fileparser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mark Kuznetsov (mkuznetsov@evelopers.com)
 */
public class DocInfo {
    private Map<String, String> attributes = new HashMap<>();
    private List<String> fileNames = new ArrayList<>();

    public Map<String, String> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, String> attributes) {
        this.attributes = attributes;
    }

    public List<String> getFileNames() {
        return fileNames;
    }

    public void setFileNames(List<String> fileNames) {
        this.fileNames = fileNames;
    }

    public boolean hasFiles() {
        return fileNames.size() > 0;
    }
}
