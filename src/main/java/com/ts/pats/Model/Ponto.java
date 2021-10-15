package com.ts.pats.Model;

import java.util.Objects;

public class Ponto {

    private int id;
    private String horario_entrada;
    private String horario_saida;
    private int id_func;
    private String data;
    private int statusPonto;
    private int id_empresa;

    @Override
    public String toString() {
        return "Ponto{" +
                "id=" + id +
                ", horario_entrada='" + horario_entrada + '\'' +
                ", horario_saida='" + horario_saida + '\'' +
                ", id_func=" + id_func +
                ", data='" + data + '\'' +
                ", statusPonto=" + statusPonto +
                ", id_empresa=" + id_empresa +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ponto ponto = (Ponto) o;
        return id == ponto.id && id_func == ponto.id_func && statusPonto == ponto.statusPonto && id_empresa == ponto.id_empresa && Objects.equals(horario_entrada, ponto.horario_entrada) && Objects.equals(horario_saida, ponto.horario_saida) && Objects.equals(data, ponto.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, horario_entrada, horario_saida, id_func, data, statusPonto, id_empresa);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHorario_entrada() {
        return horario_entrada;
    }

    public void setHorario_entrada(String horario_entrada) {
        this.horario_entrada = horario_entrada;
    }

    public String getHorario_saida() {
        return horario_saida;
    }

    public void setHorario_saida(String horario_saida) {
        this.horario_saida = horario_saida;
    }

    public int getId_func() {
        return id_func;
    }

    public void setId_func(int id_func) {
        this.id_func = id_func;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public int getStatusPonto() {
        return statusPonto;
    }

    public void setStatusPonto(int statusPonto) {
        this.statusPonto = statusPonto;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }
}
