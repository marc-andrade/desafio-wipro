package com.wipro.desafiowipro.resources;

import com.wipro.desafiowipro.dto.EnderecoDTO;
import com.wipro.desafiowipro.dto.EnderecoSearchtDTO;
import com.wipro.desafiowipro.services.EnderecoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/v1")
public class EnderecoResource {

    private final EnderecoService service;

    public EnderecoResource(EnderecoService service) {
        this.service = service;
    }

    @PostMapping(value = "/consulta-endereco")
    public ResponseEntity<EnderecoDTO> consultaEndereco(@Valid  @RequestBody EnderecoSearchtDTO enderecoSearchtDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(service.consultaEndereco(enderecoSearchtDTO));
    }

}
