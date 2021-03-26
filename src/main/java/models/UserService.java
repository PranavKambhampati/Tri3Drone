package models;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
/*
This class is an instance of PersonRepository
-- @Autowired annotation. Allows Spring to resolve and inject collaborating beans into our bean.
-- Spring Data JPA will generate a proxy instance of ProductRepository
-- Look at all the CRUD methods that we can use with our database
*/
@Service
@Transactional
public class UserService {

    @Autowired
    private UserJpaRepository prep;

    public List<User> listAll() {
        return prep.findAll();
    }

    public void save(User user) {
        prep.save(user);
    }

    public User get(long id) {
        return prep.findById(id).get();
    }

    public void delete(long id) {
        prep.deleteById(id);
    }
}