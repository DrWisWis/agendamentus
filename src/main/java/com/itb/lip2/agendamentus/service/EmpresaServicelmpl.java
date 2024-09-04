package com.itb.lip2.agendamentus.service;


import com.itb.lip2.agendamentus.model.Empresa;
import com.itb.lip2.agendamentus.repository.EmpresaRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EmpresaServicelmpl implements EmpresaService {

    // @Autowired
    // private  AlunoRepository alunoRepository;
    private final EmpresaRepository empresaRepository;

    public EmpresaServicelmpl(EmpresaRepository empresaRepository) {
        this.empresaRepository = empresaRepository;

    }
    @Override
    @Transactional
    public Empresa update(Long id, Empresa empresa) throws Exception {
        return empresaRepository.findById(id).map(empr ->{
            empr.setNome(empresa.getNome());
            return empresaRepository.save(empr);
        }).orElseThrow(()->new Exception("Empresa não encontrada!"));
    }

    @Override
    public Empresa save(Empresa empresa) {
        return empresaRepository.save(empresa);
    }
}