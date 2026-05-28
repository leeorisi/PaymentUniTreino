package br.com.unitreino.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "tipo_pagamento")
public class ModelTipoPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String descricao;

    public ModelTipoPagamento() {}

    public ModelTipoPagamento(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}