package com.gestex.nfce.model;

public class NfceResponse {
    private String status;
    private String statusSefaz;
    private String mensagemSefaz;
    private String chaveNfe;
    private String numero;
    private String serie;
    private String caminhoDanfe;
    private String qrcodeUrl;
    private String xmlUrl;
    private String mensagemErro;
    
    // Getters e Setters
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getStatusSefaz() { return statusSefaz; }
    public void setStatusSefaz(String statusSefaz) { this.statusSefaz = statusSefaz; }
    public String getMensagemSefaz() { return mensagemSefaz; }
    public void setMensagemSefaz(String mensagemSefaz) { this.mensagemSefaz = mensagemSefaz; }
    public String getChaveNfe() { return chaveNfe; }
    public void setChaveNfe(String chaveNfe) { this.chaveNfe = chaveNfe; }
    public String getNumero() { return numero; }
    public void setNumero(String numero) { this.numero = numero; }
    public String getSerie() { return serie; }
    public void setSerie(String serie) { this.serie = serie; }
    public String getCaminhoDanfe() { return caminhoDanfe; }
    public void setCaminhoDanfe(String caminhoDanfe) { this.caminhoDanfe = caminhoDanfe; }
    public String getQrcodeUrl() { return qrcodeUrl; }
    public void setQrcodeUrl(String qrcodeUrl) { this.qrcodeUrl = qrcodeUrl; }
    public String getXmlUrl() { return xmlUrl; }
    public void setXmlUrl(String xmlUrl) { this.xmlUrl = xmlUrl; }
    public String getMensagemErro() { return mensagemErro; }
    public void setMensagemErro(String mensagemErro) { this.mensagemErro = mensagemErro; }
}
