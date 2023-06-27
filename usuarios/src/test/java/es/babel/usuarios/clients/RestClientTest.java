package es.babel.usuarios.clients;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

import es.babel.usuarios.web.dto.DocumentoDto;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;

public class RestClientTest {
    private RestClient restClient;
    private MockRestServiceServer mockServer;

    @BeforeEach
    public void setup() {
    	restClient = new RestClient();
        mockServer = MockRestServiceServer.createServer(restClient.getRestTemplate());
    }

    @Test
    public void testMakeApiRequest_Success() {
        String apiUrl = "http://localhost:8080/biblioteca/documentos/1";
        String responseBody = "{\"id\": 1, \"titulo\": \"Titulo\"}";

        mockServer.expect(requestTo(apiUrl))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(responseBody, MediaType.APPLICATION_JSON));

        DocumentoDto response = restClient.makeRequest(apiUrl, HttpMethod.GET, null, DocumentoDto.class);

        mockServer.verify();
        Assertions.assertEquals(1, response.getId());
        Assertions.assertEquals("Titulo", response.getTitulo());
    }

    @Test
    public void testMakeApiRequest_Error() {
    	 String apiUrl = "http://localhost:8080/biblioteca/documentos/2";

        mockServer.expect(requestTo(apiUrl))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withStatus(HttpStatus.NOT_FOUND));

        Assertions.assertThrows(Exception.class, () -> {
            restClient.makeRequest(apiUrl, HttpMethod.GET, null, DocumentoDto.class);
        });

        mockServer.verify();
    }
}

