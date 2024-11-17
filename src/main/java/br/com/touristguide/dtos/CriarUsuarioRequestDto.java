package br.com.touristguide.dtos;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CriarUsuarioRequestDto {

	@Size(min = 8, max = 100, message = "nome: Por favor, informe o nome de 8 a 100 caracteres.")
	@NotEmpty(message = "nome: Por favor, informe	o nome do usuário.")
	@Schema(description = "Nome do usuário", example = "Usuario da silva")
	private String nome;

	@Pattern(regexp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "email: Por favor, informe um endereço de email válido.")
	@NotEmpty(message = "email: Por favor, informe o email do usuário.")
	@Schema(description = "Email do usuário", example = "usuario@email.com")
	private String email;

	@Pattern(regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@#$%^&+=!])(?=\\S+$).{8,}$", message = "senha: Por favor, informe a senha com letras maiúsculas, minúsculas, números, símbolos e pelo menos 8 caracteres.")
	@NotEmpty(message = "senha: Por favor, informe a senha do usuário.")
	@Schema(description = "Senha do usuário", example = "@Admin123")
	private String senha;
}
