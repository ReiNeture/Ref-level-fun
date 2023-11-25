package fubuki.ref.player;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Player {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(unique = true)
    @Pattern(regexp = "^\\w{3,20}$")
    private String username;
    
    @Pattern(regexp = "^\\w{6,20}$")
    private String password;
    
    private LocalDateTime createdAt;
    
    @PrePersist
    void createdAt() {
        this.createdAt = LocalDateTime.now();
    }
}
