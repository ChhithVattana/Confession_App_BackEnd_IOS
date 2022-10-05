package com.tgi_confession.tgi_confession_db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tgi_confession.tgi_confession_db.model.Reaction;

public interface ReactionRepository extends JpaRepository<Reaction, String> {

}
