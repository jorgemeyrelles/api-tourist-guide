package br.com.touristguide.dtos;

import java.util.UUID;

import br.com.touristguide.entities.Perfil;
import lombok.Data;

@Data
public class CriarUsuarioResponseDto {

	private UUID id;
	private String nome;
	private String email;
	private Perfil perfil;
}
