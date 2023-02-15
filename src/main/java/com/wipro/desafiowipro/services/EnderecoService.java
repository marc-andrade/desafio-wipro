package com.wipro.desafiowipro.services;

import com.wipro.desafiowipro.dto.EnderecoDTO;
import com.wipro.desafiowipro.dto.EnderecoSearchtDTO;
import com.wipro.desafiowipro.model.Endereco;
import com.wipro.desafiowipro.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EnderecoService {

        private RestTemplate restTemplate;

        public EnderecoService(RestTemplateBuilder restTemplateBuilder){
            this.restTemplate = restTemplateBuilder.build();
        }

        public Endereco consultaEndereco(EnderecoSearchtDTO dto) {
                String url = "https://viacep.com.br/ws/" + dto.getCep() + "/json/";

                ResponseEntity<String> response =
                        restTemplate.getForEntity(url, String.class);
                String responseBody = response.getBody();
                if (responseBody != null && responseBody.contains("erro")){
                        throw new IllegalArgumentException("CEP inválido");
                }

                return restTemplate.getForObject(url, Endereco.class);
        }
}
