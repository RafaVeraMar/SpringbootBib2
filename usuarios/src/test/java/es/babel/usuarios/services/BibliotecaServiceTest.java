package es.babel.usuarios.services;

import es.babel.usuarios.clients.RestClient;
import es.babel.usuarios.mappers.UsuarioMapper;
import es.babel.usuarios.repositories.PrestamoRepository;
import es.babel.usuarios.repositories.UsuarioRepository;
import es.babel.usuarios.web.dto.DocumentoDto;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.EndpointExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpMethod;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.ResourceAccessException;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.*;

@EndpointExtension(SpringExtension.class)
@SpringBootTest
public class BibliotecaServiceTest {

    @Autowired
    private BibliotecaService service;

    @Autowired
    private CircuitBreakerRegistry circuitBreakerRegistry;

    @MockBean
    private RestClient client;
    
    @MockBean
    private UsuarioRepository usuarioRepository;
    @MockBean
    private PrestamoRepository prestamoRepository;
    @MockBean
    private UsuarioMapper usuarioMapper;

    @BeforeEach
    public void setUp() {

        circuitBreakerRegistry.circuitBreaker("bibliotecaCircuitbreaker").reset();
    }

    @Test
    public void getDocumentoByIdTest(){
        DocumentoDto documento = new DocumentoDto();
        documento.setId(1);
        documento.setTitulo("Titulo");
        when (client.makeRequest("http://localhost:8080/biblioteca/documentos/1", HttpMethod.GET,null,DocumentoDto.class)).thenReturn(documento);

        DocumentoDto respuesta = service.getDocumentoById(1);

        assertEquals("Titulo", respuesta.getTitulo());
        verify(client,times(1)).makeRequest("http://localhost:8080/biblioteca/documentos/1", HttpMethod.GET,null, DocumentoDto.class);
    }

    @Test
    public void getDocumentoByIdFailTest() {
        when(client.makeRequest("http://localhost:8080/documentos/1", HttpMethod.GET,null, DocumentoDto.class)).thenThrow(ResourceAccessException.class);

        DocumentoDto respuesta = service.getDocumentoById(1);
        assertNull(respuesta.getTitulo());

    }

}
