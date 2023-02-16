package com.wipro.desafiowipro.services;

import com.wipro.desafiowipro.dto.EnderecoDTO;
import com.wipro.desafiowipro.dto.EnderecoSearchtDTO;
import com.wipro.desafiowipro.model.Endereco;
import com.wipro.desafiowipro.tests.Factory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;

class EnderecoServiceTest {

    @InjectMocks
    private EnderecoService service;
//    @Mock
//    private RestTemplate restTemplateMock;
    private EnderecoSearchtDTO searchtDTO;
    private Endereco endereco;

    @BeforeEach
    void setUp() throws Exception {
        searchtDTO = Factory.createEnderecoSearch();
        endereco = Factory.createEndereco();
        RestTemplate restTemplateMock = Mockito.mock(RestTemplate.class);
        Mockito.when(restTemplateMock.getForObject(anyString(),eq(Endereco.class))).thenReturn(endereco);

    }

    @Test
    void consultaEnderecoShouldReturnEnderecoWhenValidCep() {

        EnderecoDTO result = service.consultaEndereco(searchtDTO);

        assertNotNull(result);
        assertEquals(endereco.getUf(), result.getEstado());
        assertEquals(endereco.getLocalidade(), result.getCidade());
        assertEquals(endereco.getBairro(), result.getBairro());
        assertEquals(endereco.getLogradouro(), result.getRua());
    }

    @Test
    void calcularFrete() {
    }

}