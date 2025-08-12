package com.iochem.sistemaGerenciamento.service;


import com.iochem.sistemaGerenciamento.dto.UsuarioDTO;
import com.iochem.sistemaGerenciamento.entity.UsuarioEntity;
import com.iochem.sistemaGerenciamento.mapper.UsuarioMapper;
import com.iochem.sistemaGerenciamento.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariServiceCrud {

    @Autowired
    private UsuarioRepository repository;

    //Método para inserir no banco e retornar o DTO
    public void inserir (UsuarioDTO usuario){
        UsuarioEntity entity = UsuarioMapper.toEntity(usuario);
        repository.save(entity);
    }

    //Método para excluir
    public void excluir(Long id){
        try {
            UsuarioEntity usuario = repository.getById(id);
            usuario.getId();
            repository.delete(usuario);
        } catch (EntityNotFoundException e) {
            throw new RuntimeException("Usuário com id " + id + " não encontrado para exclusão");
        }
    }

}

