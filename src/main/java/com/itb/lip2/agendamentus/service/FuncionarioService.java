package com.itb.lip2.agendamentus.service;

import com.itb.lip2.agendamentus.model.Funcionario;

public interface FuncionarioService {

    Funcionario update(Long id, Funcionario funcionario) throws Exception;
}
