package com.GaletoUniao.Pdv.respository;

import com.GaletoUniao.Pdv.domain.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface QuartoRepository extends JpaRepository<Quarto, Long> {
    Optional<Quarto> findByIdAndDisponivel(Long quartoId, boolean b);
}
