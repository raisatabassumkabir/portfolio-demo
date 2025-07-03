package bd.edu.seu.portfolio_with_sql.repository;

import bd.edu.seu.portfolio_with_sql.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, String> {


}


