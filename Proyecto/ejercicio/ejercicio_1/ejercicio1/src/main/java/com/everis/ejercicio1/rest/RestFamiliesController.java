package com.everis.ejercicio1.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.everis.ejercicio1.models.Families;
import com.everis.ejercicio1.service.IFamiliesService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Families microservice", description = "This API has a CRUD for families")
@RequestMapping("/api/v1/families")
public class RestFamiliesController {

	@Autowired
	private IFamiliesService serv;
	
	/*
	 * @ApiOperation(value = "Return list of families")
	 * 
	 * @GetMapping(produces = {MediaType.APPLICATION_STREAM_JSON_VALUE,
	 * MediaType.APPLICATION_JSON_VALUE}) public
	 * ResponseEntity<Observable<Families>> listar() {
	 * 
	 * List<Families> list = new ArrayList<>(); list = serv.listar();
	 * 
	 * Observable<Families> obsFamilies = Observable.fromIterable(list);
	 * 
	 * return new ResponseEntity<Observable<Families>>(obsFamilies, HttpStatus.OK);
	 * }
	 */
	

	@ApiOperation(value = "Return list of family")
	@GetMapping
	public ResponseEntity<List<Families>> listar() {

		return new ResponseEntity<List<Families>>(serv.listar(), HttpStatus.OK);

	}
	
	
	@ApiOperation(value = "Return list of family by id")
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Optional<Families> listarId(@PathVariable("id") Integer id) { 
		  return serv.listarId(id); }
	 
	
	@ApiOperation(value = "Create new family")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertar(@RequestBody Families fam) {
		serv.registrar(fam);
	}
	
	@ApiOperation(value = "Update family")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String modificar(@RequestBody Families fam) {
		String mensaje = "";
		Optional<Families> obj = serv.listarId(fam.getFamily_id());
		
		if(obj.isPresent()) {
			serv.modificar(fam);
			mensaje = "Modificado con éxito!!";
		}else {
			mensaje = "Pariente no existe";
		}
		
		return mensaje;
	}

	@ApiOperation(value = "Find family by id")
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		serv.eliminar(id);

	}
}
