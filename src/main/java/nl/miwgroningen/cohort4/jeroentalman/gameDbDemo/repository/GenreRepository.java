package nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.repository;

import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Jeroen Talman <mail: j.k.talman@st.hanze.nl>
 *
 * Repository Interface for object Genre
 */

public interface GenreRepository extends JpaRepository<Genre, Integer> {
    Optional<Genre> findByName(String name);
}
