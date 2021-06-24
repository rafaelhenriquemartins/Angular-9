package io.github.rafael.modelService;

import io.github.rafael.modelEntity.Cliente;
import io.github.rafael.modelException.ClienteException;
import io.github.rafael.modelRepository.ClientRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ClienteServiceTest {

    @Autowired
    private ClienteService service;

    @Autowired
    private ClientRepository repository;

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    private Cliente cliente;

    @Before
    public void start(){
        cliente = new Cliente(1, "rafael", "35090841870");
    }

//    @Test
//    public void salvarComNomeNuloDeveLancarException() throws ClienteException {
//        expectedException.expect(ClienteException.class);
//        expectedException.expectMessage("O campo nome é obrigatório.");
//
//        cliente.setNome(null);
//        service.salvar(cliente);
//
//    }


    @Test
    public void salveDeveSalvarCliente() throws ClienteException {
        Cliente cliente1 = new Cliente(1, "rafael", "35090841870");
        service.salvar(cliente1);

        List<Cliente> cliente = repository.findAll();
        Assert.assertEquals(1, cliente.size());
        repository.deleteAll();

    }

}