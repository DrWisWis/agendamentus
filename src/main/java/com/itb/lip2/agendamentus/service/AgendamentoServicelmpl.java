package com.itb.lip2.agendamentus.service;

import com.itb.lip2.agendamentus.model.Agendamento;
import com.itb.lip2.agendamentus.repository.AgendamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AgendamentoServicelmpl implements AgendamentoService{

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    @Override
    public List<Agendamento> findAll() {
        return agendamentoRepository.findAll();
    }

    @Override
    public Agendamento findbyId(Long id) {
        return agendamentoRepository.findById(id).get();
    }

    @Override
    public Agendamento saveAgendamento(Agendamento agendamento) {
        return agendamentoRepository.save(agendamento);
    }

}
