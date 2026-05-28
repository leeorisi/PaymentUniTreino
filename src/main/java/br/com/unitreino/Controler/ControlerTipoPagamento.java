package br.com.unitreino.Controler;

import br.com.unitreino.Model.ModelTipoPagamento;
import br.com.unitreino.Service.ServiceTipoPagamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipoPagamentos")
public class ControlerTipoPagamento {

    @Autowired
    private ServiceTipoPagamento serviceTipoPagamento;

    @GetMapping
    public List<ModelTipoPagamento> listarTodos() {
        return serviceTipoPagamento.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelTipoPagamento> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(serviceTipoPagamento.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ModelTipoPagamento> criar(@RequestBody ModelTipoPagamento pagamento) {
        return ResponseEntity.status(201).body(serviceTipoPagamento.criar(pagamento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelTipoPagamento> atualizar(@PathVariable Long id,
        @RequestBody ModelTipoPagamento pagamento) {
        return ResponseEntity.ok(serviceTipoPagamento.atualizar(id, pagamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        serviceTipoPagamento.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
