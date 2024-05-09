package fubuki.ref.equip;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class EquipFactory {

	public static Equip get(String classname) {
		try {
			Class<?> mClass = Class.forName("fubuki.ref.equip.item." + classname);
			return get(mClass);
			
		} catch (ClassNotFoundException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
	public static Equip get(Class<?> mClass) {
		try {
			Constructor<?> constructor = mClass.getConstructor();
			Object obj = constructor.newInstance();
			
			if( !Equip.class.isInstance(obj) ) {
				throw new IllegalAccessError("NOT AN EQUIP");
			}
			
			return (Equip) obj;
			
		} catch (NoSuchMethodException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			throw new IllegalArgumentException(e);
		}
	}
	
}
