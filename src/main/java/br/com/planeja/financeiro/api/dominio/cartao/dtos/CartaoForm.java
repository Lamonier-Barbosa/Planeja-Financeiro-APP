package br.com.planeja.financeiro.api.dominio.cartao.dtos;

import br.com.planeja.financeiro.api.dominio.cartao.model.BandeiraCartao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CartaoForm(

        @NotBlank(message = "O nome do cartão é obrigatório")
        String nome,

        @NotNull(message = "A bandeira do cartão é obrigatória")
        BandeiraCartao bandeira
) {
}
