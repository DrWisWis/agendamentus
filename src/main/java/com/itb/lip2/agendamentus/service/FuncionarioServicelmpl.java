package com.itb.lip2.agendamentus.service;

import com.itb.lip2.agendamentus.model.Funcionario;
import com.itb.lip2.agendamentus.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioServicelmpl implements FuncionarioService{

    private final FuncionarioRepository funcionarioRepository;

    FuncionarioServicelmpl(FuncionarioRepository funcionarioRepository) {

        this.funcionarioRepository = funcionarioRepository;
    }

    @Override
    public Funcionario update(Long id, Funcionario funcionario) throws Exception {
        return funcionarioRepository.findById(id).map(fu ->{
            fu.setNome(funcionario.getNome());
            fu.setEmail(funcionario.getEmail());
            return funcionarioRepository.save(fu);
        }).orElseThrow(()->new Exception("Funcionário não encontrado!"));
    }
}
