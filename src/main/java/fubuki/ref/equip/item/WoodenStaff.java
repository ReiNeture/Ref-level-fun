package fubuki.ref.equip.item;

import static fubuki.ref.equip.EquipType.WPN;

import fubuki.ref.equip.Equip;
import fubuki.ref.equip.EquipType;

public class WoodenStaff implements Equip {

	@Override
	public String name() {
		return "木製短杖";
	}

	@Override
	public int attack() {
		return 20;
	}

	@Override
	public int health() {
		return 0;
	}

	@Override
	public int cost() {
		return 100;
	}

	@Override
	public int critical() {
		return 0;
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
