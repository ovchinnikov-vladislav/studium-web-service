package ru.kamchatgtu.studium.rest.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.kamchatgtu.studium.DAO.Factory;
import ru.kamchatgtu.studium.entity.Role;
import ru.kamchatgtu.studium.rest.Service;
import java.util.Collection;

/**
 * Объект класса {@code RoleService} отвечает за сервис доступа к ролям:
 * <br>1. Получение роли по id
 * <br>2. Получение всех ролей
 * <br>3. Добавление роли
 * <br>4. Удаление роли
 * <br>5. Обновление роли
 * <br>6. Поиск роли
 * <br>Является Rest контроллером.
 * <br>Доступ осуществляется по адресу url: http://адрес_сервера/restful/role_service
 * @author Овчинников В.А.
 */
@RestController
@RequestMapping(value = "/role_service")
public class RoleService extends Service<Role> {

    public RoleService() {
        super(Factory.getInstance().getRoleDAO());
    }

    /**
     * Get-метод получения роли по id. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/role_service/role?id=[Код роли]
     * @param id код роли
     * @return возвращает роль
     */
    @Override
    @GetMapping(value = "/role", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Role get(@RequestParam Integer id) {
        return super.get(id);
    }

    /**
     * Get-метод получения всех ролей. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/role_service/roles
     * @return возвращает коллекцию групп
     */
    @Override
    @GetMapping(value = "/roles", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getAll() {
        return super.getAll();
    }

    /**
     * Post-метод добавления роли. Тип запроса: POST. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/role_service/add
     * @param request роль
     * @return возвращает роль
     */
    @Override
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Role add(@RequestBody Role request) {
        return super.add(request);
    }

    /**
     * Delete-метод удаления роли. Тип запроса: DELETE. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/role_service/delete
     * @param request роль
     * @return возвращает роль
     */
    @Override
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Role remove(@RequestBody Role request) {
        return super.remove(request);
    }

    /**
     * Put-метод обновления роль. Тип запроса: PUT. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/role_service/update
     * @param request роль
     * @return возвращает роль
     */
    @Override
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Role update(@RequestBody Role request) {
        return super.update(request);
    }

    /**
     * Put-метод поиска ролей. Тип запроса: PUT. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/role_service/search
     * @param request роль
     * @return возвращает коллекцию ролей
     */
    @Override
    @PutMapping(value = "/search", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection search(@RequestBody Role request) {
        return super.search(request);
    }
}
