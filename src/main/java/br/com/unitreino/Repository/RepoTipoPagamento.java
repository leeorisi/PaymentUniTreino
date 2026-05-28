package br.com.unitreino.Repository;

import br.com.unitreino.Model.ModelTipoPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RepoTipoPagamento extends JpaRepository<ModelTipoPagamento, Integer> {
}