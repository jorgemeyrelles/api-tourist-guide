package br.com.touristguide.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.touristguide.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UUID> {

	@Query("FROM Usuario u WHERE u.email:=email")
	Usuario findByEmail(@Param("email") String email);

	@Query("FROM Usuario u WHERE u.email:=email AND u.senha:=senha")
	Usuario findByEmailAndPassword(@Param("email") String email,
			@Param("senha") String senha);
}
