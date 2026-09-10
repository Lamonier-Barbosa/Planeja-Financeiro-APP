package br.com.planeja.financeiro.api.dominio.cartao;

import br.com.planeja.financeiro.api.common.exceptions.RegistroNaoEncontradoException;
import br.com.planeja.financeiro.api.common.exceptions.ValidationException;
import br.com.planeja.financeiro.api.dominio.cartao.dtos.CartaoDetalhes;
import br.com.planeja.financeiro.api.dominio.cartao.dtos.CartaoForm;
import br.com.planeja.financeiro.api.dominio.cartao.mapper.CartaoMapper;
import br.com.planeja.financeiro.api.dominio.cartao.model.CartaoEntity;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class CartaoService {

    @Autowired
    private CartaoRepository repository;
    @Autowired
    private CartaoValidator validator;
    @Autowired
    private CartaoMapper mapper;


    public CartaoDetalhes criar(CartaoForm form) {
        var result = validator.validar(form, null);

        if (result.isInvalido()){
            throw new ValidationException(result.getCampoInvalidos());
        }

        CartaoEntity entity = mapper.toEntity(form);
        repository.save(entity);
        return mapper.toDetalhes(entity);
    }

    public CartaoDetalhes obterDetalhes(UUID id) {
        return repository.findById(id)
                .map(mapper::toDetalhes)
                .orElseThrow(() -> new RegistroNaoEncontradoException());
    }

    @Transactional
    public void atualizar(UUID id, @Valid CartaoForm dadosAtualizados) {
        var entity = repository.findById(id)
                .orElseThrow(() -> new RegistroNaoEncontradoException());

        var result = validator.validar(dadosAtualizados, id);

        if (result.isInvalido()){
            throw new ValidationException(result.getCampoInvalidos());
        }

        mapper.update(entity, dadosAtualizados);
    }
}

