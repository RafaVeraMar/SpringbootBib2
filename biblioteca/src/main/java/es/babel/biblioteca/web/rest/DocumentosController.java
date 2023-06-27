package es.babel.biblioteca.web.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.babel.biblioteca.facades.DocumentoFacade;
import es.babel.biblioteca.web.dto.request.DocumentoReq;
import es.babel.biblioteca.web.dto.response.DocumentoResp;

@RestController
@RequestMapping("/biblioteca/documentos")
public class DocumentosController {

	private DocumentoFacade facade;

	@Autowired
	public DocumentosController(DocumentoFacade facade) {
		this.facade = facade;
	}
	
	@GetMapping
	public ResponseEntity<List<DocumentoResp>> obtenerDocumentos() {
		final List<DocumentoResp> documentos = facade.obtenerDocumentos();
		return new ResponseEntity<List<DocumentoResp>>(documentos, HttpStatus.OK);
	}
	
	@GetMapping("/{idDocumento}")
	public ResponseEntity<DocumentoResp> obtenerDocumento(@PathVariable Integer idDocumento) {
		final DocumentoResp documento = facade.obtenerDocumento(idDocumento);
		return new ResponseEntity<DocumentoResp>(documento, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<DocumentoResp> crearDocumento(@RequestBody DocumentoReq body) {
		final DocumentoResp documento = facade.crearDocumento(body);
		return new ResponseEntity<DocumentoResp>(documento, HttpStatus.OK);
	}
	
	
	@PatchMapping("/{idDocumento}")
	public ResponseEntity<DocumentoResp> editarDocumento(@PathVariable Integer idDocumento, @RequestBody DocumentoReq body) {
		final DocumentoResp documento = facade.editarDocumento(idDocumento, body);
		return new ResponseEntity<DocumentoResp>(documento, HttpStatus.OK);
	}
	
	@DeleteMapping("/{idDocumento}")
	public ResponseEntity<DocumentoResp> eliminarDocumento(@PathVariable Integer idDocumento) {
		final DocumentoResp documento = facade.eliminarDocumento(idDocumento);
		return new ResponseEntity<DocumentoResp>(documento, HttpStatus.OK);
	}
}
