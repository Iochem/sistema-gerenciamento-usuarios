package com.iochem.sistemaGerenciamento.mapper;

import com.iochem.sistemaGerenciamento.dto.UsuarioDTO;
import com.iochem.sistemaGerenciamento.entity.UsuarioEntity;
import org.springframework.beans.BeanUtils;

public class UsuarioMapper {

    //Conversão entre Entity ↔ DTO
    public static UsuarioDTO toDTO(UsuarioEntity entity){
        if(entity == null) return null;
        UsuarioDTO dto = new UsuarioDTO();
        BeanUtils.copyProperties(entity,dto);
        return dto;
    }

    //Conversão entre DTO ↔ Entity
    public static UsuarioEntity toEntity(UsuarioDTO dto){
        if(dto == null) return null;
        UsuarioEntity entity = new UsuarioEntity();
        BeanUtils.copyProperties(dto, entity);
        return entity;
    }
}
