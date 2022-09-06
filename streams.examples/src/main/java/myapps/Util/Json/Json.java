package myapps.Util.Json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {
    private static ObjectMapper objectMapper = getDefaultObjectMapper();

    private static ObjectMapper getDefaultObjectMapper(){
        ObjectMapper defaultObjectMapper = new ObjectMapper();
        defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return defaultObjectMapper;

    }
    //JSON String to JSON Node
    public static JsonNode parse(String src) throws JsonProcessingException {
        return objectMapper.readTree(src);
    }
    //JSON Node to POJO
    public static <A> A fromJson(JsonNode node, Class<A> claZZ) throws JsonProcessingException {
        return objectMapper.treeToValue(node, claZZ);
    }

    public static JsonNode toJson(Object a){
        return objectMapper.valueToTree(a);
    }
}
