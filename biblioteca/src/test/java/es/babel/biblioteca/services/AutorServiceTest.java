package es.babel.biblioteca.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import es.babel.biblioteca.modelo.Autor;
import es.babel.biblioteca.repositories.AutorRepository;
import jakarta.persistence.EntityNotFoundException;

@ExtendWith(MockitoExtension.class)
public class AutorServiceTest {
	
	@InjectMocks
	private AutorServiceImpl service; 

	@Mock
	private AutorRepository repository;
	
	private Autor autor;
	
	@BeforeEach
	public void init() {
	    MockitoAnnotations.openMocks(this);
		
	    autor = new Autor();
	    autor.setId(1);
	    autor.setNombre("Autor");
		
	}
	
	@Test
	public void getAutoresTest() {
		List<Autor> autorList = new ArrayList<>();
		autorList.add(autor);
		
		when(repository.findAll()).thenReturn(autorList);
		
		List<Autor> autores = service.getAutores();
		
		assertEquals(1, autores.size());
		assertEquals(autor, autores.get(0));
		
	}
	
	@Test
	public void getAutorTest() {
		when(repository.findById(1)).thenReturn(Optional.of(autor));
		
		Autor a = service.getAutor(1);
		assertEquals(1, a.getId());
		assertEquals("Autor", a.getNombre());
	}
	
	@Test
	public void getAutorTestNotFound() {
		when(repository.findById(2)).thenReturn(Optional.empty());
		
		assertThrows(EntityNotFoundException.class, () -> {
			service.getAutor(2);			
		});
	}
	
	@Test
	public void createAutorTest() {
		when(repository.save(any())).thenReturn(autor);
		
		Autor a = service.createAutor(autor);
		assertEquals(1, a.getId());
		assertEquals("Autor", a.getNombre());
	}
	
	@Test
	public void editAutorTest() {
		when(repository.findById(1)).thenReturn(Optional.of(autor));
		when(repository.save(any())).thenReturn(autor);
		
		Autor a = service.editAutor(1, "Autor");
		assertEquals(1, a.getId());
		assertEquals("Autor", a.getNombre());
	}
	
	@Test
	public void deleteAutorTest() {
		when(repository.findById(1)).thenReturn(Optional.of(autor));
		doNothing().when(repository).delete(autor);
		
		Autor a = service.deleteAutor(1);
		assertEquals(1, a.getId());
		assertEquals("Autor", a.getNombre());
	}
	
	@Test
	public void getAutoresByDocumentoTest() {
		List<Autor> autorList = new ArrayList<>();
		autorList.add(autor);
		
		when(repository.findByDocumento(1)).thenReturn(autorList);
		
		List<Autor> autores = service.getAutoresByDocumento(1);
		
		assertEquals(1, autores.size());
		assertEquals(autor, autores.get(0));
		
	}
}
