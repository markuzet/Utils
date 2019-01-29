package utils.test.emptyjson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author Mark Kuznetsov (mkuznetsov@evelopers.com)
 */
public class TestEmptyValueJson {

    public static void main(String[] args) throws JsonProcessingException {
        TestObj q = new TestObj();
        q.setSimpleValue("qwe");
        q.setAnotherValue(null);

        q.addIgnoredField("anotherValue");

        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(q));
    }
}
