package com.GaletoUniao.Pdv.respository;

import com.GaletoUniao.Pdv.domain.Vendas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Vendas, Long> {
}
