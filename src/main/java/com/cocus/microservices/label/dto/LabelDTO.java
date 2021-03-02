package com.cocus.microservices.label.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Haytham DAHRI
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LabelDTO implements Serializable {

    private static final long serialVersionUID = 764271895535614154L;

    @JsonProperty("id")
    private long id;

    @JsonProperty("description")
    private String description;

}
