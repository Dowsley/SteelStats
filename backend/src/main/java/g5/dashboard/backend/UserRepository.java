package g5.dashboard.backend;

import org.springframework.data.repository.CrudRepository;

import g5.dashboard.backend.User;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface UserRepository extends CrudRepository<User, Integer> {

}