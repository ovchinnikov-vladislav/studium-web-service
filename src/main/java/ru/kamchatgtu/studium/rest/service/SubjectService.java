package ru.kamchatgtu.studium.rest.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.kamchatgtu.studium.DAO.Factory;
import ru.kamchatgtu.studium.DAO.impl.SubjectDAOImpl;
import ru.kamchatgtu.studium.entity.Subject;
import ru.kamchatgtu.studium.rest.Service;
import java.util.Collection;

/**
 * Объект класса {@code subjectService} отвечает за сервис доступа к дисциплинам:
 * <br>1. Получение дисциплины по id
 * <br>2. Получение всех дисциплин
 * <br>3. Добавление дисциплины
 * <br>4. Удаление дисциплины
 * <br>5. Обновление дисциплины
 * <br>6. Поиск дисциплин
 * <br>7. Получение дисциплин по id пользователя
 * <br>8. Получение дисциплин по id направления подготовки
 * <br>Является Rest контроллером.
 * <br>Доступ осуществляется по адресу url: http://адрес_сервера/restful/subject_service
 * @author Овчинников В.А.
 */
@RestController
@RequestMapping(value = "/subject_service")
public class SubjectService extends Service<Subject> {

    public SubjectService() {
        super(Factory.getInstance().getSubjectDAO());
    }

    /**
     * Get-метод получения дисциплины по id. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/subject_service/subject?id=[Код дисциплины]
     * @param id код дисциплины
     * @return возвращает дисциплину
     */
    @Override
    @GetMapping(value = "/subject", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Subject get(@RequestParam Integer id) {
        return super.get(id);
    }

    /**
     * Get-метод получения всех дисциплин. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/subject_service/subjects
     * @return возвращает коллекцию дисциплин
     */
    @Override
    @GetMapping(value = "/subjects", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getAll() {
        return super.getAll();
    }

    /**
     * Post-метод добавления дисциплины. Тип запроса: POST. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/subject_service/add
     * @param request дисциплина
     * @return возвращает дисциплину
     */
    @Override
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Subject add(@RequestBody Subject request) {
        return super.add(request);
    }

    /**
     * Delete-метод удаления дисциплины. Тип запроса: DELETE. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/subject_service/delete
     * @param request дисциплина
     * @return возвращает дисциплину
     */
    @Override
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Subject remove(@RequestBody Subject request) {
        return super.remove(request);
    }

    /**
     * Put-метод обновления дисциплины. Тип запроса: PUT. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/subject_service/update
     * @param request дисциплина
     * @return возвращает дисциплину
     */
    @Override
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Subject update(@RequestBody Subject request) {
        return super.update(request);
    }

    /**
     * Put-метод поиска дисциплин. Тип запроса: PUT. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/subject_service/search
     * @param request дисциплина
     * @return возвращает коллекцию дисциплин
     */
    @Override
    @PutMapping(value = "/search", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection search(@RequestBody Subject request) {
        return super.search(request);
    }

    /**
     * Get-метод получения дисциплин c тестами по пользователю. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу: http://адрес_сервера/restful/subject_service/subjects_with_tests_by_user?id=[Код пользователя]
     * @param id код пользователя
     * @return возвращает коллекцию дисциплин с тестами
     */
    @GetMapping(value = "/subjects_with_tests_by_user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getSubjectsWithTestsByUser(@RequestParam Integer id) {
        try {
            return ((SubjectDAOImpl) getDao()).getSubjectsWithTestsByUser(id);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    /**
     * Get-метод получения дисциплин по пользователю. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу: http://адрес_сервера/restful/subject_service/subjects_by_user?id=[Код пользователя]
     * @param id код пользователя
     * @return возвращает коллекцию дисциплин
     */
    @GetMapping(value = "/subjects_by_user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getByUser(@RequestParam Integer id) {
        try {
            return ((SubjectDAOImpl) getDao()).getByUser(id);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    /**
     * Get-метод получения дисциплин по направлению подготовки. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу: http://адрес_сервера/restful/subject_service/subjects_by_direction?id=[Код направления подготовки]
     * @param id код направления подготовки
     * @return возвращает коллекцию дисциплин
     */
    @GetMapping(value = "/subjects_by_direction", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getByDirection(@RequestParam Integer id) {
        try {
            return ((SubjectDAOImpl) getDao()).getByDirection(id);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }
}
