package com.dwill.gamestore.repository.user;

import com.dwill.gamestore.model.user.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface UserRepo extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByEmail(String email);
    Optional<AppUser> findTopByName(String name);

    @Transactional
    @Query("UPDATE AppUser c SET c.cash = ?1 WHERE c.id = ?2")
    @Modifying
    public void updateCash(Float newCash, Long id);




    @Transactional
    @Modifying
    @Query("UPDATE AppUser a " +
            "SET a.enabled = TRUE WHERE a.email = ?1")
    int enableUser(String email);
}
