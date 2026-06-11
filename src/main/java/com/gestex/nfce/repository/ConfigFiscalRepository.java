package com.gestex.nfce.repository;

import com.gestex.nfce.model.ConfigFiscal;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface ConfigFiscalRepository extends JpaRepository<ConfigFiscal, Long> {
    Optional<ConfigFiscal> findByEmpresaId(Long empresaId);
}
