package service;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import org.apache.http.util.EntityUtils;
import org.json.simple.JSONObject;

import java.io.IOException;

public class HttpService {
    public void connect() {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost request = new HttpPost("http://0.0.0.0:8080");
        JSONObject payload = new JSONObject();
        payload.put("name", "Ashish");
        payload.put("age", 21);

        request.setHeader("Content-Type", "application/json");
        StringEntity requestEntity = new StringEntity(payload.toString(), ContentType.APPLICATION_JSON);

        try {
            request.setEntity(requestEntity);
            CloseableHttpResponse response = httpClient.execute(request);

            try {
                HttpEntity httpEntity = response.getEntity();

                if(httpEntity != null) {
                    String responseString = EntityUtils.toString(httpEntity, "UTF-8");
//                    System.out.println(responseString);
                }

            } finally {
                response.close();
            }

        } catch (IOException e) {

        }
    }
}
