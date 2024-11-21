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

import dao.PedidoRepositorio;
import model.Pedido;

@RestController
@RequestMapping("/api/pedido")
public class PedidoController {
	
	@Autowired
    private PedidoRepositorio pedidoRepositorio;

    
    @GetMapping
    public List<Pedido> listarPedidos() {
        return pedidoRepositorio.findAll();
    }

    @GetMapping("/{idPedido}")
    public ResponseEntity<Pedido> buscarPedido(@PathVariable Integer idPedido) {
        Optional<Pedido> pedido = pedidoRepositorio.findById(idPedido);
        return pedido.map(ResponseEntity::ok)
                     .orElseGet(() -> ResponseEntity.notFound().build());
    }

   
    @PostMapping
    public ResponseEntity<Pedido> criarPedido(@RequestBody Pedido pedido) {
        Pedido pedidoCriado = pedidoRepositorio.save(pedido);
        return ResponseEntity.status(201).body(pedidoCriado);
    }

    
    @PutMapping("/{idPedido}")
    public ResponseEntity<Pedido> atualizarPedido(@PathVariable Integer idPedido, @RequestBody Pedido pedidoDetalhes) {
        Optional<Pedido> pedidoOptional = pedidoRepositorio.findById(idPedido);
        
        if (pedidoOptional.isPresent()) {
            Pedido pedido = pedidoOptional.get();
            pedido.setDataPedido(pedidoDetalhes.getDataPedido());
            pedido.setStatusPedido(pedidoDetalhes.getStatusPedido());
            
           
            Pedido pedidoAtualizado = pedidoRepositorio.save(pedido);
            return ResponseEntity.ok(pedidoAtualizado);
        }
        
        return ResponseEntity.notFound().build();
    }

   
    @DeleteMapping("/{idPedido}")
    public ResponseEntity<Void> deletarPedido(@PathVariable Integer idPedido) {
        Optional<Pedido> pedido = pedidoRepositorio.findById(idPedido);
        if (pedido.isPresent()) {
            pedidoRepositorio.deleteById(idPedido);
            return ResponseEntity.noContent().build(); 
        }
        return ResponseEntity.notFound().build();
    }

}
