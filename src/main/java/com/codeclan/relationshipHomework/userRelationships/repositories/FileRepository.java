package com.codeclan.relationshipHomework.userRelationships.repositories;

import com.codeclan.relationshipHomework.userRelationships.models.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileRepository extends JpaRepository<File, Long> {
}
