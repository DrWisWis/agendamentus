package com.itb.lip2.agendamentus.repository;

import com.itb.lip2.agendamentus.model.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long > {
}
