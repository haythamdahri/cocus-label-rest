package com.cocus.microservices.label.config;

import com.cocus.microservices.bo.entities.LabelBO;
import com.cocus.microservices.label.repositories.LabelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

/**
 * @author Haytham DAHRI
 */
@Configuration
public class ApplicationRunner implements CommandLineRunner {

    private final LabelRepository labelRepository;

    public ApplicationRunner(LabelRepository labelRepository) {
        this.labelRepository = labelRepository;
    }

    /**
     * Populate Testing DATA if environment is not production
     * @param args Input Arguments
     */
    @Override
    public void run(String... args) {
        if( this.labelRepository.count() == 0 ) {
            // Mock Labels
            LabelBO label = new LabelBO("Label Description");
            this.labelRepository.save(label);
        }
    }
}
