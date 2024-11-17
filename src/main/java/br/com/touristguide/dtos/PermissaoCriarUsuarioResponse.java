package br.com.touristguide.dtos;

import java.util.UUID;

import lombok.Data;

@Data
public class PermissaoCriarUsuarioResponse {

	private UUID id;
	private String nome;
}
