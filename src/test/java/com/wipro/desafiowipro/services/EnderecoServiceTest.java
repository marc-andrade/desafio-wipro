package com.wipro.desafiowipro.services;

import com.wipro.desafiowipro.dto.EnderecoDTO;
import com.wipro.desafiowipro.dto.EnderecoSearchtDTO;
import com.wipro.desafiowipro.model.Endereco;
import com.wipro.desafiowipro.tests.Factory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class EnderecoServiceTest {

    private EnderecoSearchtDTO searchtDTO;
    private Endereco endereco;
    private EnderecoService service;

    @BeforeEach
    void setUp() throws Exception {
        searchtDTO = Factory.createEnderecoSearch();
        endereco = Factory.createEndereco();

        RestTemplate restTemplate = mock(RestTemplate.class);
        RestTemplateBuilder restTemplateBuilder = mock(RestTemplateBuilder.class);
        when(restTemplateBuilder.build()).thenReturn(restTemplate);
        service = new EnderecoService(restTemplateBuilder);

        String responseBody = "{\"uf\":\"SP\"}";
        ResponseEntity<String> responseEntity = new ResponseEntity<>(responseBody, HttpStatus.OK);
        when(restTemplate.getForEntity(eq("https://viacep.com.br/ws/01234567/json/"), eq(String.class)))
                .thenReturn(responseEntity);
        when(restTemplate.getForEntity(Mockito.anyString(), Mockito.eq(String.class)))
                .thenReturn(responseEntity);
        when(restTemplate.getForObject(anyString(),eq(Endereco.class))).thenReturn(endereco);
    }

    @Test
    void consultaEnderecoShouldReturnEnderecoWhenValidCep() {

        EnderecoDTO result = service.consultaEndereco(searchtDTO);

        assertNotNull(result);
        assertEquals(endereco.getUf(), result.getEstado());
        assertEquals(endereco.getLocalidade(), result.getCidade());
        assertEquals(endereco.getBairro(), result.getBairro());
        assertEquals(endereco.getLogradouro(), result.getRua());
        assertEquals(result.getClass(), EnderecoDTO.class);
    }

    @Test
    void calcularFreteShouldReturnValueWhenValidUfOrEstado() {

        double result = service.calcularFrete(endereco.getUf());

        assertEquals(result, 7.85);
    }

    @Test
    void calcularFreteShouldReturnNullWhenInValidUfOrEstado() {

        Double result = service.calcularFrete("xx");

        assertNull(result);
    }

}