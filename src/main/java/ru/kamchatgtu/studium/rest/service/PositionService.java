package ru.kamchatgtu.studium.rest.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.kamchatgtu.studium.DAO.Factory;
import ru.kamchatgtu.studium.entity.Answer;
import ru.kamchatgtu.studium.entity.Position;
import ru.kamchatgtu.studium.rest.Service;

import java.util.Collection;

@RestController
@RequestMapping(value = "/position_service")
public class PositionService extends Service<Position> {

    public PositionService() {
        super(Factory.getInstance().getPositionDAO());
    }

    @Override
    @GetMapping("/position")
    public Position get(@RequestParam Integer id) {
        return super.get(id);
    }

    @Override
    @GetMapping("/positions")
    public Collection getAll() {
        return super.getAll();
    }

    @Override
    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Position add(@RequestBody Position request) {
        return super.add(request);
    }

    @Override
    @DeleteMapping(value = "/delete", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Position remove(@RequestBody Position request) {
        return super.remove(request);
    }

    @Override
    @PutMapping(value = "/update", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Position update(@RequestBody Position request) {
        return super.update(request);
    }
}
