package com.codeclan.relationshipHomework.userRelationships.repositories;

import com.codeclan.relationshipHomework.userRelationships.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
