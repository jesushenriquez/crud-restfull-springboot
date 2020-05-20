/**
 * 
 */
package com.jesushenriquez.demo.resource;

import java.util.List;

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

import com.jesushenriquez.demo.model.User;
import com.jesushenriquez.demo.resource.vo.UserVO;
import com.jesushenriquez.demo.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author jesushenriquez
 *
 */
@RestController
@RequestMapping("/demo/user")
@Api(tags = "user")
public class UserResource {
	
	private final UserService userService;
	
	public UserResource(UserService userService) {
		this.userService = userService;
	}
	
	@PostMapping
	@ApiOperation(value = "Crear Usuario", notes = "Servicios para crear un nuevo usuario")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Usuario creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud Invalida") })
	public ResponseEntity<User> createUser(@RequestBody UserVO userVo){
		
		User user = new User();
		
		user.setEmail(userVo.getEmail());
		user.setUsername(userVo.getUsername());
		user.setPassword(userVo.getPassword());
		
		return new ResponseEntity<User>(this.userService.create(user), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	@ApiOperation(value = "Actualizar Usuario", notes = "Servicios para actualizar un usuario")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Usuario actualizado correctamente"),
			@ApiResponse(code = 404, message = "Usuario no encontrado") })
	public ResponseEntity<User> updateUser(@PathVariable("id") int id, @RequestBody UserVO userVo){
		
		User user = this.userService.findById(id);
		
		if (user == null) {
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		} else {
			user.setEmail(userVo.getEmail());
			user.setUsername(userVo.getUsername());
			user.setPassword(userVo.getPassword());
		}
		
		return new ResponseEntity<User>(this.userService.update(user), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	@ApiOperation(value = "Eliminar Usuario", notes = "Servicios para eliminar un usuario")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Usuario actualizado correctamente"),
			@ApiResponse(code = 404, message = "Usuario no encontrado") })
	public void removeUser(@PathVariable("id") int id) {
		User user = this.userService.findById(id);
		
		if (user != null) {
			this.userService.delete(user);
		}
	}
	
	@GetMapping
	@ApiOperation(value = "Listar Usuarios", notes = "Servicios para listar todos los usuarios")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Usuarios encontrados correctamente"),
			@ApiResponse(code = 404, message = "Usuarios no encontrados") })
	public ResponseEntity<List<User>> findAll(){
		return ResponseEntity.ok(this.userService.findAll());
	}
	

}
