package com.itb.lip2.agendamentus.repository;

import com.itb.lip2.agendamentus.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
