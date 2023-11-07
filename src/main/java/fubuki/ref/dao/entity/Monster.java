package fubuki.ref.dao.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Monster {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mid;
    
    @DecimalMin("1.0")
    private BigDecimal health = BigDecimal.ZERO;
    
    @DecimalMin("0.0")
    private BigDecimal damage = BigDecimal.ZERO;
    
    @Min(0)
    private int exp = 0;
    
    @Min(1)
    private int level = 1;
    
    @NotNull(message="Name is required")
    @NotBlank(message="Name is required")
    private String name;
    
    @NotNull(message="Image is required")
    @NotBlank(message="Image is required")
    private String image;
	
}
