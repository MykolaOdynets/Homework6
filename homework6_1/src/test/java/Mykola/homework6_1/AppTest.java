package Mykola.homework6_1;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class AppTest {

	private OkHttpClient client;

	@BeforeMethod(alwaysRun = true)

	public void setupHttpClient() {
		client = new OkHttpClient();
	}

	@Test
	public void simpleHttpTest() throws IOException {
		Request request = new Request.Builder().url("http://www.lits.com.ua").build();
		System.out.println("Request:  " + request.url());
		Response response = client.newCall(request).execute();
		Assert.assertEquals(response.code(), 200, "Status code was not 200");
		System.out.println("response status:   " + response.code());

		System.out.println("response content type:    " + response.header("Content-Type"));

		Assert.assertTrue(response.header("Content-Type").contains("text/html"),
				"text/html content type was not detected");
		String responseBody = response.body().string();

		System.out.println(" response body : ");
		System.out.println(responseBody);
		Assert.assertTrue(responseBody.contains("<div class=\"panel panel-default\">"), " element was not found" );
		
		System.out.println("Text EXIST");

	}
}