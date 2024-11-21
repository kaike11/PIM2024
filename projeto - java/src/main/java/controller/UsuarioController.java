package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.UsuarioRepositorio;
import model.Usuario;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioRepositorio usuarioRepositorio;
	
	@GetMapping
	public List<Usuario> listarUsuarios(){
		return usuarioRepositorio.findAll();
	}
	
	@GetMapping("/{idUsuario}")
	public ResponseEntity<Usuario> buscarUsuario(@PathVariable Integer idUsuario){
		Optional<Usuario> usuario = usuarioRepositorio.findById(idUsuario);
		return usuario.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public Usuario criarUsuario(@RequestBody Usuario usuario) {
		return usuarioRepositorio.save(usuario);
	}
	@PutMapping("/{idUsuario}")
	public ResponseEntity<Usuario> atualizarUsuario(@PathVariable Integer idUsuario, @RequestBody Usuario usuarioDetalhes){
		Optional<Usuario> usuarioOptional = usuarioRepositorio.findById(idUsuario);
		if (usuarioOptional.isPresent()) {
			Usuario usuario = usuarioOptional.get();
			usuario.setNomeUsuario(usuarioDetalhes.getNomeUsuario());
			usuario.setEmailUsuario(usuarioDetalhes.getEmailUsuario());
			usuario.setSenhaUsuario(usuarioDetalhes.getSenhaUsuario());
			usuario.setTelefoneUsuario(usuarioDetalhes.getTelefoneUsuario());
			Usuario usuarioAtualizado = usuarioRepositorio.save(usuario);
			return ResponseEntity.ok(usuarioAtualizado);
		}
		return ResponseEntity.notFound().build();
		
	}
}
