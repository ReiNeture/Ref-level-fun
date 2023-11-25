package fubuki.ref.equip;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipRepository extends JpaRepository<Equip, Long> {

}
