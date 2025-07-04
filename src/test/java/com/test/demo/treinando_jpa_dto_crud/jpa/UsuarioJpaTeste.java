package com.test.demo.treinando_jpa_dto_crud.jpa;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "test_usuario") //Cria a tabela com o nome
public class UsuarioJpaTeste {

    //Chave primária
    @Id
    //Indica que o id será gerado automaticamente pelo banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //Informa que esse campo não pode ser nulo
    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)//unique = true - não ter usuário repetido
    private String login;


}
