package fubuki.ref.map.level0;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import fubuki.ref.equip.Equip;
import fubuki.ref.equip.EquipFactory;
import fubuki.ref.equip.item.CrystalMoon;
import fubuki.ref.equip.item.WoodenStaff;

@Service
public class ShoppingStreet {

	public List<Equip> getShoppingStreetGoods() {
    	return Arrays.asList(
    			EquipFactory.get(WoodenStaff.class),
    			EquipFactory.get(CrystalMoon.class));
	}
	
}
