package br.com.planeja.financeiro.api.dominio.cartao;

import br.com.planeja.financeiro.api.common.validation.CampoInvalido;
import br.com.planeja.financeiro.api.common.validation.ValidationResult;
import br.com.planeja.financeiro.api.dominio.cartao.dtos.CartaoForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CartaoValidator {

    @Autowired
    private CartaoRepository repository;

    public ValidationResult validar(CartaoForm form, UUID id) {
        var result = ValidationResult.novo();

        var isListaNaoVazio = !repository.findByNomeAndNotId(form.nome(), id).isEmpty();
        if(isListaNaoVazio) {
            result.add(new CampoInvalido("nome", "Nome já cadastrado."));
        }

        return result;
    }
}
