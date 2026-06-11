package com.gestex.nfce.repository;

import com.gestex.nfce.model.HistoricoNfce;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface HistoricoNfceRepository extends JpaRepository<HistoricoNfce, Long> {
    List<HistoricoNfce> findByEmpresaIdOrderByCreatedAtDesc(Long empresaId);
}
