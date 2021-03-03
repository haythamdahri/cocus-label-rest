package com.cocus.microservices.label.services;

import com.cocus.microservices.bo.entities.LabelBO;
import com.cocus.microservices.label.dto.LabelDTO;
import com.cocus.microservices.label.dto.LabelRequestDTO;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * @author Haytham DAHRI
 */
public interface LabelService {

    LabelBO saveLabel(LabelRequestDTO labelRequest);

    LabelBO getLabel(Long id);

    void deleteLabel(Long id);

    Page<LabelDTO> getLabels(String search, int page, int size);

    List<LabelDTO> getLabels();

}
