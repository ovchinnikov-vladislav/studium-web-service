package ru.kamchatgtu.studium.rest.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.kamchatgtu.studium.DAO.Factory;
import ru.kamchatgtu.studium.DAO.impl.GroupDAOImpl;
import ru.kamchatgtu.studium.entity.Group;
import ru.kamchatgtu.studium.rest.Service;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Объект класса {@code GroupService} отвечает за сервис доступа к группам:
 * <br>1. Получение группы по id
 * <br>2. Получение всех групп
 * <br>3. Добавление группы
 * <br>4. Удаление группы
 * <br>5. Обновление группы
 * <br>6. Поиск групп
 * <br>7. Получение групп по id роли
 * <br>8. Получение групп по id направления подготовки
 * <br>Является Rest контроллером.
 * <br>Доступ осуществляется по адресу url: http://адрес_сервера/restful/group_service
 * @author Овчинников В.А.
 */
@RestController
@RequestMapping(value = "/group_service")
public class GroupService extends Service<Group> {

    public GroupService() {
        super(Factory.getInstance().getGroupDAO());
    }

    /**
     * Get-метод получения группы по id. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/group_service/group?id=[Код группы]
     * @param id код группы
     * @return возвращает группу
     */
    @Override
    @GetMapping(value = "/group", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Group get(@RequestParam Integer id) {
        return super.get(id);
    }

    /**
     * Get-метод получения всех групп. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/group_service/groups
     * @return возвращает коллекцию групп
     */
    @Override
    @GetMapping(value = "/groups", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getAll() {
        return super.getAll();
    }

    /**
     * Post-метод добавления группы. Тип запроса: POST. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/group_service/add
     * @param request группа
     * @return возвращает группу
     */
    @Override
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Group add(@RequestBody Group request) {
        return super.add(request);
    }

    /**
     * Delete-метод удаления группы. Тип запроса: DELETE. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/group_service/delete
     * @param request группа
     * @return возвращает группу
     */
    @Override
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Group remove(@RequestBody Group request) {
        return super.remove(request);
    }

    /**
     * Put-метод обновления группы. Тип запроса: PUT. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/group_service/update
     * @param request группа
     * @return возвращает группу
     */
    @Override
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Group update(@RequestBody Group request) {
        return super.update(request);
    }

    /**
     * Put-метод поиска групп. Тип запроса: PUT. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/group_service/search
     * @param request группа
     * @return возвращает коллекцию групп
     */
    @Override
    @PutMapping(value = "/search", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection search(@RequestBody Group request) {
        return super.search(request);
    }

    /**
     * Get-метод получения групп по роли. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу: http://адрес_сервера/restful/group_service/groups_by_role?id=[Код роли]
     * @param id код роли
     * @return возвращает коллекцию групп
     */
    @GetMapping(value = "/groups_by_role", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getByRole(@RequestParam Integer id) {
        try {
            return ((GroupDAOImpl) getDao()).getGroupsByRole(id);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    /**
     * Get-метод получения групп по направлению подготовки. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу: http://адрес_сервера/restful/group_service/groups_by_direction?id=[Код направления подготовки]
     * @param id код направления подготовки
     * @return возвращает коллекцию групп
     */
    @GetMapping(value = "/groups_by_direction", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getByDirection(@RequestParam Integer id) {
        try {
            return ((GroupDAOImpl) getDao()).getGroupsByDirection(id);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    /**
     * Get-метод получения студенческих групп. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу: http://адрес_сервера/restful/group_service/student_groups
     * @return возвращает коллекцию студентческих групп
     */
    @GetMapping(value = "/student_groups", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getStudentGroups() {
        try {
            return getByRole(3);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }

    /**
     * Get-метод получения кафедр. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу: http://адрес_сервера/restful/group_service/teacher_groups
     * @return возвращает коллекцию кафедр
     */
    @GetMapping(value = "/teacher_groups", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getTeacherGroups() {
        try {
            return getByRole(2);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }
}
