package com.cocus.microservices.label.repositories;

import com.cocus.microservices.bo.entities.LabelBO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Repository;

/**
 * @author Haytham DAHRI
 */
@Repository
public interface LabelRepository extends JpaRepository<LabelBO, Long> {

    @Query(value = "SELECT l FROM LabelBO l WHERE LOWER(l.description) LIKE %:search%")
    Page<LabelBO> searchLabels(@Param("search") String search, @PageableDefault Pageable pageable);

}
