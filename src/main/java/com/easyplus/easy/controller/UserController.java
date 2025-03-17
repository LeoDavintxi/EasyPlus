package com.easyplus.easy.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.easyplus.easy.entity.AppUser;
import com.easyplus.easy.service.ImplUserService;
import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/v1/user")
public class UserController{
	
	@Autowired
	private ImplUserService service;
	
	@GetMapping
	public ResponseEntity<List<AppUser>> consultaUsuarios(){
		return ResponseEntity.ok(service.getAllusers());
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AppUser> consultarUsuarioID(@PathVariable Long id) {
		return ResponseEntity.ok(service.getUserByID(id));
	}
	
	@PostMapping()
	public ResponseEntity<AppUser> crearUsuario(@Valid @RequestBody AppUser appUser) {
        return new ResponseEntity<>(service.createUser(appUser), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminarUsuario(@PathVariable Long id){
		service.deleteUser(id);
		return ResponseEntity.ok(Map.of("mensaje", "Usuario eliminado correctamente"));
	}
	
	@PatchMapping("/{id}")
	public ResponseEntity<AppUser> actualizarUsuario(@PathVariable Long id, @RequestBody Map<String, Object> userActualizado){
		return ResponseEntity.ok(service.updateUser(id, userActualizado));
	}
	
	

}
