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

import com.everis.ejercicio1.models.Parents;
import com.everis.ejercicio1.service.IParentsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@RestController
@Api(value = "Parents microservice", description = "This API has a CRUD for parents")
@RequestMapping("/api/v1/parents")
public class RestParentsController {
	
	@Autowired
	private IParentsService serv;
	
	@ApiOperation(value = "Return list of parents")
	@GetMapping
	public ResponseEntity<List<Parents>> listar() {

		/*
		 * List<Parents> list = new ArrayList<>(); list =
		 */
		//serv.listar()
		
		//Observable<Parents> obsPersona = Observable.fromIterable(list);
		return new ResponseEntity<List<Parents>>(serv.listar(), HttpStatus.OK);

	//	return new ResponseEntity<List<Parents>>(,HttpStatus.OK);
	}
	
	
	@ApiOperation(value = "Create new parent")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertar(@RequestBody Parents per) {
		serv.registrar(per);
	}
	
	@ApiOperation(value = "Update parent")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String modificar(@RequestBody Parents per) {
		String mensaje = "";
		Optional<Parents> obj = serv.listarId(per.getParent_id());
		
		if(obj.isPresent()) {
			serv.modificar(per);
			mensaje = "Modificado con éxito!!";
		}else {
			mensaje = "Pariente no existe";
		}
		
		return mensaje;
	}

	@ApiOperation(value = "Find parent by id")
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		serv.eliminar(id);

	}

}
