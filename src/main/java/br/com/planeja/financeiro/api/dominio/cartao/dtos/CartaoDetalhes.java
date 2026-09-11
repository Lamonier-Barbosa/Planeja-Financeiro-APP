package br.com.planeja.financeiro.api.dominio.cartao.dtos;

import br.com.planeja.financeiro.api.dominio.cartao.model.BandeiraCartao;
import java.time.LocalDateTime;


public record CartaoDetalhes(
        String id,
        String nome,
        BandeiraCartao bandeira,
        LocalDateTime dataCadastro
) {
}
