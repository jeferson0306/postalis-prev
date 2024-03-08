package br.org.postalis.postalisprev.controller;

import br.org.postalis.postalisprev.domain.ResultadoSimulacao;
import br.org.postalis.postalisprev.services.SimulacaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/previdencias")
public class ClienteController {

    private final SimulacaoService simulacaoService;

    @GetMapping("/simulacao")
    public ResultadoSimulacao simularValores(@RequestParam final double salarioInicial) {
        log.info("inicia a simulação de valores para um salário inicial de R$ " + salarioInicial + "...");
        final var retorno = simulacaoService.simularValores(salarioInicial);
        log.info("finaliza a simulação de valores para um salário inicial de R$ " + salarioInicial + " com o retorno: " + retorno);
        return retorno;
    }
}
