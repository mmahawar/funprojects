package com.example;

import java.io.IOException;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation.Builder;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;


public class TestGit {

	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		
		javax.ws.rs.client.Client client = ClientBuilder.newClient();
		Builder request = client.target("https://api.github.com").path("/users/mmahawar").request();
		String response = request.get(String.class);
		
		System.out.println(response);
		
		ObjectMapper mapper = new ObjectMapper();
		JsonFactory factory = mapper.getJsonFactory(); 
		JsonParser jp = factory.createJsonParser(response);
		JsonNode actualObj = mapper.readTree(jp);
		String name = actualObj.get("name").asText();
		System.out.println(name);
	}

}
