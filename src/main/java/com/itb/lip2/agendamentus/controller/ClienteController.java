package com.itb.lip2.agendamentus.controller;

import com.itb.lip2.agendamentus.model.Agendamento;
import com.itb.lip2.agendamentus.model.Cliente;
import com.itb.lip2.agendamentus.service.AgendamentoService;
import com.itb.lip2.agendamentus.service.ClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agendamentus/api/v1/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    private final AgendamentoService agendamentoService;
    ClienteController(ClienteService clienteService, AgendamentoService agendamentoService) {
        this.clienteService = clienteService;
        this.agendamentoService = agendamentoService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateCliente(@RequestBody Cliente cliente, @PathVariable(value="id") Long id) {
        try {
            return ResponseEntity.ok().body(clienteService.update(id, cliente));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/agendamento")
    public ResponseEntity<Object> saveAgendamento(@RequestBody Agendamento agendamento) {
        try {
            return ResponseEntity.ok().body(agendamentoService.saveAgendamento(agendamento));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }


}
