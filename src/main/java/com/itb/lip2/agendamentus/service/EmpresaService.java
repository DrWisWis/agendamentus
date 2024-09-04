package com.itb.lip2.agendamentus.service;

import com.itb.lip2.agendamentus.model.Empresa;

public interface EmpresaService {

    Empresa update(Long id, Empresa empresa) throws Exception;
    Empresa save(Empresa empresa);
}
