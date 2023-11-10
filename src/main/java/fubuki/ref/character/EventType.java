package fubuki.ref.character;

import lombok.Getter;

@Getter
public enum EventType {
	IDLE("閒置"), COMBAT("戰鬥"), EXPLORE("探索"), BLOCK("禁止");
	
	private String cname;
	
	private EventType(String value) {
        this.cname = value;
    }
}
