package io.github.rafael.modelRepository;

import io.github.rafael.modelEntity.Servico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServicoRepository extends JpaRepository<Servico, Integer> {
}
