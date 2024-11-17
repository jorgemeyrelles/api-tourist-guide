package br.com.touristguide.dtos;

import java.util.List;
import java.util.UUID;
import lombok.Data;

@Data
public class PerfilCriarUsuarioResponse {

	private UUID id;
	private String nome;
	private List<PermissaoCriarUsuarioResponse> permissoes;
}
