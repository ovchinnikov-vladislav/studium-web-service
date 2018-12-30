package ru.kamchatgtu.studium.rest.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.kamchatgtu.studium.DAO.Factory;
import ru.kamchatgtu.studium.DAO.impl.GroupDAOImpl;
import ru.kamchatgtu.studium.entity.Group;
import ru.kamchatgtu.studium.rest.Service;

import java.util.Collection;

@RestController
@RequestMapping(value = "/group_service")
public class GroupService extends Service<Group> {

    public GroupService() {
        super(Factory.getInstance().getGroupDAO());
    }

    @Override
    @GetMapping(value = "/group")
    public Group get(@RequestParam Integer id) {
        return super.get(id);
    }

    @Override
    @GetMapping(value = "/groups")
    public Collection getAll() {
        return super.getAll();
    }

    @Override
    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Group add(Group request) {
        return super.add(request);
    }

    @Override
    @DeleteMapping(value = "/delete", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Group remove(Group request) {
        return super.remove(request);
    }

    @Override
    @PutMapping(value = "/update", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Group update(Group request) {
        return super.update(request);
    }

    @GetMapping(value = "/groups_by_position")
    public Collection getGroupsByPosition(@RequestParam Integer id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return ((GroupDAOImpl) getDao()).getGroupsByPosition(id);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }
}
