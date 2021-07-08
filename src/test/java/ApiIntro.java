import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
/*
To execute api call:
1. Have/launch a client(postman)
2. Have valid URL
3. Specify desired/supported HTTP method
4. Define headers (if needed)
5. Define query string parameters (if needed)
6. Execute/click on Send button
 */

public class ApiIntro {
    @Test
    public void test() throws URISyntaxException, IOException {
        //1. Have/launch a client(postman)
        HttpClient httpClient = HttpClientBuilder.create().build();
        // HttpClient is a interface .. we use HttpClientBuilder class to create a object

        //2. Have valid URL.And we construct our URL
        //ex: https://corona.lmao.ninja/v2/states
        URIBuilder uriBuilder = new URIBuilder();
        uriBuilder.setScheme("https");
        uriBuilder.setHost("corona.lmao.ninja");
        uriBuilder.setPath("v2/states");

        //3. Specify desired/supported HTTP method
        HttpGet httpGet = new HttpGet(uriBuilder.build());

        //4.Execute/click on Send button
        HttpResponse response = httpClient.execute(httpGet);
        //first thing we do is to validate the status code
        int statusCode = response.getStatusLine().getStatusCode();
        System.out.println("Status code is: " + statusCode);
        Assert.assertEquals(200, statusCode);

        // we can print out the content of the body like this....
        String responseBody= EntityUtils.toString(response.getEntity());
        System.out.println(responseBody);
    }
}
