package ru.kamchatgtu.studium.rest.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.kamchatgtu.studium.DAO.Factory;
import ru.kamchatgtu.studium.DAO.impl.UserDAOImpl;
import ru.kamchatgtu.studium.entity.User;
import ru.kamchatgtu.studium.rest.Service;
import java.util.Collection;

/**
 * Объект класса {@code UserService} отвечает за сервис доступа к пользователям:
 * <br>1. Получение пользователя по id
 * <br>2. Получение всех пользователей
 * <br>3. Добавление пользователя
 * <br>4. Удаление пользователя
 * <br>5. Обновление пользователя
 * <br>6. Поиск пользователей
 * <br>7. Получение пользователя по логину или e-mail
 * <br>8. Получение пользователя по логину
 * <br>9. Получение пользователя по e-mail
 * <br>Является Rest контроллером.
 * <br>Доступ осуществляется по адресу url: http://адрес_сервера/restful/user_service
 * @author Овчинников В.А.
 */
@RestController
@RequestMapping(value="/user_service")
public class UserService extends Service<User> {

    public UserService() {
        super(Factory.getInstance().getUserDAO());
    }

    /**
     * Get-метод получения пользователя по id. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/user_service/user?id=[Код пользователя]
     * @param id код пользователя
     * @return возвращает пользователя
     */
    @Override
    @GetMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User get(@RequestParam Integer id) {
        return super.get(id);
    }

    /**
     * Get-метод получения всех пользователей. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/user_service/users
     * @return возвращает коллекцию пользователей
     */
    @Override
    @GetMapping(value="/users", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getAll() {
        return super.getAll();
    }

    /**
     * Post-метод добавления пользователя. Тип запроса: POST. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/user_service/add
     * @param request пользователь
     * @return возвращает пользователя
     */
    @Override
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public User add(@RequestBody User request) {
        return super.add(request);
    }

    /**
     * Delete-метод удаления пользователя. Тип запроса: DELETE. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/user_service/delete
     * @param request пользователь
     * @return возвращает пользователя
     */
    @Override
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public User remove(@RequestBody User request) {
        return super.remove(request);
    }

    /**
     * Put-метод обновления пользователя. Тип запроса: PUT. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/user_service/update
     * @param request пользователь
     * @return возвращает пользователя
     */
    @Override
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public User update(@RequestBody User request) {
        return super.update(request);
    }

    /**
     * Put-метод поиска пользователей. Тип запроса: PUT. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/user_service/search
     * @param request пользователь
     * @return возвращает коллекцию пользователей
     */
    @Override
    @PutMapping(value = "/search", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection search(@RequestBody User request) {
        return super.search(request);
    }

    /**
     * Get-метод получения пользователя по логину или e-mail. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/user_service/sign_in?login=[Логин или e-mail пользователя]
     * @param login логин пользователя
     * @return возвращает пользователя
     */
    @GetMapping(value = "/sign_in", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public User signIn(@RequestParam String login) {
        try {
            return ((UserDAOImpl) getDao()).signIn(login);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    /**
     * Get-метод получения пользователя по e-mail. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/user_service/user_by_email?email=[E-mail пользователя]
     * @param email E-mail пользователя
     * @return возвращает пользователя
     */
    @GetMapping(value = "/user_by_email", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User getByEmail(@RequestParam String email) {
        try {
            return ((UserDAOImpl) getDao()).getByEmail(email);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    /**
     * Get-метод получения пользователя по логину. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/user_service/user_by_login?login=[Логин пользователя]
     * @param login логин пользователя
     * @return возвращает пользователя
     */
    @GetMapping(value = "/user_by_login", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public User getByLogin(@RequestParam String login) {
        try {
            return ((UserDAOImpl) getDao()).getByLogin(login);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    /**
     * Get-метод получения списка пользователей, являющихся студентами. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/user_service/students
     * @return возвращает список студентов
     */
    @GetMapping(value = "/students", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getStudents() {
        try {
            return ((UserDAOImpl) getDao()).getStudents();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    /**
     * Get-метод получения списка пользователей, являющихся преподавателями. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/user_service/teachers
     * @return возвращает список преподавателей
     */
    @GetMapping(value = "/teachers", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getTeachers() {
        try {
            return ((UserDAOImpl) getDao()).getTeachers();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    /**
     * Get-метод получения списка пользователей, являющихся администраторами. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/user_service/administrators
     * @return возвращает список администраторов
     */
    @GetMapping(value = "/administrators", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getAdministrators() {
        try {
            return ((UserDAOImpl) getDao()).getAdministrators();
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    /**
     * Get-метод получения списка пользователей по id группы. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/user_service/users_by_group?id=[id группы]
     * @return возвращает список пользователей по id группы
     */
    @GetMapping(value = "/users_by_group", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getByGroup(@RequestParam Integer id) {
        try {
            return ((UserDAOImpl) getDao()).getByGroup(id);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }
}