package io.github.rafael.modelService;

import io.github.rafael.modelEntity.Cliente;
import io.github.rafael.modelRepository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ClienteService {

    @Autowired
    private ClientRepository clientRepository;

    public Cliente acharCliente(Integer id) {
        return clientRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    public void deletar(Integer id) {
        clientRepository.findById(id)
                .map( cliente -> {
                    clientRepository.delete(cliente);
                    return Void.TYPE;
                })
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }


    public void atualizar(Integer id, Cliente cliente) {
        clientRepository.findById(id)
                .map( cli -> {
                    cli.setNome(cliente.getNome());
                    cli.setCpf(cliente.getCpf());
                    return clientRepository.save(cli);
                })
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
