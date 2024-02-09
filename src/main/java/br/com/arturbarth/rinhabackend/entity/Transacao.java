package br.com.arturbarth.rinhabackend.entity;

import br.com.arturbarth.rinhabackend.dto.TipoTransacaoEnum;
import jakarta.persistence.*;
import org.springframework.boot.context.properties.bind.DefaultValue;

import java.time.LocalDateTime;

@Entity
@Table(name = "TRANSACAO")
public class Transacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "CLIENTE_ID", nullable = false)
    private Cliente cliente;

    private long valor;

    @Enumerated(EnumType.STRING)
    private TipoTransacaoEnum tipo;

    private String descricao;

    private LocalDateTime data;

    public Transacao() {
    }

    public Transacao(Cliente cliente, long valor, TipoTransacaoEnum tipo, String descricao, LocalDateTime data) {
        this.cliente = cliente;
        this.valor = valor;
        this.tipo = tipo;
        this.descricao = descricao;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getValor() {
        return valor;
    }

    public void setValor(long valor) {
        this.valor = valor;
    }

    public TipoTransacaoEnum getTipo() {
        return tipo;
    }

    public void setTipo(TipoTransacaoEnum tipo) {
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
