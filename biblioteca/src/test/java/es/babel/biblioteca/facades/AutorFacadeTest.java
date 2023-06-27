package es.babel.biblioteca.facades;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import es.babel.biblioteca.mappers.AutorMapper;
import es.babel.biblioteca.mappers.AutorMapperImpl;
import es.babel.biblioteca.modelo.Autor;
import es.babel.biblioteca.services.AutorService;
import es.babel.biblioteca.web.dto.request.AutorRequest;
import es.babel.biblioteca.web.dto.response.AutorResponse;

@ExtendWith(MockitoExtension.class)
public class AutorFacadeTest {

	@InjectMocks
	AutorFacadeImpl facade;
	
	@Mock
	AutorService service;
	
	@Spy
	AutorMapper mapper = new AutorMapperImpl();
	
	private List<Autor> autorList = new ArrayList<>();
	
	@BeforeEach
	public void init() {
	    MockitoAnnotations.openMocks(this);
		
	    Autor a1 = new Autor();
		a1.setId(1);
		a1.setNombre("Autor1");
		autorList.add(a1);
		Autor a2 = new Autor();
		a2.setId(2);
		a2.setNombre("Autor2");
		autorList.add(a2);
		
	}
	
	
	@Test
	public void getAutoresTest() {
		when(service.getAutores()).thenReturn(autorList);
		
		List<AutorResponse> autores = facade.getAutores();
		
		assertEquals(2, autores.size());
		
	}
	
	@Test
	public void getAutorTest() {
		Autor a1 = autorList.get(0);
		
		when(service.getAutor(1)).thenReturn(a1);
		
		AutorResponse autor = facade.getAutor(1);
		
		assertEquals(1, autor.getId());
		assertEquals("Autor1", autor.getNombre());
	}
	
	@Test
	public void editAutorTest() {
		Autor a = new Autor();
		a.setId(1);
		a.setNombre("Autor");
		
		when(service.editAutor(1, "Autor")).thenReturn(a);
		
		AutorRequest req = new AutorRequest();
		req.setNombre("Autor");
		
		AutorResponse autor = facade.editAutor(1, req);
		
		assertEquals("Autor", autor.getNombre());
	}
	
	@Test
	public void crearAutorTest() {
		Autor a = new Autor();
		a.setId(3);
		a.setNombre("Autor");
		
		when(service.createAutor(any())).thenReturn(a);
		
		AutorRequest req = new AutorRequest();
		req.setNombre("Autor");
		
		AutorResponse autor = facade.crearAutor(req);
		assertEquals(3, autor.getId());
		assertEquals("Autor", autor.getNombre());
	}

	@Test
	public void eliminarAutorTest() {
		Autor a = new Autor();
		a.setId(1);
		a.setNombre("Autor");
		
		when(service.deleteAutor(1)).thenReturn(a);
		
		AutorResponse autor = facade.eliminarAutor(1);
		assertEquals(1, autor.getId());
		
	}
}
