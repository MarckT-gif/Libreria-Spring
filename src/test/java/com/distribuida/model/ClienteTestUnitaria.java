package com.distribuida.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ClienteTestUnitaria {

    private Cliente cliente;

    @BeforeEach
    public void setup() {
        cliente = new Cliente(1,"1723601470","Juan","Taipe","Tumbacoyork","0989950500","jtaipe@correo.com");

    }

    @Test
    public void testClienteConstructor(){
        assertAll("Validar datos del cliente - Constructor",
                () -> assertEquals( 1, cliente.getIdCliente() ),
                () -> assertEquals("1723601470", cliente.getCedula()),
                () -> assertEquals("Juan", cliente.getNombre()),
                () -> assertEquals("Taipe", cliente.getApellido()),
                () -> assertEquals("Tumbacoyork", cliente.getDireccion()),
                () -> assertEquals("0989950500", cliente.getTelefono()),
                () -> assertEquals("jtaipe@correo.com", cliente.getCorreo())
                );


    }

    @Test
    public void testClienteSetters(){
        cliente.setIdCliente(2);
        cliente.setCedula("1723601471");
        cliente.setNombre("Juan2");
        cliente.setApellido("Taipe2");
        cliente.setDireccion("Direccion2");
        cliente.setTelefono("0989950501");
        cliente.setCorreo("jtaipe2@correo.com");

        assertAll("validar datos del cliente - Setters" ,
        () -> assertEquals(2,cliente.getIdCliente()),
        () -> assertEquals("1723601471",cliente.getCedula()),
        () -> assertEquals("Juan2",cliente.getNombre()),
        () -> assertEquals("Taipe2",cliente.getApellido()),
        () -> assertEquals("Direccion2",cliente.getDireccion()),
        () -> assertEquals("0989950501",cliente.getTelefono()),
        () -> assertEquals("jtaipe2@correo.com",cliente.getCorreo())
        );

    }

    @Test
    public void testClienteToString(){
        String str = cliente.toString();
        assertAll("validar datos del cliente - toString",
                () -> assertTrue(str.contains("1")),
                () -> assertTrue(str.contains("1723601470")),
                () -> assertTrue(str.contains("Juan")),
                () -> assertTrue(str.contains("Taipe")),
                () -> assertTrue(str.contains("Tumbacoyork")),
                () -> assertTrue(str.contains("0989950500")),
                () -> assertTrue(str.contains("jtaipe@correo.com"))
                );
    }

}
