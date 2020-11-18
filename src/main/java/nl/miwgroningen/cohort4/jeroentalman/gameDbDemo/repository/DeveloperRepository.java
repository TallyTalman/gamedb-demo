package nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.repository;

import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model.Developer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Jeroen Talman <mail: j.k.talman@st.hanze.nl>
 *
 * Repository for the object Developer
 */

public interface DeveloperRepository extends JpaRepository<Developer, Integer> {
    Optional<Developer> findByName(String name);
}
