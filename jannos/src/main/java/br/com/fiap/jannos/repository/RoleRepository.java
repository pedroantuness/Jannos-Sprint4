package br.com.fiap.jannos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.jannos.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}
