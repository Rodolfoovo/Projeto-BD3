package com.example.danielprojetodb3.domain.dto.titulo;


import java.util.Date;
import java.util.List;

import com.example.danielprojetodb3.domain.Enum.ETipoTitulo;
import com.example.danielprojetodb3.domain.repository.CentroDeCustoRepository;

public class TituloRequestDTO {
    private String descricao;
    private ETipoTitulo tipo;
    private List<CentroDeCustoRepository> centroDeCusto;
    private Double valor;
    private Date dataCadastro;
    private Date dataReferencia;
    private Date dataVencimento;
    private Date dataPagamento;
    private String observacao;
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public ETipoTitulo getTipo() {
        return tipo;
    }
    public void setTipo(ETipoTitulo tipo) {
        this.tipo = tipo;
    }
    public List<CentroDeCustoRepository> getCentroDeCusto() {
        return centroDeCusto;
    }
    public void setCentroDeCusto(List<CentroDeCustoRepository> centroDeCusto) {
        this.centroDeCusto = centroDeCusto;
    }
    public Double getValor() {
        return valor;
    }
    public void setValor(Double valor) {
        this.valor = valor;
    }
    public Date getDataCadastro() {
        return dataCadastro;
    }
    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    public Date getDataReferencia() {
        return dataReferencia;
    }
    public void setDataReferencia(Date dataReferencia) {
        this.dataReferencia = dataReferencia;
    }
    public Date getDataVencimento() {
        return dataVencimento;
    }
    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }
    public Date getDataPagamento() {
        return dataPagamento;
    }
    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }
    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
