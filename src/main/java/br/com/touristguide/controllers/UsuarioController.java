package br.com.touristguide.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.touristguide.dtos.AutenticarUsuarioRequestDto;
import br.com.touristguide.dtos.CriarUsuarioRequestDto;
import br.com.touristguide.dtos.CriarUsuarioResponseDto;
import br.com.touristguide.services.UsuarioService;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@PostMapping("criar")
	public CriarUsuarioResponseDto criar(
			@RequestBody @Valid CriarUsuarioRequestDto dto) {
		return usuarioService.criarUsuario(dto);

	}

	@PostMapping("autenticar")
	public void autenticar(
			@RequestBody @Valid AutenticarUsuarioRequestDto dto) {
		// TODO: process POST request

	}

}
