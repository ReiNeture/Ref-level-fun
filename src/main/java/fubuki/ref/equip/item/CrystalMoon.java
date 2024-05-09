package fubuki.ref.equip.item;

import static fubuki.ref.equip.EquipType.WPN;

import fubuki.ref.equip.Equip;
import fubuki.ref.equip.EquipType;

public class CrystalMoon implements Equip {

	@Override
	public String name() {
		return "水晶之月";
	}

	@Override
	public int attack() {
		return 1000;
	}

	@Override
	public int health() {
		return 300;
	}

	@Override
	public int cost() {
		return 999999;
	}

	@Override
	public int critical() {
		return 20;
	}

	@Override
	public int requireLevel() {
		return 0;
	}

	@Override
	public EquipType type() {
		return WPN;
	}

}
