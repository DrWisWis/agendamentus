package com.itb.lip2.agendamentus.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@DiscriminatorValue(value = "Cliente")
public class Cliente extends Usuario {

    private int telefone;



    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Agendamento> agendamentos = new ArrayList<Agendamento>();


    public Cliente() {


    }
    public Cliente(Long id, String nome, String email, String senha, String tipoUsuario, Collection<Papel> papeis) {
        super(id, nome, email, senha, tipoUsuario, papeis);  // Acesso ao construtor da classe pai
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int pontuacao) {
        this.telefone = telefone;
    }




    public List<Agendamento> getAgendamentos() {
        return agendamentos;
    }

    public void setAgendamentos(List<Agendamento> agendamentos) {
        this.agendamentos = agendamentos;
    }


}

