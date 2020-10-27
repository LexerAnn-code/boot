package combase.demo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("basestation")
public class Boot {
    @PostMapping("/avail-req")
    public JsonNode details(@RequestBody JsonNode jsonNode){
        System.out.println("Received JSON:"+jsonNode.toString());
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<JsonNode> request = new HttpEntity<>(jsonNode);
        ObjectMapper mapper = new ObjectMapper();
        String url = "https://safe-basin-01006.herokuapp.com/api/avail_spectrum";
        ResponseEntity<JsonNode> response =
                restTemplate.exchange(url,
                        HttpMethod.POST,
                        request,
                        JsonNode.class);
        JsonNode responsePayload = response.getBody();

        JsonNode node = null;
        try {
            node = mapper.readTree(String.valueOf(responsePayload));
            JsonNode coordinatesNode = node.at("/spectrumSpecs/spectrumSchedules/Spectrum").get(0);
            System.out.println(coordinatesNode);
            return coordinatesNode;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }


        return responsePayload;


    }
    @GetMapping()
    public String boot(){
        return  "adasdasd";
    }
}
