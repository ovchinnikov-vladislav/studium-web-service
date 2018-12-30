package ru.kamchatgtu.studium.rest.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.kamchatgtu.studium.DAO.Factory;
import ru.kamchatgtu.studium.DAO.impl.AnswerDAOImpl;
import ru.kamchatgtu.studium.entity.Answer;
import ru.kamchatgtu.studium.entity.User;
import ru.kamchatgtu.studium.rest.Service;

import java.util.Collection;

@RestController
@RequestMapping(value = "/answer_service")
public class AnswerService extends Service<Answer> {

    public AnswerService() {
        super(Factory.getInstance().getAnswerDAO());
    }

    @Override
    @GetMapping("/answer")
    public Answer get(@RequestParam Integer id) {
        return super.get(id);
    }

    @Override
    @GetMapping("/answers")
    public Collection getAll() {
        return super.getAll();
    }

    @Override
    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Answer add(@RequestBody Answer request) {
        return super.add(request);
    }

    @Override
    @DeleteMapping(value = "/delete", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Answer remove(@RequestBody Answer request) {
        return super.remove(request);
    }

    @Override
    @PutMapping(value = "/update", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Answer update(@RequestBody Answer request) {
        return super.update(request);
    }

    @GetMapping("/answer_by_question")
    public Collection searchByQuestion(@RequestParam Integer id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return ((AnswerDAOImpl) getDao()).searchByQuestion(id);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }
}
