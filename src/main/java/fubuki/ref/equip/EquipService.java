package fubuki.ref.equip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fubuki.ref.character.bag.EquipBag;
import fubuki.ref.character.bag.EquipBagRepository;

@Service
public class EquipService {

	@Autowired
	EquipBagRepository equipBagRepository;
	
	public void buyAnEquip(String item, long pid) {
		
		Equip equip = EquipFactory.get(item);
		
		EquipBag bag = new EquipBag(pid);
		bag.setName(equip.name());
		bag.setComment("");
		
		equipBagRepository.save(bag);
	}
	
}
