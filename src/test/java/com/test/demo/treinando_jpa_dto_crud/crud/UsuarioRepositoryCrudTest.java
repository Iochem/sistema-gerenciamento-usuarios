package com.test.demo.treinando_jpa_dto_crud.crud;

import com.iochem.sistemaGerenciamento.entity.UsuarioEntity;
import com.iochem.sistemaGerenciamento.repository.UsuarioRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest // Otimizado para testes JPA, inicializa só camada de persistência
@ActiveProfiles("test") //Usa o profile "test" (application-test.properties)
public class UsuarioTestRepositoryCrud {

    @Autowired
    private UsuarioRepository repository; // Injeta o repositório real da aplicação

    @Test
    @DisplayName("Deve salvar um novo usuário")
    public void testeSalvarNoBanco(){
        // Arrange  - Cria os objetos
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNome("Aly");
        usuario.setLogin("Aly123");
        usuario.setGmail("Aly2019@gmail.com");
        usuario.setSenha("A12456");

        // Act- Act Adiciona ao  banco
        repository.save(usuario);

        //Asserts - Verifica se o teste funcionou

    }


    @Test

}
