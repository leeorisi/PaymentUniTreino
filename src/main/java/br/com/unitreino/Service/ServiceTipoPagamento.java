package br.com.unitreino.Service;

import br.com.unitreino.Model.ModelTipoPagamento;
import br.com.unitreino.Repository.RepoTipoPagamento;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTipoPagamento {
    
    @Autowired
    private RepoTipoPagamento repoTipoPagamento;

    public List<ModelTipoPagamento> listarTodos() {
        return repoTipoPagamento.findAll();
    }

    public ModelTipoPagamento buscarPorId(Long id) {
        return repoTipoPagamento.findById(id)
            .orElseThrow(() -> new RuntimeException("Tipo de pagamento não encontrado: " + id));
    }

    public ModelTipoPagamento criar(ModelTipoPagamento tipoPagamento) {
        return repoTipoPagamento.save(tipoPagamento);
    }

    public ModelTipoPagamento atualizar(Long id, ModelTipoPagamento dadosNovos) {
        ModelTipoPagamento existente = buscarPorId(id);

        existente.setId(dadosNovos.getId());
        existente.setDescricao(dadosNovos.getDescricao());

        return repoTipoPagamento.save(existente);
    }

    public void deletar(Long id) {
        buscarPorId(id); 
        repoTipoPagamento.deleteById(id);
    }

}
