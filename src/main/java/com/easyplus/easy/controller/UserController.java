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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/user")
@Tag(name = "Usuarios", description = "Operaciones relacionadas con usuarios")
public class UserController {

	@Autowired
	private ImplUserService service;

	@GetMapping
	@Operation(summary = "Obtener todos los usuarios registrados", description = "Retorna todos los usuarios registrados")
	public ResponseEntity<List<AppUser>> consultaUsuarios() {
		return ResponseEntity.ok(service.getAllusers());
	}

	@GetMapping("/{id}")
	@Operation(summary = "Obtener el usuario registrado por ID", description = "Retorna el usuario registrado un el ID relacionado")
	@Parameter(name = "id", description = "El ID del usuario que desea buscar", example = "1")
	@ApiResponses({ 
			@ApiResponse(responseCode = "200", description = "Usuario consultado exitosamente"),
			@ApiResponse(responseCode = "404", description = "Usuario no encontrado con ese ID") })
	public ResponseEntity<AppUser> consultarUsuarioID(@PathVariable Long id) {
		return ResponseEntity.ok(service.getUserByID(id));
	}

	@PostMapping()
	public ResponseEntity<AppUser> crearUsuario(@Valid @RequestBody AppUser appUser) {
		return new ResponseEntity<>(service.createUser(appUser), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> eliminarUsuario(@PathVariable Long id) {
		service.deleteUser(id);
		return ResponseEntity.ok(Map.of("mensaje", "Usuario eliminado correctamente"));
	}

	@PatchMapping("/{id}")
	public ResponseEntity<AppUser> actualizarUsuario(@PathVariable Long id,
			@RequestBody Map<String, Object> userActualizado) {
		return ResponseEntity.ok(service.updateUser(id, userActualizado));
	}

}
