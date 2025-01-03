package br.com.touristguide.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class CriarUsuarioResponseDto {

	private UUID id;
	private String nome;
	private String email;
	private PerfilCriarUsuarioResponse perfil;
}
