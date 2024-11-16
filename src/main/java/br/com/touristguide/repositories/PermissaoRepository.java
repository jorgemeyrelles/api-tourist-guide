package br.com.touristguide.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.touristguide.entities.Permissao;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, UUID> {

}
