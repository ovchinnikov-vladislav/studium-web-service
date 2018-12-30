package ru.kamchatgtu.studium.rest.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.kamchatgtu.studium.DAO.Factory;
import ru.kamchatgtu.studium.DAO.impl.UserDAOImpl;
import ru.kamchatgtu.studium.entity.User;
import ru.kamchatgtu.studium.rest.Service;

import java.util.Collection;

@RestController
@RequestMapping(value="/user_service")
public class UserService extends Service<User> {

    public UserService() {
        super(Factory.getInstance().getUserDAO());
    }

    @Override
    @GetMapping("/user")
    public User get(@RequestParam Integer id) {
        return super.get(id);
    }

    @Override
    @GetMapping(value="/users")
    public Collection getAll() {
        return super.getAll();
    }

    @Override
    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public User add(@RequestBody User request) {
        return super.add(request);
    }

    @Override
    @DeleteMapping(value = "/delete", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public User remove(@RequestBody User request) {
        return super.remove(request);
    }

    @Override
    @PutMapping(value = "/update", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public User update(@RequestBody User request) {
        return super.update(request);
    }

    @GetMapping("/sign_in")
    public User login(@RequestParam String login) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return ((UserDAOImpl) getDao()).login(login);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    @PostMapping("/search")
    public Collection search(@RequestBody User user) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return getDao().search(user);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    @GetMapping("/user_by_email")
    public User searchByEmail(@RequestParam String email) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return ((UserDAOImpl) getDao()).searchByEmail(email);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    @GetMapping("/user_by_login")
    public User searchByLogin(@RequestParam String login) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return ((UserDAOImpl) getDao()).searchByLogin(login);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }
}