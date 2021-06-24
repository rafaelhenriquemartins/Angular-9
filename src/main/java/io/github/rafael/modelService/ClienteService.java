package io.github.rafael.modelService;

import io.github.rafael.modelEntity.Cliente;
import io.github.rafael.modelException.ClienteException;

public interface ClienteService {

    void someMethod();

    Cliente acharCliente(Integer id);

    void salvar (Cliente cliente) throws ClienteException;

    void deletarById(Integer id);
      
    void atualizar(Integer id, Cliente cliente);

}
