package com.itb.lip2.agendamentus.service;

import com.itb.lip2.agendamentus.model.Cliente;
import com.itb.lip2.agendamentus.repository.ClienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ClienteServicelmpl implements ClienteService{

    private final ClienteRepository clienteRepository;

    ClienteServicelmpl(ClienteRepository clienteRepository) {

        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente update(Long id, Cliente cliente) throws Exception {
        return clienteRepository.findById(id).map(cli ->{
            cli.setNome(cliente.getNome());
            cli.setEmail(cliente.getEmail());
            return clienteRepository.save(cli);
        }).orElseThrow(()->new Exception("Cliente não encontrado!"));
    }
}
