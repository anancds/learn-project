import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public class JsonTest {

    public static String Array2Json(Object array) throws RuntimeException {
        String result;
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
            result = mapper.writeValueAsString(array);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static String wrapSuccessString(String status) {
        String result;
        ObjectMapper mapper = new ObjectMapper();
        try {
            ObjectNode node = mapper.createObjectNode();
            node.put("status", status);
            Map<String , String> map = new HashMap<>();
            map.put("fsd", "fjskljf");
            map.put("24rjl", "jflksj");
            node.put("123", "jlkj");
            node.putPOJO(":jlj", map);
            node.putPOJO("jfsdljflsj", "jljflk");
            node.putPOJO("fslk", 98);

            result = mapper.writeValueAsString(node);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return result;
    }


    public static void main(String[] args) {


        System.out.printf(wrapSuccessString("abc"));
    }
}
