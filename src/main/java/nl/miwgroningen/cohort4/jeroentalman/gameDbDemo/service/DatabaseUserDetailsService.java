package nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.service;

import nl.miwgroningen.cohort4.jeroentalman.gameDbDemo.repository.DatabaseUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Jeroen Talman <mail: j.k.talman@st.hanze.nl>
 */

@Service
public class DatabaseUserDetailsService implements UserDetailsService {

    @Autowired
    DatabaseUserRepository databaseUserRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return databaseUserRepository.findByUsername(s).orElseThrow(
                () -> new UsernameNotFoundException("User " + s + " was not found.")
        );
    }
}
