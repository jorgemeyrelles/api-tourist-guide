package br.com.touristguide;

import static org.assertj.core.api.Assertions.fail;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import br.com.touristguide.dtos.CriarUsuarioRequestDto;
import br.com.touristguide.dtos.CriarUsuarioResponseDto;

@SpringBootTest
@AutoConfigureMockMvc
class ApiTouristGuideApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	ObjectMapper objectMapper;

	@Test
	public void criarUsuarioTest() throws Exception {
		CriarUsuarioRequestDto dto = new CriarUsuarioRequestDto();

		Faker faker = new Faker();

		dto.setNome(faker.name().fullName());
		dto.setEmail(faker.internet().emailAddress());
		dto.setSenha("@Admin123");

		var result = mockMvc
				.perform(post("/api/usuarios/criar")
						.contentType("application/json")
						.content(objectMapper.writeValueAsString(dto)))
				.andExpect(status().isOk()).andReturn();

		String content = result.getResponse()
				.getContentAsString(StandardCharsets.UTF_8);
		
		CriarUsuarioResponseDto response = objectMapper.readValue(content, CriarUsuarioResponseDto.class);
		
		assertEquals(dto.getNome(), response.getNome(), "O nome do usuário na resposta deveria ser igual ao enviado.");
		// Verifica se o nome enviado no DTO está presente no conteúdo da resposta
	    assertTrue(content.contains(dto.getNome()), "O nome do usuário deveria estar na resposta.");

	    // Verifica outros campos da resposta se necessário
	    assertTrue(content.contains(dto.getEmail()), "O e-mail do usuário deveria estar na resposta.");

	}

	@Test
	public void autenticarUsuarioTest() {
		fail("Não implementado");
	}

}
