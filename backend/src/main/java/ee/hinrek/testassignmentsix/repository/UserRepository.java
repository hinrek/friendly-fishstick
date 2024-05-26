package ee.hinrek.testassignmentsix.repository;

import ee.hinrek.testassignmentsix.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}