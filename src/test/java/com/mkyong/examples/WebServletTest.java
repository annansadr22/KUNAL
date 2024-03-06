package com.mkyong.examples;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.junit.jupiter.api.Test;

public class WebServletTest {

    @Test
    public void testHelloServletGet() throws Exception {
        HttpClient client = new HttpClient();
        client.start();

        ContentResponse res = client.GET("http://151.145.35.98:8080/HelloServlet");

        System.out.println(res.getContentAsString());

        client.stop();
    }
    
	
	@SuppressWarnings("deprecation")
	@Test
	void testArtistsPost() throws Exception {
		
		String url = "http://151.145.35.98:8080/artists";
		HttpClient client = new HttpClient();
        client.start();
        
        Request request = client.POST(url);
        
        request.param("id","id200");
        request.param("name","artist200");
        
        ContentResponse response = request.send();
		String res = new String(response.getContent());
		System.out.println(res);
		client.stop();
	}
    
}
