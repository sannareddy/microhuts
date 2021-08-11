package in.codehut.userservice.service.impl;

import org.springframework.data.repository.CrudRepository;

import in.codehut.userservice.data.models.UserEntity;

public interface UserRequestRepository extends CrudRepository<UserEntity, Long> {

}
