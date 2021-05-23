package io.github.rafael.modelRepository;

import io.github.rafael.modelEntity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository <Cliente, Integer> {
}
