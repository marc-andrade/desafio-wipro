package com.wipro.desafiowipro.dto;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

public class EnderecoSearchtDTO {

    @NotBlank(message = "CEP é obrigatório")
    @Pattern(regexp = "^\\d{5}-?\\d{3}$", message = "CEP inválido")
    private String cep;

    public EnderecoSearchtDTO() {
    }

    public EnderecoSearchtDTO(String cep) {
        this.cep = cep;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
