package br.com.unitreino.Model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "pagamento")
public class ModelPagamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomeCliente;

    @Column(nullable = false)
    private double valorTotal;

    private double valorParcela;

    private LocalDate dataPagamento;

    @Column(nullable = false)
    private LocalDate dataVencimento;

    @ManyToOne
    @JoinColumn(name = "tipo_pagamento_id", nullable = false)
    private ModelTipoPagamento tipoPagamento;

    private int qtdParcela;

    public ModelPagamento() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNomeCliente() { return nomeCliente; }
    public void setNomeCliente(String nomeCliente) { this.nomeCliente = nomeCliente; }

    public double getValorTotal() { return valorTotal; }
    public void setValorTotal(double valorTotal) { this.valorTotal = valorTotal; }

    public double getValorParcela() { return valorParcela; }
    public void setValorParcela(double valorParcela) { this.valorParcela = valorParcela; }

    public LocalDate getDataPagamento() { return dataPagamento; }
    public void setDataPagamento(LocalDate dataPagamento) { this.dataPagamento = dataPagamento; }

    public LocalDate getDataVencimento() { return dataVencimento; }
    public void setDataVencimento(LocalDate dataVencimento) { this.dataVencimento = dataVencimento; }

    public ModelTipoPagamento getTipoPagamento() { return tipoPagamento; }
    public void setTipoPagamento(ModelTipoPagamento tipoPagamento) { this.tipoPagamento = tipoPagamento; }

    public int getQtdParcela() { return qtdParcela; }
    public void setQtdParcela(int qtdParcela) { this.qtdParcela = qtdParcela; }
}