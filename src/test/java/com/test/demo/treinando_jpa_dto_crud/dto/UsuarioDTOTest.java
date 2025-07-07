package com.test.demo.treinando_jpa_dto_crud.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTOTest {
    private long id;
    private String nome;
    private String login;

}
