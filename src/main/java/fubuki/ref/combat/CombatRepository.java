package fubuki.ref.combat;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CombatRepository extends JpaRepository<Combat, Long> {
	
	Optional<Combat> findByPlayerId(long id);
	
}
