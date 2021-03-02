package com.cocus.microservices.label.controllers;

import com.cocus.microservices.bo.entities.LabelBO;
import com.cocus.microservices.label.dto.LabelDTO;
import com.cocus.microservices.label.dto.LabelRequestDTO;
import com.cocus.microservices.label.services.LabelService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Haytham DAHRI
 */
@RestController
@RequestMapping(path = "/api/v1/labels")
public class LabelController {

    private final LabelService labelService;

    public LabelController(LabelService labelService) {
        this.labelService = labelService;
    }

    @GetMapping(path = "/")
    public ResponseEntity<List<LabelDTO>> getLabels() {
        return ResponseEntity.ok(this.labelService.getLabels());
    }

    @PostMapping(path = "/")
    public ResponseEntity<LabelBO> saveLabel(@RequestBody LabelRequestDTO labelRequest) {
        return ResponseEntity.ok(this.labelService.saveLabel(labelRequest));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<LabelBO> updateLabel(@PathVariable(name = "id") Long id, @RequestBody LabelRequestDTO labelRequest) {
        labelRequest.setId(id);
        return ResponseEntity.ok(this.labelService.saveLabel(labelRequest));
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<LabelBO> getLabel(@PathVariable(name = "id") Long id) {
        return ResponseEntity.ok(this.labelService.getLabel(id));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteLabel(@PathVariable(name = "id") Long id) {
        this.labelService.deleteLabel(id);
        return ResponseEntity.ok().build();
    }

}
