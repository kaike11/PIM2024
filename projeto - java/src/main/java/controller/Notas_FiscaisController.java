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

import dao.Notas_FiscaisRepositorio;
import model.Notas_Fiscais;

@RestController
@RequestMapping("/api/notas_fiscais")
public class Notas_FiscaisController {
	
	@Autowired
    private Notas_FiscaisRepositorio Notas_FiscaisRepositorio;

  
    @GetMapping
    public List<Notas_Fiscais> listarNotasFiscais() {
        return Notas_FiscaisRepositorio.findAll();
    }

    
    @GetMapping("/{idNotas_Fiscais}")
    public ResponseEntity<Notas_Fiscais> buscarNotas_Fiscais(@PathVariable Integer idNotas_Fiscais) {
        Optional<Notas_Fiscais> Notas_Fiscais = Notas_FiscaisRepositorio.findById(idNotas_Fiscais);
        return Notas_Fiscais.map(ResponseEntity::ok)
                         .orElseGet(() -> ResponseEntity.notFound().build());
    }

    
    @PostMapping
    public ResponseEntity<Notas_Fiscais> criarNotas_Fiscais(@RequestBody Notas_Fiscais Notas_Fiscais) {
        Notas_Fiscais Notas_FiscaisCriada = Notas_FiscaisRepositorio.save(Notas_Fiscais);
        return ResponseEntity.status(201).body(Notas_FiscaisCriada);
    }

    
    @PutMapping("/{idNotas_Fiscais}")
    public ResponseEntity<Notas_Fiscais> atualizarNotas_Fiscais(@PathVariable Integer idNotas_Fiscais, @RequestBody Notas_Fiscais Notas_FiscaisDetalhes) {
        Optional<Notas_Fiscais> Notas_FiscaisOptional = Notas_FiscaisRepositorio.findById(idNotas_Fiscais);
        
        if (Notas_FiscaisOptional.isPresent()) {
            Notas_Fiscais Notas_Fiscais = Notas_FiscaisOptional.get();
            Notas_Fiscais.setDataDeEmissao(Notas_FiscaisDetalhes.getDataDeEmissao());
            Notas_Fiscais.setValorTotal(Notas_FiscaisDetalhes.getValorTotal());

            
            Notas_Fiscais Notas_FiscaisAtualizada = Notas_FiscaisRepositorio.save(Notas_Fiscais);
            return ResponseEntity.ok(Notas_FiscaisAtualizada);
        }

        return ResponseEntity.notFound().build();
    }

    
    @DeleteMapping("/{idNotas_Fiscais}")
    public ResponseEntity<Void> deletarNotas_Fiscais(@PathVariable Integer idNotas_Fiscais) {
        Optional<Notas_Fiscais> Notas_Fiscais = Notas_FiscaisRepositorio.findById(idNotas_Fiscais);
        if (Notas_Fiscais.isPresent()) {
            Notas_FiscaisRepositorio.deleteById(idNotas_Fiscais);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
