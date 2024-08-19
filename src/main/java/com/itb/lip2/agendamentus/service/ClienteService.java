package com.itb.lip2.agendamentus.service;

import com.itb.lip2.agendamentus.model.Cliente;

public interface ClienteService {

    Cliente update(Long id, Cliente cliente) throws Exception;
}
