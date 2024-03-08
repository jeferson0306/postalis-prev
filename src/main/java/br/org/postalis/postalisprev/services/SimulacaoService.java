package br.org.postalis.postalisprev.services;

import br.org.postalis.postalisprev.domain.ResultadoSimulacao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SimulacaoService {

    public ResultadoSimulacao simularValores(final double salarioInicial) {

        var taxaContribuicaoX = 0.01;
        var taxaContribuicaoY = 0.0;
        var valorAcumulado = 0.0;
        var salarioAtual = salarioInicial;

        log.info("Simulando valores para um salário inicial de R$ " + salarioInicial + "...");

        for (int anos = 0; anos < 35; anos++) {
            salarioAtual *= 1.065;

            var contribuicaoX = salarioAtual * taxaContribuicaoX * 2;

            var valorExcedente = Math.max(0, salarioAtual - 2500);
            var contribuicaoY = valorExcedente * taxaContribuicaoY * 2;

            valorAcumulado += (contribuicaoX + contribuicaoY) * 12;

            if (taxaContribuicaoX < 0.04) {
                taxaContribuicaoX += 0.01;
            }
            if (salarioAtual > 2500 && taxaContribuicaoY < 0.08) {
                taxaContribuicaoY += 0.01;
            }
        }

        final var resultadoSimulacao = new ResultadoSimulacao();
        resultadoSimulacao.setSalarioInicial(salarioInicial);
        resultadoSimulacao.setTaxaContribuicaoX(taxaContribuicaoX);
        resultadoSimulacao.setTaxaContribuicaoY(taxaContribuicaoY);
        resultadoSimulacao.setValorAcumulado(valorAcumulado);

        log.info("Simulação concluída. Resultado: " + resultadoSimulacao);
        return resultadoSimulacao;
    }

}
