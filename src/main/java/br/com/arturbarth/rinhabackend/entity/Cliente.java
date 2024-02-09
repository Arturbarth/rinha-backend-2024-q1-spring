package br.com.arturbarth.rinhabackend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private long limite;
    private long saldo;

    public Cliente() {
    }

    public Cliente(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getLimite() {
        return limite;
    }

    public void setLimite(long limite) {
        this.limite = limite;
    }

    public long getSaldo() {
        return saldo;
    }

    public void setSaldo(long saldo) {
        this.saldo = saldo;
    }
}
