package ru.kamchatgtu.studium.rest.service;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.kamchatgtu.studium.DAO.DAO;
import ru.kamchatgtu.studium.DAO.Factory;
import ru.kamchatgtu.studium.entity.Log;
import ru.kamchatgtu.studium.rest.Service;

import java.util.Collection;

@RestController
@RequestMapping(value = "/log_service")
public class LogService extends Service<Log> {

    public LogService() {
        super(Factory.getInstance().getLogDAO());
    }

    @Override
    @GetMapping(value = "/log", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Log get(@RequestParam Integer id) {
        return super.get(id);
    }

    @Override
    @GetMapping(value = "/logs", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection getAll() {
        return super.getAll();
    }


    @Override
    @PutMapping(value = "/search", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Collection search(@RequestBody Log request) {
        return super.search(request);
    }

    @Override
    public DAO<Log> getDao() {
        return super.getDao();
    }
}
