package br.com.planeja.financeiro.api.common.validation;

public record CampoInvalido(
        String campo,
        String erro
) {
}
