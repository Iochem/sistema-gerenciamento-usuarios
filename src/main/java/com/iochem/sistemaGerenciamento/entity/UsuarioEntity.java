package com.iochem.sistemaGerenciamento.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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
    private Long id;

    @NotBlank(message = "O nome do cliente não pode estar vazio")
    @Column(nullable = false)
    private String nome; //Campo não pode ser nulo

    @NotBlank(message = "O login não pode estar vazio")
    @Column(nullable = false, unique = true)//unique = true - não ter usuário repetido
    private String login;

    @NotBlank(message = "O e-mail do cliente não pode estar vazio")
    @Email(message = "O e-mail deve ser válido")
    @Column(nullable = false)
    private String gmail;

    @NotBlank(message = "A senha não pode estar vazia")
    @Column(nullable = false)
    private String senha;

}
