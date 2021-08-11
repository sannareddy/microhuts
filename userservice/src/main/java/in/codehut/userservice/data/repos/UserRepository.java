package in.codehut.userservice.data.repos;

import org.springframework.data.repository.CrudRepository;

import in.codehut.userservice.data.models.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long>{
	UserEntity findByEmail(String email);
}
