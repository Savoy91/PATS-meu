package com.ts.pats.Model;

import java.util.Objects;

public class Funcionario {


    private int id;
    private int pin;
    private String nome;
    private String cargo;
    private int id_empresa;
	private String endereco;
    private int cep;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getId_empresa() {
        return id_empresa;
    }

    public void setId_empresa(int id_empresa) {
        this.id_empresa = id_empresa;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getCep() {
        return cep;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return id == that.id && pin == that.pin && id_empresa == that.id_empresa && cep == that.cep && Objects.equals(nome, that.nome) && Objects.equals(cargo, that.cargo) && Objects.equals(endereco, that.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pin, nome, cargo, id_empresa, endereco, cep);
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", pin=" + pin +
                ", nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                ", id_empresa=" + id_empresa +
                ", endereco='" + endereco + '\'' +
                ", cep=" + cep +
                '}';
    }
}
