@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User register(User user) {
        if (repo.existsByEmail(user.getEmail())) {
            throw new BadRequestException("email exists");
        }
        return repo.save(user);
    }

    public User findByEmail(String email) {
        User user = repo.findByEmail(email);
        if (user == null) {
            throw new ResourceNotFoundException("user not found");
        }
        return user;
    }
}
