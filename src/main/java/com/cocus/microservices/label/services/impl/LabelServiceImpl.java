package com.cocus.microservices.label.services.impl;

import com.cocus.microservices.bo.entities.LabelBO;
import com.cocus.microservices.label.dto.LabelDTO;
import com.cocus.microservices.label.dto.LabelRequestDTO;
import com.cocus.microservices.label.exceptions.NotFoundException;
import com.cocus.microservices.label.repositories.LabelRepository;
import com.cocus.microservices.label.services.LabelService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

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
            label = this.getLabel(labelRequest.getId());
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
    public Page<LabelDTO> getLabels(String search, int page, int size) {
        Page<LabelBO> labelsPage;
        if (StringUtils.isEmpty(search)) {
            labelsPage = this.labelRepository.findAll(PageRequest.of(page, size, Sort.Direction.DESC, "timestamp"));
        } else {
            labelsPage = this.labelRepository.searchLabels(search.toLowerCase(), PageRequest.of(page, size, Sort.Direction.DESC, "timestamp"));
        }
        List<LabelDTO> content = labelsPage.getContent().stream().map(label ->
                new LabelDTO(label.getId(), label.getDescription()))
                .collect(Collectors.toList());
        return new PageImpl<>(content, labelsPage.getPageable(), labelsPage.getTotalElements());
    }

    @Override
    public List<LabelDTO> getLabels() {
        return this.labelRepository.findAll().stream().map(label ->
                new LabelDTO(label.getId(), label.getDescription()))
                .collect(Collectors.toList());
    }
}
