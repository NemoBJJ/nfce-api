package com.gestex.nfce.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gestex.nfce.model.*;
import com.gestex.nfce.repository.ConfigFiscalRepository;
import com.gestex.nfce.repository.HistoricoNfceRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

@Service
public class NfceService {

    private final ConfigFiscalRepository configRepository;
    private final HistoricoNfceRepository historicoRepository;
    private final RestTemplate restTemplate = new RestTemplate();
    private final ObjectMapper objectMapper = new ObjectMapper();

    public NfceService(ConfigFiscalRepository configRepository, HistoricoNfceRepository historicoRepository) {
        this.configRepository = configRepository;
        this.historicoRepository = historicoRepository;
    }

    public NfceResponse emitirNota(Long empresaId, NfceRequest request) throws Exception {
        ConfigFiscal config = configRepository.findByEmpresaId(empresaId)
                .orElseThrow(() -> new RuntimeException("Configuração fiscal não encontrada para empresa " + empresaId));

        // HARDCODED PARA TESTE
        String url = "https://homologacao.focusnfe.com.br/v2/nfce";
        String token = "OlarwuSzrKqs2ayVeJjcbwUT61Tue3ow";
        String referencia = "NFCE_" + System.currentTimeMillis();

        System.out.println("URL: " + url);
        System.out.println("Token: " + token);
        System.out.println("Referência: " + referencia);

        Map<String, Object> body = montarJson(request, config);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        String auth = Base64.getEncoder().encodeToString((token + ":").getBytes());
        headers.set("Authorization", "Basic " + auth);

        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                url + "?ref=" + referencia,
                HttpMethod.POST,
                entity,
                String.class
        );

        JsonNode jsonResponse = objectMapper.readTree(response.getBody());

        salvarHistorico(config, referencia, request, jsonResponse);

        NfceResponse nfceResponse = new NfceResponse();
        nfceResponse.setStatus(jsonResponse.has("status") ? jsonResponse.get("status").asText() : "erro");
        if (jsonResponse.has("chave_nfe")) nfceResponse.setChaveNfe(jsonResponse.get("chave_nfe").asText());
        if (jsonResponse.has("numero")) nfceResponse.setNumero(jsonResponse.get("numero").asText());
        if (jsonResponse.has("caminho_danfe")) nfceResponse.setCaminhoDanfe(jsonResponse.get("caminho_danfe").asText());
        if (jsonResponse.has("qrcode_url")) nfceResponse.setQrcodeUrl(jsonResponse.get("qrcode_url").asText());

        return nfceResponse;
    }

    private Map<String, Object> montarJson(NfceRequest request, ConfigFiscal config) {
        Map<String, Object> json = new HashMap<>();
        String dataAtual = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss'-03:00'"));

        json.put("cnpj_emitente", config.getCnpj());
        json.put("natureza_operacao", request.getNaturezaOperacao());
        json.put("data_emissao", dataAtual);
        json.put("presenca_comprador", request.getPresencaComprador());
        json.put("modalidade_frete", request.getModalidadeFrete());

        json.put("items", request.getItems());

        return json;
    }

    private void salvarHistorico(ConfigFiscal config, String referencia, NfceRequest request, JsonNode response) {
        HistoricoNfce historico = new HistoricoNfce();
        historico.setEmpresaId(config.getEmpresaId());
        historico.setReferencia(referencia);
        historico.setStatus(response.has("status") ? response.get("status").asText() : "erro");
        if (response.has("chave_nfe")) historico.setChaveNfe(response.get("chave_nfe").asText());
        if (response.has("numero")) historico.setNumero(response.get("numero").asText());
        if (response.has("caminho_danfe")) historico.setCaminhoDanfe(response.get("caminho_danfe").asText());
        if (response.has("qrcode_url")) historico.setQrcodeUrl(response.get("qrcode_url").asText());
        historico.setCreatedAt(LocalDateTime.now());
        historico.setResponseJson(response.toString());

        historicoRepository.save(historico);
    }
}