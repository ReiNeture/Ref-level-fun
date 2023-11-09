package fubuki.ref.monster;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class MonsterInstanceFactory {

	private static Map<String, Monster> monsterCollection = new HashMap<>();
	
	public static Monster getMonsterByName(String name) {
		
		Monster temp = monsterCollection.get(name);
		if( Objects.nonNull(temp) )
			return temp;
		
		if("Rabbit".equals(name))
			temp = new Rabbit();
		else if("Noname".equals(name))
			temp = new Noname();
		else if("Dark-Rabbit".equals(name))
			temp = new DarkRabbit();
		
		return temp;
	}
	
	
}
