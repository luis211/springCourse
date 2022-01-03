package com.artur.example.repositories;

import com.artur.example.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    /**
     * En el caso de que necesitemos hacer filtrados mas especificos, se usaran los queryMethods.
     * Es asy como se crearan los querys spring
     * @param username
     * @return
     */
    public Optional<User> findByUsername(String username);

    public Optional<User> findByUsernameAndPassword(String username, String password);

    /**
     * ESTO NO ES SQL, se llama JPQL()
     * @return
     */
    @Query("SELECT u.username FROM User u")
    public Page<String> findUsernames(Pageable pageable);
}

