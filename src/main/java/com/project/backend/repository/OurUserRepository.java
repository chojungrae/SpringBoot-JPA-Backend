package com.project.backend.repository;

import com.project.backend.domain.OurUser;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OurUserRepository extends JpaRepository<OurUser, Long> {

}