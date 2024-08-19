package com.itb.lip2.agendamentus.controller;


import com.itb.lip2.agendamentus.model.Funcionario;
import com.itb.lip2.agendamentus.service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/agendamentus/api/v1/funcionarios")
public class FuncionarioController {

    private  final FuncionarioService funcionarioService;
    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateFuncionario(@RequestBody Funcionario funcionario, @PathVariable(value="id") Long id) {
        try {
            return ResponseEntity.ok().body(funcionarioService.update(id, funcionario));
        }catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
