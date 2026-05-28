package br.com.unitreino.Repository;

import br.com.unitreino.Model.ModelPagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepoPagamento extends JpaRepository<ModelPagamento, Integer> {
}