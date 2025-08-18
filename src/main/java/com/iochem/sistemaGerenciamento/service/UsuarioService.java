package com.iochem.sistemaGerenciamento.service;


import com.iochem.sistemaGerenciamento.dto.UsuarioDTO;
import com.iochem.sistemaGerenciamento.entity.UsuarioEntity;
import com.iochem.sistemaGerenciamento.mapper.UsuarioMapper;
import com.iochem.sistemaGerenciamento.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    //Método para inserir no banco e retornar o DTO
    /*
     - Recebe um UsuarioDTO do frontend
     - Converte para UsuarioEntity usando o mapper
     - Salva no banco
     - Converte de volta em dto para enviar resposta ao frontend
     */
    public UsuarioDTO inserir(UsuarioDTO usuario){
        UsuarioEntity entity = UsuarioMapper.toEntity(usuario);
        UsuarioEntity inserido = repository.save(entity);
        return UsuarioMapper.toDTO(inserido);
    }

    //Método para excluir
     /*
     - Busca o usuário pelo Id, se não existir retorna uma excessão, se existir deleta
     - Permite que o controller retorne HTTP 404 com mensagem personalizada
     */
    public void excluir(Long id){
        UsuarioEntity usuario = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário com id " + id + " não encontrado para exclusão"));
        repository.delete(usuario);
    }

    //Método listar todos
    /*
    - () Vazio pois não necessita de parâmetros externos
    - Busca todos os registros
    - Guarda em uma lista de entidades
    - Percorre a lista e converte cada entidade em dto com o .map e o mapper
    - etorna uma lista de DTOs para não expor a entidade
     */
    public List<UsuarioDTO> listarTodos(){//Guarda o resultado numa lista de entidades
        List<UsuarioEntity> usuarios = repository.findAll();
        return usuarios.stream()
                .map(UsuarioMapper::toDTO)
                .toList(); //Cria uma lista imutável
    }

    //Método para alterar Usuatio
    /*
    - Recebe um DTO atualizado do frontend
    - toEntity - Converte o DTO para entidade para salvar alteração no banco
    - Salva no banco
    - toDTO - Converte de volta para DTO e para enviar ao frontend
    - Retorna DTO para não expor a entidade
     */
    public UsuarioDTO alterar(UsuarioDTO usuario) {
        UsuarioEntity usuarioEntity = UsuarioMapper.toEntity(usuario);
        UsuarioEntity salvo = repository.save(usuarioEntity);
        return UsuarioMapper.toDTO(salvo);
    }
}

