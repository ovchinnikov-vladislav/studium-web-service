package ru.kamchatgtu.studium.rest.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.kamchatgtu.studium.DAO.Factory;
import ru.kamchatgtu.studium.DAO.impl.QuestionDAOImpl;
import ru.kamchatgtu.studium.entity.Question;
import ru.kamchatgtu.studium.rest.Service;
import java.util.Collection;

/**
 * Объект класса {@code QuestionService} отвечает за сервис доступа к вопросам:
 * <br>1. Получение вопроса по id
 * <br>2. Получение всех вопросов
 * <br>3. Добавление вопроса
 * <br>4. Удаление вопроса
 * <br>5. Обновление вопроса
 * <br>6. Поиск вопросов
 * <br>7. Получение вопросов по id темы
 * <br>Является Rest контроллером.
 * <br>Доступ осуществляется по адресу url: http://адрес_сервера/restful/question_service
 * @author Овчинников В.А.
 */
@RestController
@RequestMapping(value = "/question_service")
public class QuestionService extends Service<Question> {

    public QuestionService() {
        super(Factory.getInstance().getQuestionDAO());
    }

    /**
     * Get-метод получения вопросов по id. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/question_service/question?id=[Код вопроса]
     * @param id код вопроса
     * @return возвращает вопрос
     */
    @Override
    @GetMapping(value = "/question", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Question get(@RequestParam Integer id) {
        return super.get(id);
    }

    /**
     * Get-метод получения всех вопросов. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/question_service/questions
     * @return возвращает коллекцию вопросов
     */
    @Override
    @GetMapping(value = "/questions", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getAll() {
        return super.getAll();
    }

    /**
     * Post-метод добавления вопроса. Тип запроса: POST. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/question_service/add
     * @param request вопрос
     * @return возвращает вопрос
     */
    @Override
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Question add(@RequestBody Question request) {
        return super.add(request);
    }

    /**
     * Delete-метод удаления вопроса. Тип запроса: DELETE. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/question_service/delete
     * @param request вопрос
     * @return возвращает вопрос
     */
    @Override
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Question remove(@RequestBody Question request) {
        return super.remove(request);
    }

    /**
     * Put-метод обновления вопроса. Тип запроса: PUT. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/question_service/update
     * @param request вопрос
     * @return возвращает вопрос
     */
    @Override
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Question update(@RequestBody Question request) {
        return super.update(request);
    }

    /**
     * Put-метод поиска вопросов. Тип запроса: PUT. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/question_service/search
     * @param request вопрос
     * @return возвращает коллекцию вопросов
     */
    @Override
    @PutMapping(value = "/search", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection search(@RequestBody Question request) {
        return super.search(request);
    }

    /**
     * Get-метод получения вопросов по теме. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу: http://адрес_сервера/restful/question_service/questions_by_theme?id=[Код темы]
     * @param id код темы
     * @return возвращает коллекцию вопросов
     */
    @GetMapping(value = "/questions_by_theme", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getByTheme(@RequestParam Integer id) {
        try {
            return ((QuestionDAOImpl) getDao()).getByTheme(id);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }
}
