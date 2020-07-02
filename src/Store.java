import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class Store {

    private List<User> users;

    public Store() {
        users = new ArrayList<>();
        users.add(new User("Daniel", "Aback", 34));
        users.add(new User("Adam", "Nowak", 42));
        users.add(new User("Beata", "Zagórska", 23));
    }

    public List<User> getAll() {
        return users;
    }

    public void add(User user) {
        users.add(user);
    }
}


