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
    private CloseableHttpClient httpClient = HttpClients.createDefault();
    private HttpPost request;

    private JSONObject generatePayload(JSONObject payload) {
        payload.put("name", "This is a very long address. A very very long address indeed.This is a very long address. A very very long address indeed.This is a very long address. A very very long address indeed.This is a very long address. A very very long address indeed.This is a very long address. A very very long address indeed.This is a very long address. A very very long address indeed.This is a very long address. A very very long address indeed.This is a very long address. A very very long address indeed.This is a very long address. A very very long address indeed.");
        payload.put("age", 21);
        payload.put("aadhaar", 342453421);
        payload.put("salary", 32424.1234);
        payload.put("isDev", Boolean.TRUE);
        payload.put("address", "This is a very long address. A very very long address indeed.This is a very long address. A very very long address indeed.This is a very long address. A very very long address indeed.This is a very long address. A very very long address indeed.This is a very long address. A very very long address indeed.This is a very long address. A very very long address indeed.This is a very long address. A very very long address indeed.This is a very long address. A very very long address indeed.This is a very long address. A very very long address indeed.");

        return payload;
    }

    private HttpPost generateHttpRequest(String payloadType) {
        String path;

        if (payloadType.equals("json")) {
            path = "8080/";
        } else {
            path = "7070/v1/example/echo";
        }

        return new HttpPost("http://0.0.0.0:" + path);
    }

    public HttpService(String payloadType) {
        JSONObject payload = generatePayload(new JSONObject());
        StringEntity requestEntity = new StringEntity(payload.toString(), ContentType.APPLICATION_JSON);

        this.request = generateHttpRequest(payloadType);
        this.request.setHeader("Content-Type", "application/json");
        this.request.setEntity(requestEntity);
    }

    public void connect() {
        try {
            CloseableHttpResponse response = this.httpClient.execute(request);

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
