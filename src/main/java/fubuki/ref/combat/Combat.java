package fubuki.ref.combat;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Combat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@NotNull
	private Long playerId;
	
	@NotBlank
	private String monsterName;
	
	private LocalDateTime startTime;
	private LocalDateTime endTime;
	
	private String history;
	
	private boolean victory;
	
    @PrePersist
    void startTime() {
        this.startTime = LocalDateTime.now();
    }
}
