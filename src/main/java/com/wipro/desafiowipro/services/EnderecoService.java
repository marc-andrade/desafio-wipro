package com.wipro.desafiowipro.services;

import com.wipro.desafiowipro.dto.EnderecoDTO;
import com.wipro.desafiowipro.dto.EnderecoSearchtDTO;
import com.wipro.desafiowipro.model.Endereco;
import com.wipro.desafiowipro.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class EnderecoService {

    @Autowired
    private RestTemplate restTemplate;
    private static final List<String> NORTE = Arrays.asList("AC", "AM", "AP", "PA", "RO", "RR", "TO");
    private static final List<String> NORDESTE = Arrays.asList("AL", "BA", "CE", "MA", "PB", "PE", "PI", "RN", "SE");
    private static final List<String> CENTRO_OESTE = Arrays.asList("DF", "GO", "MT", "MS");
    private static final List<String> SUDESTE = Arrays.asList("ES", "MG", "RJ", "SP");
    private static final List<String> SUL = Arrays.asList("PR", "RS", "SC");


    public EnderecoDTO consultaEndereco(EnderecoSearchtDTO dto) {
        String url = "https://viacep.com.br/ws/" + dto.getCep() + "/json/";

        ResponseEntity<Endereco> response =
                restTemplate.getForEntity(url, Endereco.class);

        if (Objects.requireNonNull(response.getBody()).getCep() == null) {
            throw new EntityNotFoundException("CEP inválido");
        }

        Endereco endereco = response.getBody();

        String uf = endereco.getUf();

        if (uf != null) {
            endereco.setFrete(calcularFrete(uf));

            return new EnderecoDTO(endereco);
        } else {
            throw new EntityNotFoundException("Erro ao calcular o frete.");
        }
    }

    public Double calcularFrete(String state) {
        if (NORTE.contains(state)) {
            return 20.83;
        } else if (NORDESTE.contains(state)) {
            return 15.98;
        } else if (CENTRO_OESTE.contains(state)) {
            return 12.50;
        } else if (SUDESTE.contains(state)) {
            return 7.85;
        } else if (SUL.contains(state)) {
            return 17.3;
        } else {
            return null;
        }
    }

}
