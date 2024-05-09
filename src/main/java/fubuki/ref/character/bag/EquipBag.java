package fubuki.ref.character.bag;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class EquipBag {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ebid;
	
	@NotNull
	private long pid;
	
	@NotBlank
	private String name;
	
	private String comment;
	
	private LocalDateTime createdAt;
	
	
	@PrePersist
    void createdAt() {
        this.createdAt = LocalDateTime.now();
    }
	
	public EquipBag(long pid) {
		this.pid = pid;
	}
	
}
