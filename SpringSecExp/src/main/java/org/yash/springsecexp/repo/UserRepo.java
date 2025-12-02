package org.yash.springsecexp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.yash.springsecexp.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer> {

    User findByUsername(String username);

}
