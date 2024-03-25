package com.GaletoUniao.Pdv.respository;

import com.GaletoUniao.Pdv.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
