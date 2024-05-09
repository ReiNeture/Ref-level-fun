package fubuki.ref.equip;

public interface Equip {

	String name();
	
	int attack();
	int health();
	int cost();
	int critical();
	int requireLevel();
	
	EquipType type();
	
}
