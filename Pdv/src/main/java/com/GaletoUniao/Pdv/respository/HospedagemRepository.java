package com.GaletoUniao.Pdv.respository;

import com.GaletoUniao.Pdv.domain.Hospedagem;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Range;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HospedagemRepository extends JpaRepository<Hospedagem, Long> {
    Page<Hospedagem> findAllByFinalizada(boolean b, Pageable pageable);
}
