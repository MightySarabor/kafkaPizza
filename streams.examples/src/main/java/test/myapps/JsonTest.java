package test.myapps;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import myapps.Util.Json;
import myapps.pojos.PizzaPOJO;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class JsonTest {

    private String simplePizza =
            "{\n" +
            "  \"name\": \"Hawaii\",\n" +
            "  \"size\": \"L\",\n" +
            "  \"price\": 12.5\n" +
            "}";

    @Test
    void parse() throws JsonProcessingException {

        JsonNode node = Json.parse(simplePizza);
        assertEquals(node.get("name").asText(), "Hawaii");
    }
    @Test
     void fromJson() throws IOException {
        JsonNode node = Json.parse(simplePizza);
        PizzaPOJO pojo = Json.fromJson(node, PizzaPOJO.class);

        assertEquals(pojo.getName(), "Hawaii");
    }
}