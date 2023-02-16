package com.wipro.desafiowipro.tests;

import com.wipro.desafiowipro.dto.EnderecoSearchtDTO;
import com.wipro.desafiowipro.model.Endereco;

public class Factory {

    public static EnderecoSearchtDTO createEnderecoSearch(){
        return new EnderecoSearchtDTO("01001000");
    }

    public static Endereco createEndereco(){
        return new Endereco("01001000", "Praça da Sé", "lado ímpar", "Sé", "São Paulo", "SP","3550308","1004","11","7107", null);
    }


}
