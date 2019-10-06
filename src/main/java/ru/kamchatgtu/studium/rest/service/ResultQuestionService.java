package ru.kamchatgtu.studium.rest.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.kamchatgtu.studium.DAO.Factory;
import ru.kamchatgtu.studium.DAO.impl.ResultQuestionDAOImpl;
import ru.kamchatgtu.studium.entity.ResultQuestion;
import ru.kamchatgtu.studium.rest.Service;
import java.util.Collection;

/**
 * Объект класса {@code ResultQuestionService} отвечает за сервис доступа к результатам по ответам конкретного вопроса:
 * <br>1. Получение результатов по ответам конкретного вопроса по id
 * <br>2. Получение всех результатов по ответам конкретного вопроса
 * <br>3. Добавление результатов по ответам конкретного вопроса
 * <br>4. Удаление результатов по ответам конкретного вопроса
 * <br>5. Обновление результатов по ответам конкретного вопроса
 * <br>6. Поиск результатов по ответам конкретного вопроса
 * <br>7. Получение результатов по ответам конкретного вопроса по id результата по тесту
 * <br>8. Получение результатов по ответам конкретного вопроса по id вопроса и id результата по тесту
 * <br>Является Rest контроллером.
 * <br>Доступ осуществляется по адресу url: http://адрес_сервера/restful/result_question_service
 * @author Овчинников В.А.
 */
@RestController
@RequestMapping(value = "/result_question_service")
public class ResultQuestionService extends Service<ResultQuestion> {

    public ResultQuestionService() {
        super(Factory.getInstance().getResultQuestionDAO());
    }

    /**
     * Get-метод получения результата по ответу конкретного вопроса по id. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/result_question_service/result_question?id=[Код результата по ответу конкретного вопроса]
     * @param id код результата по ответу конкретного вопроса
     * @return возвращает результат по ответу конкретного вопроса
     */
    @Override
    @GetMapping(value = "/result_question", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultQuestion get(@RequestParam Integer id) {
        return super.get(id);
    }

    /**
     * Get-метод получения всех результатов по ответам конкретных вопросов. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/result_question_service/result_questions
     * @return возвращает коллекцию результатов по ответам конретных вопросов
     */
    @Override
    @GetMapping(value = "/result_questions", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getAll() {
        return super.getAll();
    }

    /**
     * Post-метод добавления результата по ответу конкретного вопроса. Тип запроса: POST. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/result_question_service/add
     * @param request результат по ответу конкретного вопроса
     * @return возвращает результат по ответу конкретного вопроса
     */
    @Override
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResultQuestion add(@RequestBody ResultQuestion request) {
        return super.add(request);
    }

    /**
     * Delete-метод удаления результата по ответу конкретного вопроса. Тип запроса: DELETE. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/result_question_service/delete
     * @param request результат по ответу конкретного вопроса
     * @return возвращает результат по ответу конкретного вопроса
     */
    @Override
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResultQuestion remove(@RequestBody ResultQuestion request) {
        return super.remove(request);
    }

    /**
     * Put-метод обновления результата по ответу конкретного вопроса. Тип запроса: PUT. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/result_question_service/update
     * @param request результат по ответу конкретного вопроса
     * @return возвращает результат по ответу конкретного вопроса
     */
    @Override
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResultQuestion update(@RequestBody ResultQuestion request) {
        return super.update(request);
    }

    /**
     * Put-метод поиска результатов по ответам конкретных вопросов. Тип запроса: PUT. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/result_question_service/search
     * @param request результат по ответу конкретного вопроса
     * @return возвращает коллекцию результатов по ответам конкретных вопросов
     */
    @Override
    @PutMapping(value = "/search", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection search(@RequestBody ResultQuestion request) {
        return super.search(request);
    }

    /**
     * Get-метод получения результатов по ответам конкретных вопросов по id результата по тесту. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу: http://адрес_сервера/restful/result_question_service/result_questions_by_result_test?id=[Код результата по тесту]
     * @param id код результата по тесту
     * @return возвращает коллекцию результатов по ответам конкретных вопросов
     */
    @GetMapping(value = "/result_questions_by_result_test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getByResultTest(@RequestParam Integer id) {
        try {
            return ((ResultQuestionDAOImpl) getDao()).getByResultTest(id);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    /**
     * Get-метод получения результатов по ответам конкретных вопросов по id вопроса и id результата по тесту. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу: http://адрес_сервера/restful/result_question_service/result_questions_by_question_and_result_test?id_q=[Код вопроса]&amp;&amp;id_r=[Код результата по тесту]
     * @param id_q код вопроса
     * @param id_r код результата по тесту
     * @return возвращает коллекцию результатов по ответам конкретных вопросов
     */
    @GetMapping(value = "/result_questions_by_question_and_result_test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getByQuestionAndResultQuestion(@RequestParam Integer id_q, @RequestParam Integer id_r) {
        try {
            return ((ResultQuestionDAOImpl) getDao()).getByQuestionAndResultTest(id_q, id_r);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    /**
     * Get-метод удаления результата по ответу конкретного вопроса по id. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/result_question_service/delete_by_id
     * @param id результат по ответу конкретного вопроса
     * @return возвращает результат по ответу конкретного вопроса
     */
    @GetMapping(value = "/delete_by_id", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultQuestion remove(@RequestParam Integer id) {
        try {
            return ((ResultQuestionDAOImpl) getDao()).removeById(id);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }
}
