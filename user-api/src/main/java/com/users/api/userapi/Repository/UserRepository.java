package com.users.api.userapi.Repository;

import java.util.UUID;

import com.users.api.userapi.Model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}
