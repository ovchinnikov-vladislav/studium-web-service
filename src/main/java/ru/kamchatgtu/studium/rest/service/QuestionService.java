package ru.kamchatgtu.studium.rest.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.kamchatgtu.studium.DAO.Factory;
import ru.kamchatgtu.studium.DAO.impl.QuestionDAOImpl;
import ru.kamchatgtu.studium.DAO.impl.ThemeDAOImpl;
import ru.kamchatgtu.studium.entity.Answer;
import ru.kamchatgtu.studium.entity.Question;
import ru.kamchatgtu.studium.entity.Theme;
import ru.kamchatgtu.studium.rest.Service;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collection;

@RestController
@RequestMapping(value = "/question_service")
public class QuestionService extends Service<Question> {

    public QuestionService() {
        super(Factory.getInstance().getQuestionDAO());
    }

    @Override
    @GetMapping(value = "/question")
    public Question get(@RequestParam Integer id) {
        return super.get(id);
    }

    @Override
    @GetMapping(value = "/questions")
    public Collection getAll() {
        return super.getAll();
    }

    @Override
    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Question add(@RequestBody Question request) {
        return super.add(request);
    }

    @Override
    @DeleteMapping(value = "/delete", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Question remove(@RequestBody Question request) {
        return super.remove(request);
    }

    @Override
    @PutMapping(value = "/update", produces = "application/json")
    @ResponseStatus(HttpStatus.OK)
    public Question update(@RequestBody Question request) {
        return super.update(request);
    }

    @GetMapping(value = "/questions_by_theme")
    public Collection getQuestionsByTheme(@RequestParam Integer id) {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            return ((QuestionDAOImpl) getDao()).searchByTheme(id);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }
}
