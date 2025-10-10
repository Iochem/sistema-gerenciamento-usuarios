package com.iochem.sistemaGerenciamento.service;


import com.iochem.sistemaGerenciamento.dto.UsuarioDTO;
import com.iochem.sistemaGerenciamento.entity.UsuarioEntity;
import com.iochem.sistemaGerenciamento.mapper.UsuarioMapper;
import com.iochem.sistemaGerenciamento.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    /*
     - Insere um novo usuário no banco.
     - Converte DTO → Entidade → salva → retorna DTO.
     */
    @Transactional
    public UsuarioDTO inserir(UsuarioDTO usuario){
        UsuarioEntity entity = UsuarioMapper.toEntity(usuario);
        UsuarioEntity inserido = repository.save(entity);
        return UsuarioMapper.toDTO(inserido);
    }

     /*
      - Exclui um usuário pelo ID.
      - Lança exceção se o usuário não existir.
     */
    public void excluir(Long id){
        UsuarioEntity usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário com id " + id + " não encontrado para exclusão"));
        repository.delete(usuario);
    }

    /*
      - Lista todos os usuários cadastrados.
      - Busca todos os registros no banco.
      - Converte entidades em DTOs.
     */
    public List<UsuarioDTO> listarTodos(){//Guarda o resultado numa lista de entidades
        List<UsuarioEntity> usuarios = repository.findAll();
        return usuarios.stream()
                .map(UsuarioMapper::toDTO)
                .toList(); //Cria uma lista imutável
    }

    /*
    - Atualiza um usuário existente.
    - Garante que o usuário exista antes de salvar.
    - Converte DTO → Entidade → salva → retorna DTO.
     */
    @Transactional
    public UsuarioDTO alterar(UsuarioDTO usuario) {
        UsuarioEntity usuarioEntity = UsuarioMapper.toEntity(usuario);
        UsuarioEntity salvo = repository.save(usuarioEntity);
        return UsuarioMapper.toDTO(salvo);
    }
}

/*
@Transactional - Anotação do Spring que gerencia transações de banco de dados.
- Ela garante que um conjunto de operações no banco seja executado como uma unidade atômica.
- Se alguma operação falhar, todas as alterações feitas dentro da transação são revertidas
 */