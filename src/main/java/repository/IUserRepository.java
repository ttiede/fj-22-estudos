package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import br.com.caelum.fj22estudos.model.User;
@Repository("userRepository")
public interface IUserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}