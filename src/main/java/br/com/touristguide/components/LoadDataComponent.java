package br.com.touristguide.components;

import java.util.ArrayList;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.com.touristguide.entities.Perfil;
import br.com.touristguide.entities.Permissao;
import br.com.touristguide.entities.Usuario;
import br.com.touristguide.repositories.PerfilRepository;
import br.com.touristguide.repositories.PermissaoRepository;
import br.com.touristguide.repositories.UsuarioRepository;

@Component
public class LoadDataComponent implements ApplicationRunner {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	PermissaoRepository permissaoRepository;

	@Autowired
	PerfilRepository perfilRepository;

	@Autowired
	SHA256Component sha256Component;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		Permissao permissaoCadastro = new Permissao();
		permissaoCadastro
				.setId(UUID.fromString("fc5623b4-ab30-484f-91b3-db95aeca7d52"));
		permissaoCadastro.setNome("CADASTRAR CLIENTES");

		Permissao permissaoConsulta = new Permissao();
		permissaoConsulta
				.setId(UUID.fromString("150551c2-5c27-4ec7-8cd1-b7f360449d13"));
		permissaoConsulta.setNome("CONSULTAR CLIENTES");

		Permissao permissaoEdicao = new Permissao();
		permissaoEdicao
				.setId(UUID.fromString("cdad386e-c44c-4166-b6e7-d113c6924514"));
		permissaoEdicao.setNome("EDITAR CLIENTES");

		Permissao permissaoExclusao = new Permissao();
		permissaoExclusao
				.setId(UUID.fromString("44231dcf-193f-4736-95ad-1665039a0a51"));
		permissaoExclusao.setNome("EXCLUSAO CLIENTES");

		permissaoRepository.save(permissaoCadastro);
		permissaoRepository.save(permissaoConsulta);
		permissaoRepository.save(permissaoEdicao);
		permissaoRepository.save(permissaoExclusao);

		Perfil perfilAdm = new Perfil();
		perfilAdm
				.setId(UUID.fromString("a0278bac-d28b-4892-b730-740970b7f1bd"));
		perfilAdm.setNome("ADMINISTRADOR");

		ArrayList<Permissao> permissaoAdm = new ArrayList<Permissao>();
		permissaoAdm.add(permissaoCadastro);
		permissaoAdm.add(permissaoConsulta);
		permissaoAdm.add(permissaoEdicao);
		permissaoAdm.add(permissaoExclusao);

		perfilAdm.setPermissoes(permissaoAdm);
		perfilRepository.save(perfilAdm);

		Perfil perfilOperador = new Perfil();
		perfilOperador
				.setId(UUID.fromString("c583b6b7-be76-4b51-8db5-4545d5860b6c"));
		perfilOperador.setNome("OPERADOR");

		ArrayList<Permissao> permissaoOperador = new ArrayList<Permissao>();
		permissaoOperador.add(permissaoConsulta);

		perfilOperador.setPermissoes(permissaoOperador);

		perfilRepository.save(perfilOperador);

		Usuario usuarioAdm = new Usuario();
		usuarioAdm.setId
		(UUID.fromString("f5b8e780-30c1-4b6e-a8f4-96d76ede67c4"));
		usuarioAdm.setNome("Antonio da silva");
		usuarioAdm.setEmail("antonio@email.com");
		usuarioAdm.setSenha

		(sha256Component.hash("@Admin123"));
		usuarioAdm.setPerfil(perfilAdm);
		usuarioRepository.save(usuarioAdm);

	}
}
