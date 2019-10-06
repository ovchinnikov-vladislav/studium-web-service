package ru.kamchatgtu.studium.rest.service;

import java.util.Collection;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.kamchatgtu.studium.DAO.Factory;
import ru.kamchatgtu.studium.DAO.impl.TestDAOImpl;
import ru.kamchatgtu.studium.entity.Test;
import ru.kamchatgtu.studium.rest.Service;

/**
 * Объект класса {@code TestService} отвечает за сервис доступа к тестам:
 * <br>1. Получение тестов по id
 * <br>2. Получение всех тестов
 * <br>3. Добавление теста
 * <br>4. Удаление теста
 * <br>5. Обновление теста
 * <br>6. Поиск тестов
 * <br>7. Получение тестов по id дисциплины
 * <br>8. Получение тестов по id пользователя
 * <br>Является Rest контроллером.
 * <br>Доступ осуществляется по адресу url: http://адрес_сервера/restful/test_service
 * @author Овчинников В.А.
 */
@RestController
@RequestMapping(value = "/test_service")
public class TestService extends Service<Test> {

    public TestService() {
        super(Factory.getInstance().getTestDAO());
    }

    /**
     * Get-метод получения теста по id. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/test_service/test?id=[Код теста]
     * @param id код теста
     * @return возвращает тест
     */
    @Override
    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Test get(@RequestParam Integer id) {
        return super.get(id);
    }

    /**
     * Get-метод получения всех тестов. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/test_service/tests
     * @return возвращает коллекцию тестов
     */
    @Override
    @GetMapping(value = "/tests", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getAll() {
        return super.getAll();
    }

    /**
     * Post-метод добавления теста. Тип запроса: POST. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/test_service/add
     * @param request тест
     * @return возвращает тест
     */
    @Override
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Test add(@RequestBody Test request) {
        return super.add(request);
    }

    /**
     * Delete-метод удаления теста. Тип запроса: DELETE. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/test_service/delete
     * @param request тест
     * @return возвращает тест
     */
    @Override
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Test remove(@RequestBody Test request) {
        return super.remove(request);
    }

    /**
     * Put-метод обновления теста. Тип запроса: PUT. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/test_service/update
     * @param request тест
     * @return возвращает тест
     */
    @Override
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Test update(@RequestBody Test request) {
        return super.update(request);
    }

    /**
     * Put-метод поиска тестов. Тип запроса: PUT. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/test_service/search
     * @param request тест
     * @return возвращает коллекцию тестов
     */
    @Override
    @PutMapping(value = "/search", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection search(@RequestBody Test request) {
        return super.search(request);
    }

    /**
     * Get-метод получения тестов по дисциплине. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу: http://адрес_сервера/restful/test_service/tests_by_subject?id=[Код дисциплины]
     * @param id код дисциплины
     * @return возвращает коллекцию тестов
     */
    @GetMapping(value = "/tests_by_subject", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getBySubject(@RequestParam Integer id) {
        try {
            return ((TestDAOImpl) getDao()).getBySubject(id);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    /**
     * Get-метод получения тестов по пользователю. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу: http://адрес_сервера/restful/test_service/tests_by_user?id=[Код пользователя]
     * @param id код пользователя
     * @return возвращает коллекцию тестов
     */
    @GetMapping(value = "/tests_by_user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getByUser(@RequestParam Integer id) {
        try {
            return ((TestDAOImpl) getDao()).getByUser(id);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }
}
