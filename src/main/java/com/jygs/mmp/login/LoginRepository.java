package com.jygs.mmp.login;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LoginRepository extends JpaRepository<LoginEntity, Integer> {

	Optional<LoginEntity> findByEmail(String email);
	Optional<LoginEntity> findByEmailAndPass(String email,String pass);
	
	
}