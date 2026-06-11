package com.gestex.nfce.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.List;

public class NfceRequest {

    @JsonProperty("cnpj_emitente")
    private String cnpjEmitente;

    @JsonProperty("natureza_operacao")
    private String naturezaOperacao;

    @JsonProperty("data_emissao")
    private String dataEmissao;

    @JsonProperty("presenca_comprador")
    private Integer presencaComprador;

    @JsonProperty("modalidade_frete")
    private Integer modalidadeFrete;

    private List<Item> items;

    // Getters e Setters
    public String getCnpjEmitente() { return cnpjEmitente; }
    public void setCnpjEmitente(String cnpjEmitente) { this.cnpjEmitente = cnpjEmitente; }

    public String getNaturezaOperacao() { return naturezaOperacao; }
    public void setNaturezaOperacao(String naturezaOperacao) { this.naturezaOperacao = naturezaOperacao; }

    public String getDataEmissao() { return dataEmissao; }
    public void setDataEmissao(String dataEmissao) { this.dataEmissao = dataEmissao; }

    public Integer getPresencaComprador() { return presencaComprador; }
    public void setPresencaComprador(Integer presencaComprador) { this.presencaComprador = presencaComprador; }

    public Integer getModalidadeFrete() { return modalidadeFrete; }
    public void setModalidadeFrete(Integer modalidadeFrete) { this.modalidadeFrete = modalidadeFrete; }

    public List<Item> getItems() { return items; }
    public void setItems(List<Item> items) { this.items = items; }

    public static class Item {

        @JsonProperty("numero_item")
        private Integer numeroItem;

        @JsonProperty("codigo_produto")
        private String codigoProduto;

        private String descricao;

        @JsonProperty("codigo_ncm")
        private String codigoNcm;

        private String cfop;

        @JsonProperty("unidade_comercial")
        private String unidadeComercial;

        @JsonProperty("quantidade_comercial")
        private BigDecimal quantidadeComercial;

        @JsonProperty("valor_unitario_comercial")
        private BigDecimal valorUnitarioComercial;

        @JsonProperty("valor_unitario_tributavel")
        private BigDecimal valorUnitarioTributavel;

        @JsonProperty("icms_situacao_tributaria")
        private String icmsSituacaoTributaria;

        // Getters e Setters
        public Integer getNumeroItem() { return numeroItem; }
        public void setNumeroItem(Integer numeroItem) { this.numeroItem = numeroItem; }

        public String getCodigoProduto() { return codigoProduto; }
        public void setCodigoProduto(String codigoProduto) { this.codigoProduto = codigoProduto; }

        public String getDescricao() { return descricao; }
        public void setDescricao(String descricao) { this.descricao = descricao; }

        public String getCodigoNcm() { return codigoNcm; }
        public void setCodigoNcm(String codigoNcm) { this.codigoNcm = codigoNcm; }

        public String getCfop() { return cfop; }
        public void setCfop(String cfop) { this.cfop = cfop; }

        public String getUnidadeComercial() { return unidadeComercial; }
        public void setUnidadeComercial(String unidadeComercial) { this.unidadeComercial = unidadeComercial; }

        public BigDecimal getQuantidadeComercial() { return quantidadeComercial; }
        public void setQuantidadeComercial(BigDecimal quantidadeComercial) { this.quantidadeComercial = quantidadeComercial; }

        public BigDecimal getValorUnitarioComercial() { return valorUnitarioComercial; }
        public void setValorUnitarioComercial(BigDecimal valorUnitarioComercial) { this.valorUnitarioComercial = valorUnitarioComercial; }

        public BigDecimal getValorUnitarioTributavel() { return valorUnitarioTributavel; }
        public void setValorUnitarioTributavel(BigDecimal valorUnitarioTributavel) { this.valorUnitarioTributavel = valorUnitarioTributavel; }

        public String getIcmsSituacaoTributaria() { return icmsSituacaoTributaria; }
        public void setIcmsSituacaoTributaria(String icmsSituacaoTributaria) { this.icmsSituacaoTributaria = icmsSituacaoTributaria; }
    }
}