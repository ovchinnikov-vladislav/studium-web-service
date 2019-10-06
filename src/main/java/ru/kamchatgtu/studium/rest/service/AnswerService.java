package ru.kamchatgtu.studium.rest.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.kamchatgtu.studium.DAO.Factory;
import ru.kamchatgtu.studium.DAO.impl.AnswerDAOImpl;
import ru.kamchatgtu.studium.entity.Answer;
import ru.kamchatgtu.studium.rest.Service;
import java.util.Collection;

/**
 * Объект класса {@code AnswerService} отвечает за сервис доступа к ответам:
 * <br>1. Получение ответа по id
 * <br>2. Получение всех ответов
 * <br>3. Добавление ответа
 * <br>4. Удаление ответа
 * <br>5. Обновление ответа
 * <br>6. Поиск ответа
 * <br>7. Получение ответа по id вопроса
 * <br>Является Rest контроллером.
 * <br>Доступ осуществляется по адресу url: http://адрес_сервера/restful/answer_service
 * @author Овчинников В.А.
*/
@RestController
@RequestMapping(value = "/answer_service")
public class AnswerService extends Service<Answer> {

    public AnswerService() {
        super(Factory.getInstance().getAnswerDAO());
    }

    /**
     * Get-метод получения ответа по id. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/answer_service/answer?id=[Код ответа]
     * @param id код ответа
     * @return возвращает ответ
     */
    @Override
    @GetMapping(value = "/answer", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Answer get(@RequestParam Integer id) {
        return super.get(id);
    }

    /**
     * Get-метод получения всех ответов. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/answer_service/answers
     * @return возвращает коллекцию ответов
     */
    @Override
    @GetMapping(value = "/answers", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getAll() {
        return super.getAll();
    }

    /**
     * Post-метод добавления ответа. Тип запроса: POST. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/answer_service/add
     * @param request ответ
     * @return возвращает ответ
     */
    @Override
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Answer add(@RequestBody Answer request) {
        return super.add(request);
    }

    /**
     * Delete-метод удаления ответа. Тип запроса: DELETE. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/answer_service/delete
     * @param request ответ
     * @return возвращает ответ
     */
    @Override
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Answer remove(@RequestBody Answer request) {
        return super.remove(request);
    }

    /**
     * Put-метод обновления ответа. Тип запроса: PUT. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/answer_service/update
     * @param request ответ
     * @return возвращает ответ
     */
    @Override
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Answer update(@RequestBody Answer request) {
        return super.update(request);
    }

    /**
     * Put-метод поиска ответов. Тип запроса: PUT. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/answer_service/search
     * @param request ответ
     * @return возвращает коллекцию ответов
     */
    @Override
    @PutMapping(value = "/search", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection search(@RequestBody Answer request) {
        return super.search(request);
    }

    /**
     * Get-метод получения ответов по вопросу. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу: http://адрес_сервера/restful/answer_service/answers_by_question?id=[Код вопроса]
     * @param id код вопроса
     * @return возвращает коллекцию ответов
     */
    @GetMapping(value = "/answers_by_question", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getByQuestion(@RequestParam Integer id) {
        try {
            return ((AnswerDAOImpl) getDao()).getByQuestion(id);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }
}
