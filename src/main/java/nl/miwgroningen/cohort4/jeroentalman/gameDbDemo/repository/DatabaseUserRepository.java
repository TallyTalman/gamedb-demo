package nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.repository;

import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.model.DatabaseUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Jeroen Talman <mail: j.k.talman@st.hanze.nl>
 *
 * repository voor het object DatabaseUser
 */

public interface DatabaseUserRepository extends JpaRepository<DatabaseUser, Integer> {
    Optional<DatabaseUser> findByUsername(String username);
}
