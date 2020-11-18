package nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.repository;

import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Jeroen Talman <mail: j.k.talman@st.hanze.nl>
 *
 * Repository Interface for object Game
 */

public interface GameRespository extends JpaRepository<Game, Integer> {
    Optional<Game> findByTitle(String title);
}
