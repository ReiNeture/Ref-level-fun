package fubuki.ref.combat;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TakeDamage {

	private BigDecimal damage;
	private String displayText;
	
}
