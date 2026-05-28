package br.com.unitreino.Repository;

import br.com.unitreino.Model.ModelTipoPagamento;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

@Repository
public class RepoTipoPagamento {
    private final Map<Long, ModelTipoPagamento> store = new ConcurrentHashMap<>();
	private final AtomicLong idGenerator = new AtomicLong(1);

	public ModelTipoPagamento save(ModelTipoPagamento tipoPagamento) {
		if (tipoPagamento.getId() == null) {
			tipoPagamento.setId(idGenerator.getAndIncrement());
		}
		store.put(tipoPagamento.getId(), tipoPagamento);
		return tipoPagamento;
	}

	public List<ModelTipoPagamento> findAll() {
		Collection<ModelTipoPagamento> values = store.values();
		return new ArrayList<>(values);
	}

	public Optional<ModelTipoPagamento> findById(Long id) {
		return Optional.ofNullable(store.get(id));
	}


	public void deleteById(Long id) {
		store.remove(id);
    }
}