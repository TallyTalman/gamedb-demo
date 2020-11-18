package nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.repository;

import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model.Gamingsystem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Jeroen Talman <mail: j.k.talman@st.hanze.nl>
 *
 * Repository Interface for object Gamingsystem
 */

public interface GamingsystemRepository extends JpaRepository<Gamingsystem, Integer> {
    Optional<Gamingsystem> findByName(String name);
}
