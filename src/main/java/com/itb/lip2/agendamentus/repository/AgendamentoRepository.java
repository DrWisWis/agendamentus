package com.itb.lip2.agendamentus.repository;

import com.itb.lip2.agendamentus.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento, Long> {
}
