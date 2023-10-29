package fubuki.ref.dao.reposit;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fubuki.ref.dao.entity.Player;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

	Player findByUsername(String name);
	Player findByUsernameAndPassword(String name, String pwd);
}
