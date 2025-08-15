package com.test.demo.treinando_crud.crud;

import com.iochem.sistemaGerenciamento.Main;
import com.iochem.sistemaGerenciamento.entity.UsuarioEntity;
import com.iochem.sistemaGerenciamento.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.test.context.*;
import org.junit.jupiter.api.*;

@DataJpaTest
@ContextConfiguration(classes = Main.class) //Garantir identificação da classe principal
@ActiveProfiles("test") //Usa o profile "test" (application-test.properties)
public class UsuarioRepositoryCrudTest {


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
        UsuarioEntity salvo = repository.save(usuario);

        //Asserts - Verifica se o teste funcionou
        assertNotNull(salvo.getId(), "ID não pode ser nulo"); //Verifica se o id é nulo
        assertEquals("Aly", salvo.getNome(), "Nome deve ser 'Aly' "); // verifica se o nome salvo está correto
        assertTrue(repository.existsById(salvo.getId()), "Id já existe no banco"); //Verifica se o id já existe no banco
        assertEquals("Carla", salvo.getNome(), "Nome deve ser Aly (erro proposital)");// assert com erro proposital para verificação

        //OBS: As mensagem de erro persolalizada só passam se o teste falhar
    }

    @Test
    @DisplayName("Deve excluir um usuário com sucesso")
    void deveExcluirUsuario() {
        // Arrange
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setNome("Rob");
        usuario.setLogin("Rob1");
        usuario.setGmail("Rob2022@gmail.com");
        usuario.setSenha("123");

        UsuarioEntity salvo = repository.save(usuario);

        // Act
        repository.deleteById(salvo.getId());

        // Assert
        boolean existe = repository.existsById(salvo.getId());
        assertFalse(existe, "O usuário ainda existe no banco após exclusão!");
    }
}
