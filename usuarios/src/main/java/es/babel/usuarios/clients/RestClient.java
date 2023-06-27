package es.babel.usuarios.clients;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {
	private RestTemplate restTemplate;
	
	public RestClient() {
		this.restTemplate = new RestTemplate();
	}
	
	public <T> T makeRequest(String url, HttpMethod method, Object requestBody, Class<T> responseType) {
		HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        
        HttpEntity<Object> requestEntity = new HttpEntity<>(requestBody, headers);
		ResponseEntity<T> responseEntity = restTemplate.exchange(url, method, requestEntity, responseType);
        return responseEntity.getBody();
	}
	
	//Metodo necesario para los Test
	public RestTemplate getRestTemplate() {
		return this.restTemplate;
	}
}
