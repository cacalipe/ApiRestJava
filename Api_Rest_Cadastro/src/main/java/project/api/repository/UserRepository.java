package project.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import project.api.entity.UsersEntity;

@Repository
public interface UserRepository extends JpaRepository<UsersEntity, Long>{

}
