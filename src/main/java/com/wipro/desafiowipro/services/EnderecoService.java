package com.wipro.desafiowipro.services;

import com.wipro.desafiowipro.dto.EnderecoDTO;
import com.wipro.desafiowipro.dto.EnderecoSearchtDTO;
import com.wipro.desafiowipro.model.Endereco;
import com.wipro.desafiowipro.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EnderecoService {

        private RestTemplate restTemplate;

        public EnderecoService(RestTemplateBuilder restTemplateBuilder){
            this.restTemplate = restTemplateBuilder.build();
        }

        public Endereco consultaEndereco(EnderecoSearchtDTO dto) {
            //try{
                String url = "https://viacep.com.br/ws/" + dto.getCep() + "/json/";
                return restTemplate.getForObject(url, Endereco.class);
//            }catch (Exception e){
//                throw new ResourceNotFoundException("Cep não encontrado");
//            }

        }
}
