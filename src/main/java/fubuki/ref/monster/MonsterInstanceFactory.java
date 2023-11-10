package fubuki.ref.monster;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.springframework.stereotype.Component;

@Component
public class MonsterInstanceFactory {

	private static Map<String, Monster> monsterCollection = new HashMap<>();
	
	public static Monster getMonsterByName(String name) {
		
		try {
			Monster temp = monsterCollection.get(name);
			if( Objects.nonNull(temp) )
				return temp;
			
			Class<?> mClass = Class.forName("fubuki.ref.monster." + name);
			temp = reflectionByClass(mClass);
			
			monsterCollection.put(name, temp);
			return temp;
		
		} catch(Exception e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	public static Monster getMonsterByClass(Class<? extends Monster> mClass) {
		
		try {
			final String name = mClass.getSimpleName();
			
			Monster temp = monsterCollection.get(name);
			if( Objects.nonNull(temp) )
				return temp;
			
			temp = reflectionByClass(mClass);
			monsterCollection.put(name, temp);
			
			return temp;
			
		} catch(Exception e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	private static Monster reflectionByClass(Class<?> mClass) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException {
		Constructor<?> constructor = mClass.getConstructor();
		Object obj = constructor.newInstance();
		
		if( !Monster.class.isInstance(obj) ) {
			throw new IllegalAccessError("not a monster");
		}
		
		return (Monster) obj;
	}
}
