package com.gestex.nfce.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "historico_nfce")
public class HistoricoNfce {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "empresa_id", nullable = false)
    private Long empresaId;
    
    @Column(nullable = false, length = 100)
    private String referencia;
    
    @Column(name = "chave_nfe", length = 100)
    private String chaveNfe;
    
    @Column(length = 30)
    private String status;
    
    @Column(length = 20)
    private String numero;
    
    @Column(name = "caminho_danfe", length = 500)
    private String caminhoDanfe;
    
    @Column(name = "qrcode_url", length = 1000)
    private String qrcodeUrl;
    
    @Column(name = "xml_url", length = 500)
    private String xmlUrl;
    
    @Column(name = "response_json", columnDefinition = "JSON")
    private String responseJson;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getEmpresaId() { return empresaId; }
    public void setEmpresaId(Long empresaId) { this.empresaId = empresaId; }
    public String getReferencia() { return referencia; }
    public void setReferencia(String referencia) { this.referencia = referencia; }
    public String getChaveNfe() { return chaveNfe; }
    public void setChaveNfe(String chaveNfe) { this.chaveNfe = chaveNfe; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public String getCaminhoDanfe() { return caminhoDanfe; }
    public void setCaminhoDanfe(String caminhoDanfe) { this.caminhoDanfe = caminhoDanfe; }
    public String getQrcodeUrl() { return qrcodeUrl; }
    public void setQrcodeUrl(String qrcodeUrl) { this.qrcodeUrl = qrcodeUrl; }
    public String getXmlUrl() { return xmlUrl; }
    public void setXmlUrl(String xmlUrl) { this.xmlUrl = xmlUrl; }
    public String getResponseJson() { return responseJson; }
    public void setResponseJson(String responseJson) { this.responseJson = responseJson; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
