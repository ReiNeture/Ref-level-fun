package fubuki.ref.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fubuki.ref.dao.entity.Monster;
import fubuki.ref.dao.reposit.MonsterRepository;

@Service
public class MonsterManager {

	@Autowired
	MonsterRepository monsterReposit;
	
	public void createMonster(Monster data) {
		monsterReposit.save(data);
	}
	
}
