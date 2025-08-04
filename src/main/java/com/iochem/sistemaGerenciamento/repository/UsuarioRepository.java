package com.iochem.sistemaGerenciamento.repository;

import com.iochem.sistemaGerenciamento.entity.UsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    //Herdou de uma classe pai as operações básicas incluindo o crud

}
