package com.itb.lip2.agendamentus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.itb.lip2.agendamentus.model.Papel;

@Repository
public interface PapelRepository extends JpaRepository<Papel, Long> {

    @Query(value = "SELECT * FROM papeis p WHERE p.nome_papel=?", nativeQuery = true)
    Papel findByName(String nomePapel);

}
