package fubuki.ref.character.bag;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipBagRepository extends JpaRepository<EquipBag, Long> {

}
