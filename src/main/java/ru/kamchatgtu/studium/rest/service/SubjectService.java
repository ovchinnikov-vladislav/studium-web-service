package ru.kamchatgtu.studium.rest.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.kamchatgtu.studium.DAO.Factory;
import ru.kamchatgtu.studium.entity.Subject;
import ru.kamchatgtu.studium.rest.Service;

import java.util.Collection;

@RestController
@RequestMapping(value = "/subject_service")
public class SubjectService extends Service<Subject> {

    public SubjectService() {
        super(Factory.getInstance().getSubjectDAO());
    }

    @Override
    @GetMapping(value = "/subject")
    public Subject get(@RequestParam Integer id) {
        return super.get(id);
    }

    @Override
    @GetMapping(value = "/subjects")
    public Collection getAll() {
        return super.getAll();
    }

    @Override
    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Subject add(@RequestBody Subject request) {
        return super.add(request);
    }

    @Override
    @DeleteMapping(value = "/delete", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Subject remove(@RequestBody Subject request) {
        return super.remove(request);
    }

    @Override
    @PutMapping(value = "/update", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Subject update(@RequestBody Subject request) {
        return super.update(request);
    }
}
