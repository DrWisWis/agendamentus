package com.itb.lip2.agendamentus.model;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Collection;

@Entity
@DiscriminatorValue(value = "Funcionario")
public class Funcionario extends Usuario {

    @ManyToOne
    @JoinColumn(name="empresa_id")
    private Empresa empresa;

    public Funcionario() {


    }
    public Funcionario(Long id, String nome, String email, String senha, Collection<Papel> papeis) {
        super(id, nome, email, senha, papeis);  // Acesso ao construtor da classe pai
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }
}
