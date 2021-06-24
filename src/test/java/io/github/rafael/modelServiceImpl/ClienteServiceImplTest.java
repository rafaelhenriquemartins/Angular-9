package io.github.rafael.modelServiceImpl;

import io.github.rafael.modelEntity.Cliente;
import io.github.rafael.modelException.ClienteException;
import io.github.rafael.modelRepository.ClientRepository;
import io.github.rafael.modelService.ClienteService;
import org.junit.Before;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.ConstraintViolationException;


@RunWith(SpringRunner.class)
@SpringBootTest
class ClienteServiceImplTest {

}