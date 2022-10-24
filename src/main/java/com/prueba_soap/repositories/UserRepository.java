package com.prueba_soap.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.prueba_soap.models.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUserId(long userId);

}