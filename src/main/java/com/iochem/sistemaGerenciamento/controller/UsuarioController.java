package com.iochem.sistemaGerenciamento.controller;


import com.iochem.sistemaGerenciamento.dto.UsuarioDTO;
import com.iochem.sistemaGerenciamento.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController { //Reponsavel por enviar e receber dados do frontend

    @Autowired
    private UsuarioService service;

    //Cria método HTTP para listar todos os usuário
    @GetMapping //Pedir dados ao backend
    public List<UsuarioDTO> listarTodos(){
        return service.listarTodos();
    }

    //Cria o método HTTP para iserir usuario
    @PostMapping //Enviar dados para criar o usuario
    public ResponseEntity<UsuarioDTO> inserir(@RequestBody UsuarioDTO usuario){ // @RequestBody - Usa-se pois requisições do tipo POST necessitam de corpo
        UsuarioDTO usuarioCriado = service.inserir(usuario); // recebe o DTO com ID e dados do banco
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioCriado);
    }

    

}
