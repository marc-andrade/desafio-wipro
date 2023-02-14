package com.wipro.desafiowipro.dto;

import org.hibernate.validator.constraints.NotBlank;

public class EnderecoSearchtDTO {

    @NotBlank(message = "CEP é obrigatório")
    private String cep;

}
