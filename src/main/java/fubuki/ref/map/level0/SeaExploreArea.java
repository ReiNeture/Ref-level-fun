package fubuki.ref.map.level0;

import static fubuki.ref.monster.MonsterInstanceFactory.getMonsterByClass;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import fubuki.ref.monster.DarkRabbit;
import fubuki.ref.monster.Monster;
import fubuki.ref.monster.Rabbit;

@Service
public class SeaExploreArea {

	public List<Monster> getSeaMonsters() {
		return Arrays.asList(
				getMonsterByClass(Rabbit.class), 
				getMonsterByClass(Rabbit.class),
				getMonsterByClass(Rabbit.class), 
				getMonsterByClass(DarkRabbit.class));
	}

}
