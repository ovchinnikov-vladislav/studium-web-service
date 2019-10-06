package ru.kamchatgtu.studium.rest.service;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import ru.kamchatgtu.studium.DAO.Factory;
import ru.kamchatgtu.studium.DAO.impl.DirectionDAOImpl;
import ru.kamchatgtu.studium.entity.Direction;
import ru.kamchatgtu.studium.rest.Service;
import java.util.Collection;

/**
 * Объект класса {@code DirectionService} отвечает за сервис доступа к направлениям подготовки:
 * <br>1. Получение направления подготовки по id
 * <br>2. Получение всех направлений подготовки
 * <br>3. Добавление направления подготовки
 * <br>4. Удаление направления подготовки
 * <br>5. Обновление направления подготовки
 * <br>6. Поиск направления подготовки
 * <br>7. Получение направлений подготовки по id факультета
 * <br>Является Rest контроллером.
 * <br>Доступ осуществляется по адресу url: http://адрес_сервера/restful/direction_service
 * @author Овчинников В.А.
 */
@RestController
@RequestMapping(value = "/direction_service")
public class DirectionService extends Service<Direction> {

    public DirectionService() {
        super(Factory.getInstance().getDirectionDAO());
    }

    /**
     * Get-метод получения направления подготовки по id. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/direction_service/direction?id=[Код направления подготовки]
     * @param id код направления подготовки
     * @return возвращает направление подготовки
     */
    @Override
    @GetMapping(value = "/direction", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Direction get(@RequestParam Integer id) {
        return super.get(id);
    }

    /**
     * Get-метод получения всех направлений подготовки. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/direction_service/directions
     * @return возвращает коллекцию направлений подготовки
     */
    @Override
    @GetMapping(value = "/directions", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getAll() {
        return super.getAll();
    }

    /**
     * Post-метод добавления направления подготовки. Тип запроса: POST. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/direction_service/add
     * @param request направление подготовки
     * @return возвращает направление подготовки
     */
    @Override
    @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Direction add(@RequestBody Direction request) {
        return super.add(request);
    }

    /**
     * Delete-метод удаления направления подготовки. Тип запроса: DELETE. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/direction_service/delete
     * @param request направление подготовки
     * @return возвращает направление подготовки
     */
    @Override
    @DeleteMapping(value = "/delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Direction remove(@RequestBody Direction request) {
        return super.remove(request);
    }

    /**
     * Put-метод обновления направления подготовки. Тип запроса: PUT. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/direction_service/update
     * @param request направление подготовки
     * @return возвращает направление подготовки
     */
    @Override
    @PutMapping(value = "/update", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public Direction update(@RequestBody Direction request) {
        return super.update(request);
    }

    /**
     * Put-метод поиска направления подготовки. Тип запроса: PUT. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу url: http://адрес_сервера/restful/direction_service/search
     * @param request направление подготовки
     * @return возвращает коллекцию направлений подготовки
     */
    @Override
    @PutMapping(value = "/search", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection search(@RequestBody Direction request) {
        return super.search(request);
    }

    /**
     * Get-метод получения направлений подготовки по факультету. Тип запроса: GET. Возврат значения в формате: JSON_UTF8.
     * Доступ осуществляется по адресу: http://адрес_сервера/restful/direction_service/directions_by_faculty?id=[Код факультета]
     * @param id код факультета
     * @return возвращает коллекцию направлений подготовки
     */
    @GetMapping(value = "/directions_by_faculty", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getByFaculty(@RequestParam Integer id) {
        try {
            return ((DirectionDAOImpl) getDao()).getByFaculty(id);
        } catch (Exception exc) {
            exc.printStackTrace();
        }
        return null;
    }
}
