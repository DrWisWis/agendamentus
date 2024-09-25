package com.itb.lip2.agendamentus.model;


import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Table(name = "agendamentos")
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dataAgendamento;
    private LocalTime horarioAgendamento;
    private String descricaoAgendamento;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="usuario_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name="empresa_id")
    private Empresa empresa;

    public Agendamento() {

    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDataAgendamento() {
        return dataAgendamento;
    }

    public void setDataAgendamento(LocalDate dataAgendamento) {
        this.dataAgendamento = dataAgendamento;
    }

    public String getDescricaoAgendamento() {
        return descricaoAgendamento;
    }

    public void setDescricaoAgendamento(String descricaoAgendamento) {
        this.descricaoAgendamento = descricaoAgendamento;
    }

    public LocalTime getHorarioAgendamento() {
        return horarioAgendamento;
    }

    public void setHorarioAgendamento(LocalTime horarioAgendamento) {
        this.horarioAgendamento = horarioAgendamento;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Agendamento that = (Agendamento) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
