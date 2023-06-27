package es.babel.biblioteca.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.babel.biblioteca.facades.EditorialFacade;
import es.babel.biblioteca.web.dto.request.EditorialReq;
import es.babel.biblioteca.web.dto.response.EditorialResp;

@RestController
@RequestMapping("/biblioteca/editoriales")
public class EditorialController {

	private EditorialFacade facade;

	@Autowired
	public EditorialController(EditorialFacade facade) {
		this.facade = facade;
	}
	
	@GetMapping
	public ResponseEntity<List<EditorialResp>> obtenerEditoriales() {
		final List<EditorialResp> editoriales = facade.getEditoriales();
		return new ResponseEntity<List<EditorialResp>>(editoriales, HttpStatus.OK);
	}
	
	@GetMapping("/{idEditorial}")
	public ResponseEntity<EditorialResp> obtenerEditorial(@PathVariable Integer idEditorial) {
		final EditorialResp editorial = facade.getEditorial(idEditorial);
		return new ResponseEntity<EditorialResp>(editorial, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<EditorialResp> crearEditorial(@RequestBody EditorialReq body) {
		final EditorialResp editorial = facade.createEditorial(body);
		return new ResponseEntity<EditorialResp>(editorial, HttpStatus.OK);
	}
	
	@PutMapping("/{idEditorial}")
	public ResponseEntity<EditorialResp> editarEditorial(@PathVariable Integer idEditorial, @RequestBody EditorialReq body) {
		final EditorialResp editorial = facade.editEditorial(idEditorial, body);
		return new ResponseEntity<EditorialResp>(editorial, HttpStatus.OK);
	}
	
	@DeleteMapping("/{idEditorial}")
	public ResponseEntity<EditorialResp> eliminarEditorial(@PathVariable Integer idEditorial) {
		final EditorialResp editorial = facade.deleteEditorial(idEditorial);
		return new ResponseEntity<EditorialResp>(editorial, HttpStatus.OK);
	}
	
}
