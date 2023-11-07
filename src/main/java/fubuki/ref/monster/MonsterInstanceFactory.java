package fubuki.ref.monster;

import org.springframework.stereotype.Component;

@Component
public class MonsterInstanceFactory {

	public static Monster getMonsterByName(String name) {
		
		if("Rabbit".equals(name))
			return new Rabbit();
		if("Noname".equals(name))
			return new Noname();
		
		return null;
	}
	
	
}
