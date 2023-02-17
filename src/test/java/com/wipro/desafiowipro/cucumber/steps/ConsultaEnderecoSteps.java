package com.wipro.desafiowipro.cucumber.steps;

import com.wipro.desafiowipro.dto.EnderecoDTO;
import com.wipro.desafiowipro.dto.EnderecoSearchtDTO;
import com.wipro.desafiowipro.services.EnderecoService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.web.client.RestTemplateBuilder;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ConsultaEnderecoSteps {

        private final EnderecoService enderecoService;
        private EnderecoSearchtDTO enderecoSearchtDTO;
        private EnderecoDTO enderecoDTO;

        public ConsultaEnderecoSteps(RestTemplateBuilder restTemplateBuilder) {
            this.enderecoService = new EnderecoService(restTemplateBuilder);
        }

        @Given("que eu informo um CEP válido")
        public void informarCepValido() {
            enderecoSearchtDTO = new EnderecoSearchtDTO("01001000");
        }

        @When("eu faço a busca do CEP")
        public void buscarCep() {
            enderecoDTO = enderecoService.consultaEndereco(enderecoSearchtDTO);
        }

        @Then("devo receber as informações do endereço")
        public void verificarInformacoesEndereco() {
            assertNotNull(enderecoDTO);
            assertEquals("SP", enderecoDTO.getEstado());
            assertEquals("São Paulo", enderecoDTO.getCidade());
            assertEquals("Sé", enderecoDTO.getBairro());
            assertEquals("Praça da Sé", enderecoDTO.getRua());
            assertEquals(7.85,enderecoDTO.getFrete());
        }
    }
