package br.com.unitreino.Repository;

import br.com.unitreino.Model.ModelPagamento;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

@Repository
public class RepoPagamento {
    private final Map<Long, ModelPagamento> store = new ConcurrentHashMap<>();
	private final AtomicLong idGenerator = new AtomicLong(1);

	public ModelPagamento save(ModelPagamento pagamento) {
		if (pagamento.getId() == null) {
			pagamento.setId(idGenerator.getAndIncrement());
		}
		store.put(pagamento.getId(), pagamento);
		return pagamento;
	}

	public List<ModelPagamento> findAll() {
		Collection<ModelPagamento> values = store.values();
		return new ArrayList<>(values);
	}

	public Optional<ModelPagamento> findById(Long id) {
		return Optional.ofNullable(store.get(id));
	}


	public void deleteById(Long id) {
		store.remove(id);
    }
}
