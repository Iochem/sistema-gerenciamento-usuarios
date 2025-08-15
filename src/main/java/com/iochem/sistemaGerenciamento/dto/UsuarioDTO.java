package com.iochem.sistemaGerenciamento.dto;

import com.iochem.sistemaGerenciamento.entity.UsuarioEntity;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDTO {
    private long id;
    private String nome;
    private String login;
    private String gmail;
    private String senha;


}
