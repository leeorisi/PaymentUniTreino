package br.com.unitreino.Controler;

import br.com.unitreino.Model.ModelPagamento;
import br.com.unitreino.Service.ServicePagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pagamentos")
public class ControlerPagamento {

    @Autowired
    private ServicePagamento servicePagamento;

    @GetMapping
    public List<ModelPagamento> listarTodos() {
        return servicePagamento.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModelPagamento> buscarPorId(@PathVariable int id) {
        return ResponseEntity.ok(servicePagamento.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<ModelPagamento> criar(@RequestBody ModelPagamento pagamento) {
        return ResponseEntity.status(201).body(servicePagamento.criar(pagamento));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModelPagamento> atualizar(@PathVariable int id,
                                                     @RequestBody ModelPagamento pagamento) {
        return ResponseEntity.ok(servicePagamento.atualizar(id, pagamento));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable int id) {
        servicePagamento.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
