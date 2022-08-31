package willydekeyser.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import willydekeyser.model.Authorities;

public interface AuthoritiesRepository  extends JpaRepository<Authorities, Integer>{
	Optional<Authorities> findByAuthority(String Authority);
}