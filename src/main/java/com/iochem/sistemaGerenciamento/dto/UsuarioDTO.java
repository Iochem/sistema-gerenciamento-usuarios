package com.iochem.sistemaGerenciamento.dto;

import com.iochem.sistemaGerenciamento.entity.UsuarioEntity;
import jakarta.persistence.Entity;
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
public class UsuarioDTO {
    @NotBlank(message = "O nome não pode estar vazio")
    private String nome;

    @NotBlank(message = "O login não pode estar vazio")
    private String login;

    @NotBlank(message = "O e-mail não pode estar vazio")
    @Email(message = "O e-mail deve ser válido")
    private String gmail;

    @NotBlank(message = "A senha não pode estar vazia")
    private String senha;
}
