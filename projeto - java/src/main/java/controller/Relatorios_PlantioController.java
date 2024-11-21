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

import dao.Relatorios_PlantioRepositorio;
import model.Relatorios_Plantio;

@RestController
@RequestMapping("/api/relatorios_plantio")
public class Relatorios_PlantioController {
	@Autowired
    private Relatorios_PlantioRepositorio Relatorios_PlantioRepositorio;

    
    @GetMapping
    public List<Relatorios_Plantio> listarRelatoriosPlantio() {
        return Relatorios_PlantioRepositorio.findAll();
    }

    
    @GetMapping("/{idRelatorios_Plantio}")
    public ResponseEntity<Relatorios_Plantio> buscarRelatorios_Plantio(@PathVariable Integer idRelatorios_Plantio) {
        Optional<Relatorios_Plantio> Relatorios_Plantio = Relatorios_PlantioRepositorio.findById(idRelatorios_Plantio);
        return Relatorios_Plantio.map(ResponseEntity::ok)
                               .orElseGet(() -> ResponseEntity.notFound().build());
    }

   
    @PostMapping
    public ResponseEntity<Relatorios_Plantio> criarRelatorios_Plantio(@RequestBody Relatorios_Plantio Relatorios_Plantio) {
        Relatorios_Plantio Relatorios_PlantioCriado = Relatorios_PlantioRepositorio.save(Relatorios_Plantio);
        return ResponseEntity.status(201).body(Relatorios_PlantioCriado);
    }

    
    @PutMapping("/{idRelatorios_Plantio}")
    public ResponseEntity<Relatorios_Plantio> atualizarRelatorios_Plantio(@PathVariable Integer idRelatorios_Plantio, @RequestBody Relatorios_Plantio Relatorios_PlantioDetalhes) {
        Optional<Relatorios_Plantio> Relatorios_PlantioOptional = Relatorios_PlantioRepositorio.findById(idRelatorios_Plantio);
        
        if (Relatorios_PlantioOptional.isPresent()) {
            Relatorios_Plantio Relatorios_Plantio = Relatorios_PlantioOptional.get();
            Relatorios_Plantio.setTipoPlantacao(Relatorios_PlantioDetalhes.getTipoPlantacao());
            Relatorios_Plantio.setSecaoPlantacao(Relatorios_PlantioDetalhes.getSecaoPlantacao());
            Relatorios_Plantio.setDataDoPlantio(Relatorios_PlantioDetalhes.getDataDoPlantio());
            Relatorios_Plantio.setAguaUtilizada(Relatorios_PlantioDetalhes.getAguaUtilizada());
            Relatorios_Plantio.setAgrotoxicosUtilizados(Relatorios_PlantioDetalhes.getAgrotoxicosUtilizados());
            Relatorios_Plantio.setPrevisaoColheita(Relatorios_PlantioDetalhes.getPrevisaoColheita());

           
            Relatorios_Plantio Relatorios_PlantioAtualizado = Relatorios_PlantioRepositorio.save(Relatorios_Plantio);
            return ResponseEntity.ok(Relatorios_PlantioAtualizado);
        }

        return ResponseEntity.notFound().build();
    }

    
    @DeleteMapping("/{idRelatorios_Plantio}")
    public ResponseEntity<Void> deletarRelatorios_Plantio(@PathVariable Integer idRelatorios_Plantio) {
        Optional<Relatorios_Plantio> Relatorios_Plantio = Relatorios_PlantioRepositorio.findById(idRelatorios_Plantio);
        if (Relatorios_Plantio.isPresent()) {
            Relatorios_PlantioRepositorio.deleteById(idRelatorios_Plantio);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

}
