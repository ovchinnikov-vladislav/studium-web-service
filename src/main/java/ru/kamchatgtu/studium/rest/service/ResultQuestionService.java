package ru.kamchatgtu.studium.rest.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.kamchatgtu.studium.DAO.Factory;
import ru.kamchatgtu.studium.DAO.impl.ResultQuestionDAOImpl;
import ru.kamchatgtu.studium.entity.Answer;
import ru.kamchatgtu.studium.entity.ResultQuestion;
import ru.kamchatgtu.studium.rest.Service;

import java.util.Collection;

@RestController
@RequestMapping(value = "/result_question_service")
public class ResultQuestionService extends Service<ResultQuestion> {

    public ResultQuestionService() {
        super(Factory.getInstance().getResultQuestionDAO());
    }

    @Override
    @GetMapping(value = "/result_question")
    public ResultQuestion get(@RequestParam Integer id) {
        return super.get(id);
    }

    @Override
    @GetMapping(value = "/result_questions")
    public Collection getAll() {
        return super.getAll();
    }

    @Override
    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public ResultQuestion add(@RequestBody ResultQuestion request) {
        return super.add(request);
    }

    @Override
    @DeleteMapping(value = "/delete", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResultQuestion remove(@RequestBody ResultQuestion request) {
        return super.remove(request);
    }

    @Override
    @PutMapping(value = "/update", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public ResultQuestion update(@RequestBody ResultQuestion request) {
        return super.update(request);
    }
}
