package es.babel.biblioteca.web.rest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import es.babel.biblioteca.facades.AutorFacade;
import es.babel.biblioteca.web.dto.response.AutorResponse;
import jakarta.persistence.EntityNotFoundException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class AutorControllerTest {

	@MockBean
	private AutorFacade facade;
	
	@Autowired
    private MockMvc mvc;
	
	@Test
	public void obtenerAutoresTest() throws Exception {
		List<AutorResponse> list = new ArrayList<>();
		list.add(AutorResponse.builder().id(1).nombre("Autor").build());
		when(facade.getAutores()).thenReturn(list);
		
		mvc.perform(get("/biblioteca/autores"))
			.andExpect(status().isOk())
			.andExpect(content().json("[{\"id\":1,\"nombre\":\"Autor\"}]"));
	}
	
	@Test
	public void obtenerAutorTest() throws Exception {		
		when(facade.getAutor(1)).thenReturn(AutorResponse.builder().id(1).nombre("Autor").build());
		
		mvc.perform(get("/biblioteca/autores/1"))
			.andExpect(status().isOk())
			.andExpect(content().json("{\"id\":1,\"nombre\":\"Autor\"}"));
	}
	
	@Test
	public void obtenerAutorNotFoundTest() throws Exception {		
		when(facade.getAutor(2)).thenThrow(EntityNotFoundException.class);
		
		mvc.perform(get("/biblioteca/autores/2"))
			.andExpect(status().isNotFound());
	}
	
	@Test
	public void crearAutorTest() throws Exception {
		when(facade.crearAutor(any())).thenReturn(AutorResponse.builder().id(1).nombre("Autor").build());
		
		mvc.perform(post("/biblioteca/autores").contentType(MediaType.APPLICATION_JSON).content("{\"nombre\":\"Autor\"}"))
			.andExpect(status().isOk())
			.andExpect(content().json("{\"id\":1,\"nombre\":\"Autor\"}"));
	}
	
	@Test
	public void editarAutorTest() throws Exception {
		when(facade.editAutor(any(), any())).thenReturn(AutorResponse.builder().id(1).nombre("Autor").build());
		
		mvc.perform(put("/biblioteca/autores/1").contentType(MediaType.APPLICATION_JSON).content("{\"nombre\":\"Autor\"}"))
			.andExpect(status().isOk())
			.andExpect(content().json("{\"id\":1,\"nombre\":\"Autor\"}"));
	}
	
	@Test
	public void eliminarAutorTest() throws Exception {
		when(facade.eliminarAutor(1)).thenReturn(AutorResponse.builder().id(1).nombre("Autor").build());
		
		mvc.perform(delete("/biblioteca/autores/1"))
			.andExpect(status().isOk())
			.andExpect(content().json("{\"id\":1,\"nombre\":\"Autor\"}"));
	}
}
