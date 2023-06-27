package es.babel.usuarios.web.rest;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import es.babel.usuarios.facades.UsuarioFacade;
import es.babel.usuarios.web.dto.UsuarioDto;
import es.babel.usuarios.web.dto.request.PrestamoRequest;
import es.babel.usuarios.web.dto.response.PrestamoResponse;
import es.babel.usuarios.web.dto.response.PrestamosUsuarioResponse;
import jakarta.persistence.EntityNotFoundException;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
public class UsuariosControlerTest {

	@MockBean
	private UsuarioFacade facade;
	
	@Autowired
    private MockMvc mvc;
	
	@Test
	public void obtenerUsuarioUnauthorizedTest() throws Exception {
		
		mvc.perform(get("/usuarios/1"))
		.andExpect(status().isUnauthorized());
	}
	
	@WithMockUser("admin")
	@Test
	public void obtenerUsuarioOkTest() throws Exception {
		UsuarioDto usuario = new UsuarioDto();
		usuario.setId(1);
		usuario.setNombre("Usuario");
		when(facade.getUsuario(1)).thenReturn(usuario);
		
		mvc.perform(get("/usuarios/1"))
			.andExpect(status().isOk())
			.andExpect(content().json("{\"id\":1,\"nombre\":\"Usuario\",\"apellidos\":null,\"correo\":null,\"telefono\":null,\"activo\":null}"));
	}
	
	@WithMockUser("admin")
	@Test
	public void obtenerUsuarioNotFoundTest() throws Exception {
		when(facade.getUsuario(2)).thenThrow(EntityNotFoundException.class);
		
		mvc.perform(get("/usuarios/2"))
			.andExpect(status().isNotFound());
	}
	
	@WithMockUser("admin")
	@Test
	public void crearUsuarioOkTest() throws Exception {
		UsuarioDto usuario = new UsuarioDto();
		usuario.setId(1);
		usuario.setNombre("Usuario");
		when(facade.createUsuario(usuario)).thenReturn(usuario);
		
		mvc.perform(post("/usuarios").content("{\"id\":1,\"nombre\":\"Usuario\"}").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated())
			.andExpect(content().json("{\"id\":1,\"nombre\":\"Usuario\",\"apellidos\":null,\"correo\":null,\"telefono\":null,\"activo\":null}"));
	}
	
	@WithMockUser("admin")
	@Test
	public void editarUsuarioOkTest() throws Exception {
		UsuarioDto usuario = new UsuarioDto();
		usuario.setId(1);
		usuario.setNombre("Usuario");
		when(facade.editUsuario(1, usuario)).thenReturn(usuario);
		
		mvc.perform(patch("/usuarios/1").content("{\"id\":1,\"nombre\":\"Usuario\"}").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk())
			.andExpect(content().json("{\"id\":1,\"nombre\":\"Usuario\",\"apellidos\":null,\"correo\":null,\"telefono\":null,\"activo\":null}"));
	}
	
	@WithMockUser("admin")
	@Test
	public void eliminarUsuarioOkTest() throws Exception {
		UsuarioDto usuario = new UsuarioDto();
		usuario.setId(1);
		usuario.setNombre("Usuario");
		when(facade.deleteUsuario(1)).thenReturn(usuario);
		
		mvc.perform(delete("/usuarios/1"))
			.andExpect(status().isOk())
			.andExpect(content().json("{\"id\":1,\"nombre\":\"Usuario\",\"apellidos\":null,\"correo\":null,\"telefono\":null,\"activo\":null}"));
	}
	
	@WithMockUser("admin")
	@Test
	public void obtenerUsuarioPrestamoOkTest() throws Exception {
		UsuarioDto usuario = new UsuarioDto();
		usuario.setId(1);
		usuario.setNombre("Usuario");
		List<PrestamoResponse> prestamos = new ArrayList<>();
		PrestamoResponse prestamo = PrestamoResponse.builder().documento("Titulo").fechaRecogida("21/06/2023").build();
		prestamos.add(prestamo);
		PrestamosUsuarioResponse prestamosUsuario = PrestamosUsuarioResponse.builder().usuario(usuario).prestamos(prestamos).build();
		when(facade.getPrestamos(1)).thenReturn(prestamosUsuario);
		
		mvc.perform(get("/usuarios/1/prestamos"))
			.andExpect(status().isOk())
			.andExpect(content().json("{\"usuario\":{\"id\":1,\"nombre\":\"Usuario\",\"apellidos\":null,\"correo\":null,\"telefono\":null,\"activo\":null},\"prestamos\":[{\"documento\":\"Titulo\",\"fechaRecogida\":\"21/06/2023\",\"fechaDevolucion\":null}]}"));
	}
	
	@WithMockUser("admin")
	@Test
	public void crearUsuarioPrestamoOkTest() throws Exception {
		//Request
		PrestamoRequest req = new PrestamoRequest();
		req.setDocumento(1);
		req.setRecogida(new Date(2023,6,23));
		
		//Response
		UsuarioDto usuario = new UsuarioDto();
		usuario.setId(1);
		usuario.setNombre("Usuario");
		List<PrestamoResponse> prestamos = new ArrayList<>();
		PrestamoResponse prestamo = PrestamoResponse.builder().documento("Titulo").fechaRecogida("21/06/2023").build();
		prestamos.add(prestamo);
		PrestamosUsuarioResponse prestamosUsuario = PrestamosUsuarioResponse.builder().usuario(usuario).prestamos(prestamos).build();
		
		when(facade.addLendToUser(1, req)).thenReturn(prestamosUsuario);
		
		mvc.perform(post("/usuarios/1/prestamo").content("{\"documento\":1,\"recogida\":\"2023-06-21\"}").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isCreated());
	}
	
	@WithMockUser("admin")
	@Test
	public void editarUsuarioPrestamoOkTest() throws Exception {
		//Request
		PrestamoRequest req = new PrestamoRequest();
		req.setDocumento(1);
		req.setDevolucion(new Date(2023,6,23));
		
		//Response
		UsuarioDto usuario = new UsuarioDto();
		usuario.setId(1);
		usuario.setNombre("Usuario");
		List<PrestamoResponse> prestamos = new ArrayList<>();
		PrestamoResponse prestamo = PrestamoResponse.builder().documento("Titulo").fechaRecogida("21/06/2023").fechaDevolucion("21/06/2023").build();
		prestamos.add(prestamo);
		PrestamosUsuarioResponse prestamosUsuario = PrestamosUsuarioResponse.builder().usuario(usuario).prestamos(prestamos).build();
		
		when(facade.addLendToUser(1, req)).thenReturn(prestamosUsuario);
		
		mvc.perform(put("/usuarios/1/prestamo/1").content("{\"documento\":1,\"devolucion\":\"2023-06-21\"}").contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}
	
	
	
}
