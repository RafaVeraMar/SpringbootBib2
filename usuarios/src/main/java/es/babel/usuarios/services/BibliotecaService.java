package es.babel.usuarios.services;

import es.babel.usuarios.clients.RestClient;
import es.babel.usuarios.web.dto.DocumentoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

@Service
public class BibliotecaService {
    private static final String BASE_API_URL = "http://localhost:8080/biblioteca";
    private RestClient restClient;
    @Autowired
    public BibliotecaService(RestClient restClient) {
        this.restClient = restClient;
    }

    public DocumentoDto getDocumentoById(Integer id) {
        final String url = BASE_API_URL + "/documentos/" + id;
        return restClient.makeRequest(url, HttpMethod.GET,null, DocumentoDto.class);
    }
}
