package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import models.Figurinha;

@Repository
public interface FigurinhaRepository extends JpaRepository<Figurinha, Long>{
	


}
