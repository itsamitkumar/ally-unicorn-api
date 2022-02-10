package com.ally.poc.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ally.poc.model.Unicorn;

public interface UnicornRepository extends MongoRepository<Unicorn, Long> {

	Unicorn findByUnicornId(long unicornId);
}
