package fubuki.ref.dao.reposit;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import fubuki.ref.dao.entity.Monster;
import fubuki.ref.dao.entity.Player;

@Repository
public interface MonsterRepository extends JpaRepository<Monster, Long> {

	Player findByName(String name);
}
