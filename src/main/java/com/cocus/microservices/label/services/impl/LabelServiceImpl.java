package com.cocus.microservices.label.services.impl;

import com.cocus.microservices.bo.entities.LabelBO;
import com.cocus.microservices.label.dto.LabelRequestDTO;
import com.cocus.microservices.label.exceptions.NotFoundException;
import com.cocus.microservices.label.repositories.LabelRepository;
import com.cocus.microservices.label.services.LabelService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Haytham DAHRI
 */
@Service
public class LabelServiceImpl implements LabelService {

    private final LabelRepository labelRepository;

    public LabelServiceImpl(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    @Override
    public LabelBO saveLabel(LabelRequestDTO labelRequest) {
        LabelBO label;
        if( labelRequest.getId() == null ) {
            label = new LabelBO();
        } else {
            label = this.labelRepository.findById(labelRequest.getId()).orElse(new LabelBO());
        }
        label.setDescription(labelRequest.getDescription());
        return this.labelRepository.save(label);
    }

    @Override
    public LabelBO getLabel(Long id) {
        return this.labelRepository.findById(id).orElseThrow(() -> new NotFoundException("No Label Found With ID " + id));
    }

    @Override
    public void deleteLabel(Long id) {
        this.labelRepository.deleteById(id);
    }

    @Override
    public List<LabelBO> getLabels() {
        return this.labelRepository.findAll();
    }
}
