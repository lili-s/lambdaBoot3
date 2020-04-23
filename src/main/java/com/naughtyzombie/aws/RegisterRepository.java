package com.naughtyzombie.aws;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface RegisterRepository extends JpaRepository<Register, Long>{

	Register findByid(Long id);
	
	//@Query("SELECT username FROM REGISTER where username = :user and password= :pass")
	//Register findByUandP(@Param("user") String username, @Param("pass") String pass);
	
	List<Register>findByUsernameAndPassword(String username,String password);
	List<Register> findByUsername(String username);
	
	List<Register> findAll();
}
