package com.edheijer.SupplementStore.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edheijer.SupplementStore.models.EnumRole;
import com.edheijer.SupplementStore.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(EnumRole name);
}
