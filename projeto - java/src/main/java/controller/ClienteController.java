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

import dao.ClienteRepositorio;
import model.Cliente;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	
	@GetMapping
	public List<Cliente> listarCliente(){
		return clienteRepositorio.findAll();
	}
	
	@GetMapping("/{idCliente}")
	public ResponseEntity<Cliente> buscarCliente(@PathVariable Integer idCliente){
		Optional<Cliente> cliente = clienteRepositorio.findById(idCliente);
		return cliente.map(ResponseEntity::ok)
				.orElseGet(() -> ResponseEntity.notFound().build());
	}
	
	@PostMapping
	public ResponseEntity<Cliente> criarCliente(@RequestBody Cliente cliente) {
        Cliente clienteCriado = clienteRepositorio.save(cliente);
        return ResponseEntity.status(201).body(clienteCriado);
    }
	
	@PutMapping("/{idCliente}")
    public ResponseEntity<Cliente> atualizarCliente(@PathVariable Integer idCliente, @RequestBody Cliente clienteDetalhes) {
        Optional<Cliente> clienteOptional = clienteRepositorio.findById(idCliente);
        if (clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();
            cliente.setNomeCliente(clienteDetalhes.getNomeCliente());
            cliente.setEmailCliente(clienteDetalhes.getEmailCliente());
            cliente.setEnderecoCliente(clienteDetalhes.getEnderecoCliente());
            cliente.setTelefoneCliente(clienteDetalhes.getTelefoneCliente());

            Cliente clienteAtualizado = clienteRepositorio.save(cliente);
            return ResponseEntity.ok(clienteAtualizado);
        }
        return ResponseEntity.notFound().build();
    }
	
	
}
