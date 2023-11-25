package fubuki.ref.equip;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EquipService {

	@Autowired
	EquipRepository equipRepository;
	
	public void createEquip(Equip data) {
		equipRepository.save(data);
	}
	
}
