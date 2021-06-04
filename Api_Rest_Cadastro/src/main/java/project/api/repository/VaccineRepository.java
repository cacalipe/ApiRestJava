package project.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.api.entity.VaccinesEntity;

@Repository
public interface VaccineRepository extends JpaRepository<VaccinesEntity, Long>{

}
