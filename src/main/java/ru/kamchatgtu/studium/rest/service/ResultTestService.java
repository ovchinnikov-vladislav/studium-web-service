package ru.kamchatgtu.studium.rest.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.kamchatgtu.studium.DAO.Factory;
import ru.kamchatgtu.studium.entity.Answer;
import ru.kamchatgtu.studium.entity.ResultTest;
import ru.kamchatgtu.studium.rest.Service;

import java.util.Collection;

@RestController
@RequestMapping(value = "/result_test_service")
public class ResultTestService extends Service<ResultTest> {

    public ResultTestService() {
        super(Factory.getInstance().getResultTestDAO());
    }

    @Override
    @GetMapping(value = "/result_test")
    public ResultTest get(@RequestParam Integer id) {
        return super.get(id);
    }

    @Override
    @GetMapping(value = "/result_tests")
    public Collection getAll() {
        return super.getAll();
    }

    @Override
    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultTest add(@RequestBody ResultTest request) {
        return super.add(request);
    }

    @Override
    @DeleteMapping(value = "/delete", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResultTest remove(@RequestBody ResultTest request) {
        return super.remove(request);
    }

    @Override
    @PutMapping(value = "/update", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResultTest update(@RequestBody ResultTest request) {
        return super.update(request);
    }
}
