package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dao.ProdutoRepositorio;
import model.Produto;

@RestController
@RequestMapping("/api/produto")
public class ProdutoController {

	@Autowired
    private ProdutoRepositorio produtoRepositorio;

    
    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoRepositorio.findAll();
    }

    
    @GetMapping("/{idProduto}")
    public ResponseEntity<Produto> buscarProduto(@PathVariable Integer idProduto) {
        Optional<Produto> produto = produtoRepositorio.findById(idProduto);
        return produto.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

   
    @PostMapping
    public ResponseEntity<Produto> criarProduto(@RequestBody Produto produto) {
        Produto produtoCriado = produtoRepositorio.save(produto);
        return ResponseEntity.status(201).body(produtoCriado);
    }

   
    @PutMapping("/{idProduto}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Integer idProduto, @RequestBody Produto produtoDetalhes) {
        Optional<Produto> produtoOptional = produtoRepositorio.findById(idProduto);
        
        if (produtoOptional.isPresent()) {
            Produto produto = produtoOptional.get();
            produto.setNomeProduto(produtoDetalhes.getNomeProduto());
            produto.setPrecoProduto(produtoDetalhes.getPrecoProduto());
            produto.setEstoqueProduto(produtoDetalhes.getEstoqueProduto());
            produto.setValidadeProduto(produtoDetalhes.getValidadeProduto());
            
            
            Produto produtoAtualizado = produtoRepositorio.save(produto);
            return ResponseEntity.ok(produtoAtualizado);
        }
        
        return ResponseEntity.notFound().build();
    }

    
    @DeleteMapping("/{idProduto}")
    public ResponseEntity<Void> deletarProduto(@PathVariable Integer idProduto) {
        Optional<Produto> produto = produtoRepositorio.findById(idProduto);
        if (produto.isPresent()) {
            produtoRepositorio.deleteById(idProduto);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
