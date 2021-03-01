package com.cocus.microservices.label.services;

import com.cocus.microservices.bo.entities.LabelBO;
import com.cocus.microservices.label.dto.LabelRequestDTO;

import java.util.List;

/**
 * @author Haytham DAHRI
 */
public interface LabelService {

    LabelBO saveLabel(LabelRequestDTO labelRequest);

    LabelBO getLabel(Long id);

    void deleteLabel(Long id);

    List<LabelBO> getLabels();

}
