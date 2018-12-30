package ru.kamchatgtu.studium.rest.service;

import java.util.Collection;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.kamchatgtu.studium.DAO.Factory;
import ru.kamchatgtu.studium.DAO.impl.TestDAOImpl;
import ru.kamchatgtu.studium.entity.Test;
import ru.kamchatgtu.studium.entity.User;
import ru.kamchatgtu.studium.rest.Service;

@RestController
@RequestMapping(value = "/test_service")
public class TestService extends Service<Test> {

    public TestService() {
        super(Factory.getInstance().getTestDAO());
    }

    @Override
    @GetMapping(value = "/test")
    public Test get(@RequestParam Integer id) {
        return super.get(id);
    }

    @Override
    @GetMapping(value = "/tests")
    public Collection getAll() {
        return super.getAll();
    }

    @Override
    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Test add(@RequestBody Test request) {
        return super.add(request);
    }

    @Override
    @DeleteMapping(value = "/delete", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Test remove(@RequestBody Test request) {
        return super.remove(request);
    }

    @Override
    @PutMapping(value = "/update", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Test update(@RequestBody Test request) {
        return super.update(request);
    }

    @GetMapping(value = "/tests_by_subject")
    public Collection searchBySubject(@RequestParam Integer id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return ((TestDAOImpl)getDao()).searchBySubject(id);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }
}
