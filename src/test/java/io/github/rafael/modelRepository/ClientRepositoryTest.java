package io.github.rafael.modelRepository;

import io.github.rafael.modelEntity.Cliente;
import io.github.rafael.modelException.ClienteException;
import io.github.rafael.modelException.ObjectNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;

import java.util.List;

import static org.junit.Assert.*;


@DataJpaTest
@RunWith(SpringRunner.class)
public class ClientRepositoryTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Autowired
    private ClientRepository repository;

    private Cliente cliente;

    @Before
    public void start(){
         cliente = new Cliente(1,"Talita", "35090841870");
//       cliente = new Cliente(2,"Talita1", "35090841871");
//       repository.save(cliente);
//       cliente = new Cliente(3,"Talita2", "35090841872");
//       repository.save(cliente);
//       cliente = new Cliente(4,"Talita3", "35090841873");
//       repository.save(cliente);
    }

    @Test
    public void saveComNomeNulDeveLancarException() throws  Exception{
        expectedException.expect(ConstraintViolationException.class);
        expectedException.expectMessage("O campo nome é obrigatório.");

        cliente.setNome(null);
        repository.save(cliente);
    }

    @Test
    public void salveDeveSalvarCliente(){
        repository.save(cliente);
        List<Cliente> cli = repository.findAll();
        Assert.assertEquals(1,cli.size());

        repository.deleteAll();
    }

    @Test
    public void deleteDeveRemoverCliente(){
        repository.save(cliente);
        List<Cliente> cli = repository.findAll();
        Assert.assertEquals(1,cli.size());

        repository.deleteById(cliente.getId());
        List<Cliente> result = repository.findAll();
        Assert.assertEquals(0,result.size());
    }

}