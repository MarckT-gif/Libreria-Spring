package com.distribuida.dao;

import com.distribuida.model.Cliente;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;
import java.util.Optional;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
@Rollback(value = false)
public class clienteTestIntegracion {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void findAll(){
        List<Cliente> clientes = clienteRepository.findAll();
        for(Cliente item: clientes){
            System.out.println(item.toString());
        }
    }

    @Test
    public void findOne(){
        Optional<Cliente> cliente = clienteRepository.findById(39);
        System.out.println(cliente.toString());
    }

    @Test
    public void save(){
        Cliente cliente = new Cliente(0, "1723601471","Juan66","Taipe66","Direccion66","0989950502","jtaipe66@correo.com");
        clienteRepository.save(cliente);
    }

    @Test
    public void update(){
        Optional<Cliente> cliente = clienteRepository.findById(39);

        cliente.orElse(null).setCedula("1701234777");
        cliente.orElse(null).setNombre("Juan777");
        cliente.orElse(null).setApellido("Taipe777");
        cliente.orElse(null).setDireccion("Direccion777");
        cliente.orElse(null).setTelefono("0987653777");
        cliente.orElse(null).setCorreo("jtaipe777@correo.com");

        clienteRepository.save(cliente.orElse(null));

    }

    @Test
    public void delete(){
        clienteRepository.deleteById(39);
    }

}
