package com.valoya.login.login.dao;
import javax.persistence.Id;
import com.valoya.login.login.Entity.User;
import com.valoya.login.login.domain.type.State;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends JpaRepository<User, Long> {

   User findByName(String name);

    User findByEmail(String email);



   // User findByEmailAndState(String email, State state);



    //User findByEmail(String email);
    //List<User> findAll();*/
}
