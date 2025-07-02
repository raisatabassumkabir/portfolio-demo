package bd.edu.seu.portfolio_with_sql.service;

import bd.edu.seu.portfolio_with_sql.model.User;
import bd.edu.seu.portfolio_with_sql.repository.UserRepository;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    private  final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public User addUser(User user) {
        return userRepository.save(user);
    }


}
