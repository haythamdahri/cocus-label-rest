package com.cocus.microservices.label.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * @author Haytham DAHRI
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LabelRequestDTO  implements Serializable {

    private static final long serialVersionUID = 6156787334352530121L;

    @JsonIgnore
    private Long id;

    @JsonProperty("description")
    @NotNull
    @NotEmpty
    private String description;

}
