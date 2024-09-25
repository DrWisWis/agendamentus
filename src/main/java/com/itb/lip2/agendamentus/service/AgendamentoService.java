package com.itb.lip2.agendamentus.service;

import com.itb.lip2.agendamentus.model.Agendamento;

import java.util.List;

public interface AgendamentoService {

    List<Agendamento> findAll();
    Agendamento findbyId(Long id);
    Agendamento saveAgendamento(Agendamento agendamento);


}
