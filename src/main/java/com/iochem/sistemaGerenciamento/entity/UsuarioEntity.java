package com.iochem.sistemaGerenciamento.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "s_usuario")
public class UsuarioEntity {

    @Id
    //Indica que o id será gerado automaticamente pelo banco de dados
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nome;

    //Campo não pode ser nulo
    @Column(nullable = false, unique = true)//unique = true - não ter usuário repetido
    private String login;

    @Column(nullable = false)
    private String gmail;

    @Column(nullable = false)
    private String senha;

}
