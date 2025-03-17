package com.easyplus.easy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.easyplus.easy.entity.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
}
