package com.crud.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.crud.entity.user;

public interface userrepo extends JpaRepository<user, Integer> {

}
