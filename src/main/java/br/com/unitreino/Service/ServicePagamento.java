package br.com.unitreino.Service;

import br.com.unitreino.Model.ModelPagamento;
import br.com.unitreino.Model.ModelTipoPagamento;
import br.com.unitreino.Repository.RepoPagamento;
import br.com.unitreino.Repository.RepoTipoPagamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicePagamento {

    @Autowired
    private RepoPagamento repoPagamento;

    @Autowired
    private RepoTipoPagamento repoTipoPagamento;

    public List<ModelPagamento> listarTodos() {
        return repoPagamento.findAll();
    }

    public ModelPagamento buscarPorId(Long id) {
        return repoPagamento.findById(id)
            .orElseThrow(() -> new RuntimeException("Pagamento não encontrado: " + id));
    }

    public ModelPagamento criar(ModelPagamento pagamento) {
        ModelTipoPagamento tipo = repoTipoPagamento
            .findById(pagamento.getTipoPagamento().getId())
            .orElseThrow(() -> new RuntimeException("Tipo de pagamento inválido"));

        pagamento.setTipoPagamento(tipo);
        return repoPagamento.save(pagamento);
    }

    public ModelPagamento atualizar(Long id, ModelPagamento dadosNovos) {
        ModelPagamento existente = buscarPorId(id);

        existente.setNomeCliente(dadosNovos.getNomeCliente());
        existente.setValorTotal(dadosNovos.getValorTotal());
        existente.setValorParcela(dadosNovos.getValorParcela());
        existente.setDataPagamento(dadosNovos.getDataPagamento());
        existente.setDataVencimento(dadosNovos.getDataVencimento());
        existente.setQtdParcela(dadosNovos.getQtdParcela());

        if (dadosNovos.getTipoPagamento() != null) {
            ModelTipoPagamento tipo = repoTipoPagamento
                .findById(dadosNovos.getTipoPagamento().getId())
                .orElseThrow(() -> new RuntimeException("Tipo de pagamento inválido"));
            existente.setTipoPagamento(tipo);
        }

        return repoPagamento.save(existente);
    }

    public void deletar(Long id) {
        buscarPorId(id); 
        repoPagamento.deleteById(id);
    }
}