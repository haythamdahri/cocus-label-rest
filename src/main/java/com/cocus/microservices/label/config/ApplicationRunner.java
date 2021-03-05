package com.cocus.microservices.label.config;

import com.cocus.microservices.bo.entities.LabelBO;
import com.cocus.microservices.label.repositories.LabelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

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
            List<LabelBO> labels = new ArrayList<>();
            labels.add(new LabelBO("ICD_10  ICD_10_Description"));
            labels.add(new LabelBO("A09     Infectious gastroenteritis and colitis"));
            labels.add(new LabelBO("A64     Unspecified sexually transmitted disease"));
            labels.add(new LabelBO("B300    Keratoconjunctivitis due to adenovirus"));
            labels.add(new LabelBO("B302    Viral pharyngoconjunctivitis"));
            labels.add(new LabelBO("B308    Other viral conjunctivitis"));
            labels.add(new LabelBO("B309    Viral conjunctivitis"));
            labels.add(new LabelBO("B373    Candidiasis of vulva and vagina"));
            labels.add(new LabelBO("B9789   Other viral agents as the cause of diseases classified elsewhere"));
            labels.add(new LabelBO("E860    Dehydration"));
            labels.add(new LabelBO("F340    Cyclothymic disorder"));
            labels.add(new LabelBO("F341    Dysthymic disorder"));
            labels.add(new LabelBO("F39     Unspecified mood [affective] disorder"));
            labels.add(new LabelBO("F411    Generalized anxiety disorder"));
            labels.add(new LabelBO("F418    Other specified anxiety disorders"));
            labels.add(new LabelBO("F419    Anxiety disorder"));
            labels.add(new LabelBO("F4321   Adjustment disorder with depressed mood"));
            labels.add(new LabelBO("G43001  Migraine without aura"));
            labels.add(new LabelBO("G43009  Migraine without aura"));
            labels.add(new LabelBO("G43019  Migraine without aura"));
            labels.add(new LabelBO("G43501  Persistent migraine aura without cerebral infarction"));
            labels.add(new LabelBO("G43509  Persistent migraine aura without cerebral infarction"));
            labels.add(new LabelBO("G43519  Persistent migraine aura without cerebral infarction"));
            labels.add(new LabelBO("G43701  Chronic migraine without aura"));
            labels.add(new LabelBO("G43709  Chronic migraine without aura"));
            labels.add(new LabelBO("G43711  Chronic migraine without aura"));
            labels.add(new LabelBO("G43719  Chronic migraine without aura"));
            labels.add(new LabelBO("G43809  Other migraine"));
            labels.add(new LabelBO("G43811  Other migraine"));
            labels.add(new LabelBO("G43819  Other migraine"));
            labels.add(new LabelBO("G43829  Menstrual migraine"));
            labels.add(new LabelBO("G43909  Migraine"));
            labels.add(new LabelBO("G43911  Migraine"));
            labels.add(new LabelBO("G43919  Migraine"));
            labels.add(new LabelBO("G44209  Tension-type headache"));
            labels.add(new LabelBO("G44219  Episodic tension-type headache"));
            labels.add(new LabelBO("G4700   Insomnia"));
            labels.add(new LabelBO("G4701   Insomnia due to medical condition"));
            labels.add(new LabelBO("G5600   Carpal tunnel syndrome"));
            labels.add(new LabelBO("H10029  Other mucopurulent conjunctivitis"));
            labels.add(new LabelBO("H1033   Unspecified acute conjunctivitis"));
            labels.add(new LabelBO("H1044   Vernal conjunctivitis"));
            labels.add(new LabelBO("H1045   Other chronic allergic conjunctivitis"));
            labels.add(new LabelBO("H10509  Unspecified blepharoconjunctivitis"));
            labels.add(new LabelBO("H10819  Pingueculitis"));
            labels.add(new LabelBO("H1089   Other conjunctivitis"));
            labels.add(new LabelBO("H109    Unspecified conjunctivitis"));
            labels.add(new LabelBO("H6020   Malignant otitis externa"));
            labels.add(new LabelBO("H60339  Swimmer's ear"));
            labels.add(new LabelBO("H60399  Other infective otitis externa"));
            labels.add(new LabelBO("H6500   Acute serous otitis media"));
            labels.add(new LabelBO("H65119  Acute and subacute allergic otitis media (mucoid) (sanguinous) (serous)"));
            labels.add(new LabelBO("H65199  Other acute nonsuppurative otitis media"));
            labels.add(new LabelBO("H6520   Chronic serous otitis media"));
            labels.add(new LabelBO("H65499  Other chronic nonsuppurative otitis media"));
            labels.add(new LabelBO("H6590   Unspecified nonsuppurative otitis media"));
            labels.add(new LabelBO("H66009  Acute suppurative otitis media without spontaneous rupture of ear drum"));
            labels.add(new LabelBO("H66019  Acute suppurative otitis media with spontaneous rupture of ear drum"));
            labels.add(new LabelBO("H663X9  Other chronic suppurative otitis media"));
            labels.add(new LabelBO("H6640   Suppurative otitis media"));
            labels.add(new LabelBO("H6690   Otitis media"));
            labels.add(new LabelBO("J00     Acute nasopharyngitis [common cold]"));
            labels.add(new LabelBO("J0100   Acute maxillary sinusitis"));
            labels.add(new LabelBO("J0110   Acute frontal sinusitis"));
            labels.add(new LabelBO("J0130   Acute sphenoidal sinusitis"));
            labels.add(new LabelBO("J0140   Acute pansinusitis"));
            labels.add(new LabelBO("J0190   Acute sinusitis"));
            labels.add(new LabelBO("J029    Acute pharyngitis"));
            labels.add(new LabelBO("J060    Acute laryngopharyngitis"));
            this.labelRepository.saveAll(labels);
        }
    }
}
