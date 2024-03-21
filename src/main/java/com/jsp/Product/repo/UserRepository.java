package com.jsp.Product.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.jsp.Product.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
