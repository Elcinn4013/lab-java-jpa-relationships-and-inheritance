package org.example.lab.repository;

import org.example.lab.entity.association.Division;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DivisionRepository extends JpaRepository<Division,Long> {
}
