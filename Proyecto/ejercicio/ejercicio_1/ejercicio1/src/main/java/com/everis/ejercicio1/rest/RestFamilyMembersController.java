package com.everis.ejercicio1.rest;

import java.util.ArrayList;
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

import com.everis.ejercicio1.models.FamilyMembers;
import com.everis.ejercicio1.service.IFamilyMembersService;

import io.reactivex.Observable;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api(value = "Family members microservice", description = "This API has a CRUD for family members")
@RequestMapping("/api/v1/familyMembers")
public class RestFamilyMembersController {

	@Autowired
	private IFamilyMembersService serv;

	@ApiOperation(value = "Return list of families")
	@GetMapping(produces = {MediaType.APPLICATION_STREAM_JSON_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Observable<FamilyMembers>> listar() {

		List<FamilyMembers> list = new ArrayList<>();
		list = serv.listar();
		
		Observable<FamilyMembers> obsFamilyMembers = Observable.fromIterable(list);

		return new ResponseEntity<Observable<FamilyMembers>>(obsFamilyMembers, HttpStatus.OK);
	}
	
	@ApiOperation(value = "Create new family")
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void insertar(@RequestBody FamilyMembers famMembers) {
		serv.registrar(famMembers);
	}
	
	@ApiOperation(value = "Update family")
	@PutMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public String modificar(@RequestBody FamilyMembers famMembers) {
		String mensaje = "";
		Optional<FamilyMembers> obj = serv.listarId(famMembers.getFamily_member_id());
		
		if(obj.isPresent()) {
			serv.modificar(famMembers);
			mensaje = "Modificado con éxito!!";
		}else {
			mensaje = "Pariente no existe";
		}
		
		return mensaje;
	}

	@ApiOperation(value = "Find family members by id")
	@DeleteMapping("/{id}")
	public void eliminar(@PathVariable("id") Integer id) {
		serv.eliminar(id);

	}

}
