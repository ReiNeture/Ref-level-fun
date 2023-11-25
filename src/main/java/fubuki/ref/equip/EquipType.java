package fubuki.ref.equip;

import lombok.Getter;

@Getter
public enum EquipType {
	WPN("武器"), SUIT("套服"), RING("戒指"), HAT("帽子");
	
	private String cname;
	
	private EquipType(String value) {
        this.cname = value;
    }
}
