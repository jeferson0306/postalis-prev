package br.org.postalis.postalisprev.domain;

import lombok.Data;

@Data
public class ResultadoSimulacao {

    private double salarioInicial;
    private double taxaContribuicaoX;
    private double taxaContribuicaoY;
    private double valorAcumulado;

}
