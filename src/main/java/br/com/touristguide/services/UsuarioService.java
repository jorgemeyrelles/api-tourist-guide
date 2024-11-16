package br.com.touristguide.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.touristguide.components.SHA256Component;
import br.com.touristguide.dtos.AutenticarUsuarioRequestDto;
import br.com.touristguide.dtos.CriarUsuarioRequestDto;
import br.com.touristguide.dtos.CriarUsuarioResponseDto;
import br.com.touristguide.entities.Usuario;
import br.com.touristguide.repositories.PerfilRepository;
import br.com.touristguide.repositories.PermissaoRepository;
import br.com.touristguide.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	PerfilRepository perfilRepository;

	@Autowired
	PermissaoRepository permissaoRepository;

	@Autowired
	SHA256Component sha256Component;

	public CriarUsuarioResponseDto criarUsuario(CriarUsuarioRequestDto dto) {
		Usuario usuarioByEmail = usuarioRepository.findByEmail(dto.getEmail());

		if (usuarioByEmail != null) {
			throw new IllegalArgumentException(
					"O email informado já está cadastrado, tente outro.");
		}

		Usuario newUsuario = new Usuario();
		CriarUsuarioResponseDto response = new CriarUsuarioResponseDto();

		newUsuario.setId(UUID.randomUUID());
		newUsuario.setNome(dto.getNome());
		newUsuario.setEmail(dto.getEmail());
		newUsuario.setSenha(sha256Component.hash(dto.getSenha()));
		newUsuario.setPerfil(perfilRepository.findByNome("OPERADOR"));

		usuarioRepository.save(newUsuario);

		response.setId(newUsuario.getId());
		response.setNome(newUsuario.getNome());
		response.setEmail(newUsuario.getEmail());
		response.setPerfil(newUsuario.getPerfil());

		return response;
	}

	public void autenticarUsuario(AutenticarUsuarioRequestDto dto) {
		Usuario usuario = usuarioRepository.findByEmailAndPassword(
				dto.getEmail(), sha256Component.hash(dto.getSenha()));

		if (usuario == null) {
			throw new IllegalArgumentException(
					"O email ou senha não conferem, tente outro.");
		}

	}
}
