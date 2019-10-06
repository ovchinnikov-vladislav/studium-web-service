package ru.kamchatgtu.studium.rest.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.kamchatgtu.studium.DAO.Factory;
import ru.kamchatgtu.studium.DAO.impl.ResultTestDAOImpl;
import ru.kamchatgtu.studium.entity.*;
import ru.kamchatgtu.studium.rest.Service;
import java.util.Collection;

/**
 * Объект класса {@code ResultTestService} отвечает за сервис доступа к результатам по тесту:
 * <br>1. Получение результатов по тесту по id
 * <br>2. Получение всех результатов по тестам
 * <br>3. Добавление результата по тесту
 * <br>4. Удаление результата по тесту
 * <br>5. Обновление результата по тесту
 * <br>6. Поиск результатов по тестам
 * <br>7. Получение результатов по тестам по id пользователя, прошедшего тесты
 * <br>8. Получение результатов по тестам по id пользователя, создавшего тесты
 * <br>9. Поиск результатов по тестам по id пользователя, прошедшего тесты
 * <br>10. Поиск результатов по теста по id пользователя, создавшего тесты
 * <br>11. Зафиксирование результата по тесту
 * <br>Является Rest контроллером.
 * <br>Доступ осуществляется по адресу url: http://адрес_сервера/restful/result_test_service
 * @author Овчинников В.А.
 */
@RestController
@RequestMapping(value = "/result_test_service")
public class ResultTestService extends Service<ResultTest> {

    public ResultTestService() {
        super(Factory.getInstance().getResultTestDAO());
    }

    /**
     * Get-метод получения результата по тесту по id. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/result_test_service/result_test?id=[Код результата по тесту]
     * @param id код результата по тесту
     * @return возвращает результат по тесту
     */
    @Override
    @GetMapping(value = "/result_test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultTest get(@RequestParam Integer id) {
        return super.get(id);
    }

    /**
     * Get-метод получения всех результатов по тестам. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/result_test_service/result_tests
     * @return возвращает коллекцию результатов по тестам
     */
    @Override
    @GetMapping(value = "/result_tests", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getAll() {
        return super.getAll();
    }

    /**
     * Post-метод добавления результата по тесту. Тип запроса: POST. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/result_test_service/add
     * @param request результат по тесту
     * @return возвращает результат по тесту
     */
    @Override
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResultTest add(@RequestBody ResultTest request) {
        return super.add(request);
    }

    /**
     * Delete-метод удаления результата по тесту. Тип запроса: DELETE. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/result_test_service/delete
     * @param request результат по тесту
     * @return возвращает результат по тесту
     */
    @Override
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResultTest remove(@RequestBody ResultTest request) {
        return super.remove(request);
    }

    /**
     * Put-метод обновления результата по тесту. Тип запроса: PUT. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/result_test_service/update
     * @param request результат по тесту
     * @return возвращает результат по тесту
     */
    @Override
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public ResultTest update(@RequestBody ResultTest request) {
        return super.update(request);
    }

    /**
     * Put-метод поиска результатов по тестам. Тип запроса: PUT. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/result_test_service/search
     * @param request результат по тесту
     * @return возвращает коллекцию результатов по тестам
     */
    @Override
    @PutMapping(value = "/search", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection search(@RequestBody ResultTest request) {
        return super.search(request);
    }

    /**
     * Get-метод получения результатов по тестам по пользователю, прошедшего тесты. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу: http://адрес_сервера/restful/result_test_service/result_tests_by_user?id=[Код пользователя]
     * @param id код пользователя, прошедшего тесты
     * @return возвращает коллекцию результатов по тестам
     */
    @GetMapping(value = "/result_tests_by_user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getByUser(@RequestParam Integer id) {
        try {
            return ((ResultTestDAOImpl) getDao()).getByUser(id);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    /**
     * Get-метод получения результатов по тестам по пользователю, создавшего тесты. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу: http://адрес_сервера/restful/result_test_service/result_tests_by_user_tests?id=[Код пользователя]
     * @param id код пользователя, создавшего тесты
     * @return возвращает коллекцию результатов по тестам
     */
    @GetMapping(value = "/result_tests_by_user_tests", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getByUserTests(@RequestParam Integer id) {
        try {
            return ((ResultTestDAOImpl) getDao()).getByUserTests(id);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    /**
     * Put-метод поиска результатов по тестам по пользователю, прошедшего тесты. Тип запроса: PUT. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/result_test_service/search_result_tests_by_user
     * @param request результат по тесту
     * @return возвращает коллекцию результатов по тестам
     */
    @PutMapping(value = "/search_result_tests_by_user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection searchByUser(@RequestBody ResultTest request) {
        try {
            return ((ResultTestDAOImpl) getDao()).searchByUser(request);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    /**
     * Put-метод поиска результатов по тестам по пользователю, создавшего тесты. Тип запроса: PUT. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/result_test_service/search_result_tests_by_user_tests
     * @param request результат по тесту
     * @return возвращает коллекцию результатов по тестам
     */
    @PutMapping(value = "/search_result_tests_by_user_tests", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection searchByUserTests(@RequestBody ResultTest request) {
        try {
            return ((ResultTestDAOImpl) getDao()).searchByUserTests(request);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    /**
     * Put-метод фиксирования результата по тесту. Метод оценивание ответы по тесты и выставляет оценку.
     * Тип запроса: PUT. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/result_test_service/fix_result
     * @param request результат по тесту
     * @return возвращает результат по тесту
     */
    @PutMapping(value = "/fix_result", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public ResultTest fixResult(@RequestBody ResultTest request) {
        try {
            Collection questions = Factory.getInstance().getTestDAO().getQuestionsByTest(request.getTest().getIdTest());
            float mark = 0;
            for (Object object: questions) {
                if (object instanceof Question) {
                    Question question = (Question) object;
                    short rightAnswerOfQuestion = (short) Factory.getInstance().getQuestionDAO().getRightAnswerByQuestion(question.getIdQuestion()).size();
                    float respCost = 1f / rightAnswerOfQuestion;
                    float issCost = 0;
                    Collection resultQuestions = Factory.getInstance().getResultQuestionDAO().getByQuestionAndResultTest(question.getIdQuestion(), request.getIdResult());
                    for (Object objectResultQ: resultQuestions) {
                        if (objectResultQ instanceof ResultQuestion) {
                            ResultQuestion resultQuestion = (ResultQuestion) objectResultQ;
                            if (resultQuestion.getAnswer().getCorrect())
                                issCost += respCost;
                            else if (issCost > 0)
                                issCost -= respCost;
                        }
                    }
                    mark += issCost;
                }
            }
            request.setMark(mark / questions.size() * 100);
            boolean isExecute = getDao().update(request);
            if (isExecute)
                return request;
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }
}
