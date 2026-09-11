package br.com.planeja.financeiro.api.dominio.cartao.mapper;

import br.com.planeja.financeiro.api.dominio.cartao.dtos.CartaoDetalhes;
import br.com.planeja.financeiro.api.dominio.cartao.dtos.CartaoForm;
import br.com.planeja.financeiro.api.dominio.cartao.model.CartaoEntity;
import jakarta.validation.Valid;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface CartaoMapper {

    CartaoEntity toEntity(CartaoForm cartaoForm);

    CartaoDetalhes toDetalhes(CartaoEntity cartaoEntity);

    void update(@MappingTarget CartaoEntity entity, @Valid CartaoForm dadosAtualizados);
}
