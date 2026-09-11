package br.com.planeja.financeiro.api.dominio.cartao.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "cartao")
public class CartaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private UUID id;

    @Column(nullable = false, length = 30)
    private String nome;

    @Column(name = "bandeira",nullable = false)
    @Enumerated(EnumType.STRING)
    private BandeiraCartao bandeira;

    @Column(name = "data_cadastro",nullable = false)
    private LocalDateTime dataCadastro;

    @PrePersist
    public void prePersist(){
        setDataCadastro(LocalDateTime.now());
    }
}
