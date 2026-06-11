package com.gestex.nfce.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "config_fiscal")
public class ConfigFiscal {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "empresa_id", nullable = false)
    private Long empresaId;
    
    @Column(nullable = false, length = 18)
    private String cnpj;
    
    @Column(length = 20)
    private String ie;
    
    @Column(length = 255)
    private String csc;
    
    @Column(name = "id_token", length = 50)
    private String idToken;
    
    @Column(name = "token_focus", length = 255)
    private String tokenFocus;
    
    @Column(length = 10)
    private String ambiente;
    
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    
    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getEmpresaId() { return empresaId; }
    public void setEmpresaId(Long empresaId) { this.empresaId = empresaId; }
    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
    public String getIe() { return ie; }
    public void setIe(String ie) { this.ie = ie; }
    public String getCsc() { return csc; }
    public void setCsc(String csc) { this.csc = csc; }
    public String getIdToken() { return idToken; }
    public void setIdToken(String idToken) { this.idToken = idToken; }
    public String getTokenFocus() { return tokenFocus; }
    public void setTokenFocus(String tokenFocus) { this.tokenFocus = tokenFocus; }
    public String getAmbiente() { return ambiente; }
    public void setAmbiente(String ambiente) { this.ambiente = ambiente; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}
