package com.cocus.microservices.label.repositories;

import com.cocus.microservices.bo.entities.LabelBO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Haytham DAHRI
 */
@Repository
public interface LabelRepository extends JpaRepository<LabelBO, Long> {
}
