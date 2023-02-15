package com.wipro.desafiowipro.dto;

import com.wipro.desafiowipro.model.Endereco;

import java.math.BigDecimal;

public class EnderecoDTO {

    private String cep;
    private String rua;
    private String complemento;
    private String bairro;
    private String cidade;
    private String estado;
    private Double frete;

    public EnderecoDTO() {
    }

    public EnderecoDTO(String cep, String rua, String complemento, String bairro, String cidade, String estado, Double frete) {
        this.cep = cep;
        this.rua = rua;
        this.complemento = complemento;
        this.bairro = bairro;
        this.cidade = cidade;
        this.estado = estado;
        this.frete = frete;
    }

    public EnderecoDTO(Endereco entity){
        this.cep = entity.getCep();
        this.rua = entity.getLogradouro();
        this.complemento = entity.getComplemento();
        this.bairro = entity.getBairro();
        this.cidade = entity.getLocalidade();
        this.estado = entity.getUf();
        this.frete = entity.getFrete();
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getFrete() {
        return frete;
    }

    public void setFrete(Double frete) {
        this.frete = frete;
    }
}
