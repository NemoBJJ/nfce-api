package com.gestex.nfce.controller;

import com.gestex.nfce.model.NfceRequest;
import com.gestex.nfce.model.NfceResponse;
import com.gestex.nfce.service.NfceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/nfce")
public class NfceController {

    private final NfceService nfceService;

    public NfceController(NfceService nfceService) {
        this.nfceService = nfceService;
    }

    @PostMapping("/emitir/{empresaId}")
    public NfceResponse emitirNota(@PathVariable Long empresaId, @RequestBody NfceRequest request) throws Exception {
        return nfceService.emitirNota(empresaId, request);
    }

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
}