package io.github.rafael.modelServiceImpl;

import io.github.rafael.modelEntity.Cliente;
import io.github.rafael.modelException.ClienteException;
import io.github.rafael.modelException.ObjectNotFoundException;
import io.github.rafael.modelRepository.ClientRepository;
import io.github.rafael.modelService.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.ConstraintViolationException;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClientRepository clientRepository;

    public void someMethod(){
        System.out.println( "Hello Test!!");
    }

    public Cliente acharCliente(Integer id) {
        return clientRepository.findById(id)
                .orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void salvar(Cliente cliente) throws ClienteException{
        try {
            clientRepository.save(cliente);

        } catch (ConstraintViolationException e){
            throw new ClienteException(e);
        }
        catch (NullPointerException e){
            throw new ClienteException(e);

        }
    }

    public void deletarById(Integer id) {
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