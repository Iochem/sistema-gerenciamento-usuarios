package com.test.demo.treinando_jpa_dto_crud.dto;

import com.test.demo.treinando_jpa_dto_crud.dto.UsuarioDTOTest;
import com.test.demo.treinando_jpa_dto_crud.jpa.UsuarioJpaTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ActiveProfiles("test")
public class UsuarioMapperTest {  // classe responsável por converter um objeto em outro.

    // Métodos de conversão embutidos na classe de teste
    public static UsuarioDTOTest toDTO(UsuarioJpaTest jpa) {
        if (jpa == null) return null;
        UsuarioDTOTest dto = new UsuarioDTOTest();
        BeanUtils.copyProperties(jpa, dto);
        return dto;
    }

    public static UsuarioJpaTest toJpa(UsuarioDTOTest dto) {
        if (dto == null) return null;
        UsuarioJpaTest jpa = new UsuarioJpaTest();
        BeanUtils.copyProperties(dto, jpa);
        return jpa;
    }

    //  Teste: Entity → DTO
    @Test
    public void deveConverterEntityParaDTO() {
        UsuarioJpaTest jpa = new UsuarioJpaTest(1L, "Maria", "maria456");
        UsuarioDTOTest dto = toDTO(jpa); // chamada direta do método

        assertNotNull(dto);
        assertEquals("Maria", dto.getNome());
        assertEquals("maria456", dto.getLogin());
    }

    // Teste: DTO → Entity
    @Test
    public void deveConverterDTOParaEntity() {
        UsuarioDTOTest dto = new UsuarioDTOTest(2L, "Carlos", "carlos789");
        UsuarioJpaTest jpa = toJpa(dto); // chamada direta do método

        assertNotNull(jpa);
        assertEquals("Carlos", jpa.getNome());
        assertEquals("carlos789", jpa.getLogin());
    }
}

