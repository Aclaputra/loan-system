package com.investree.sandboxing.testing;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TestingController {
    @Autowired
    private TestRestTemplate restTemplate;
    @Test
    public void restTemplateSave() throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "*/*");
        headers.set("Content-Type", "application/json");
        String bodyTesting = "{\n" +
                "   \"tenor\": 21 ,\n" +
                "   \"totalPinjaman\":\"192179037\",\n" +
                "   \"bungaPersen\":\"0.9\",\n" +
                "   \"status\":\"berjalan\",\n" +
                "   \"peminjam\": {\n" +
                "       \"id\":\"1\"\n" +
                "   },\n" +
                "   \"meminjam\": {\n" +
                "       \"id\":\"2\"\n" +
                "   }\n" +
                "}";
        HttpEntity<String> entity = new HttpEntity<>(bodyTesting, headers);
        System.out.println("response save = "+ bodyTesting);

        ResponseEntity<String> exchange = restTemplate.exchange
                ("http://localhost:8081/api/v1/transaksi", HttpMethod.POST, entity, String.class);
        assertEquals(HttpStatus.OK, exchange.getStatusCode());
        System.out.println("response =" + exchange.getBody());
    }

    @Test
    public void restTemplateList() throws Exception {

    }
}
