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

import dao.FornecedorRepositorio;
import model.Fornecedor;

@RestController
@RequestMapping("/api/fornecedor")
public class FornecedorController {
	
	@Autowired
	private FornecedorRepositorio fornecedorRepositorio;
	
	@GetMapping
	public List<Fornecedor> listarFornecedores(){
		return fornecedorRepositorio.findAll();
	}
	
	@GetMapping("/{idFornecedor}")
	public ResponseEntity<Fornecedor> buscarFornecedor(@PathVariable Integer idFornecedor){
	Optional<Fornecedor> fornecedor = fornecedorRepositorio.findById(idFornecedor);
    return fornecedor.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

	@PostMapping
	public ResponseEntity<Fornecedor> criarFornecedor(@RequestBody Fornecedor fornecedor) {
    Fornecedor fornecedorCriado = fornecedorRepositorio.save(fornecedor);
    return ResponseEntity.status(201).body(fornecedorCriado);
}
    @PutMapping("/{idFornecedor}")
    public ResponseEntity<Fornecedor> atualizarFornecedor(@PathVariable Integer idFornecedor, @RequestBody Fornecedor fornecedorDetalhes) {
       Optional<Fornecedor> fornecedorOptional = fornecedorRepositorio.findById(idFornecedor);
       
        if (fornecedorOptional.isPresent()) {
            Fornecedor fornecedor = fornecedorOptional.get();
            fornecedor.setNomeFornecedor(fornecedorDetalhes.getNomeFornecedor());
            fornecedor.setEmailFornecedor(fornecedorDetalhes.getEmailFornecedor());
            fornecedor.setTelefoneFornecedor(fornecedorDetalhes.getTelefoneFornecedor());
            
            Fornecedor fornecedorAtualizado = fornecedorRepositorio.save(fornecedor);
            return ResponseEntity.ok(fornecedorAtualizado);
        }
        
        return ResponseEntity.notFound().build();
    }

}
