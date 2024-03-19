package apiActions;

import com.fasterxml.jackson.databind.util.JSONPObject;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class Auth extends GlobalSettings{

        String name = RandomStringUtils.randomAlphabetic(10);
        String surname = RandomStringUtils.randomAlphabetic(10);

    public Auth() throws IOException {
    }

@Test
    public void registerNewUser() throws IOException {
        final String endpointName = "/aith/signin";
        String url = baseUrl + endpointName;

        String addUser =
                "{\n" +
                        "\"name\": \"John\",\n" +
                        "\"lastName\": \"Dou\",\n" +
                        "\"email\": \"test@test.com\",\n" +
                        "\"password\": \"Qwerty12345\",\n" +
                        "\"repeatPassword\": \"Qwerty12345\"\n" +
                        "}";

        RequestBody body = RequestBody.create(addUser, MediaType.get("application/json"));
        Request request = new Request.Builder()
                .url(url)
                .header("accept", "*/*")
                .method("POST", body)
                .build();
        Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
    }

    public void registerMoreNewUser() throws IOException {
    MediaType mediaType = MediaType.parse("application/json");
    RequestBody body = RequestBody.create(mediaType, "{\n  \"email\": \"test@test.com\",\n  \"password\": \"Qwerty12345\",\n  \"remember\": false\n}");
    Request request = new Request.Builder()
            .url("http://your-api-endpoint.com")
            .post(body)
            .addHeader("Content-Type", "application/json")
            .build();

    Response response = client.newCall(request).execute();
        System.out.println(response.body().string());
}

}
