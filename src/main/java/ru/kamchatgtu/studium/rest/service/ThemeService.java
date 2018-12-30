package ru.kamchatgtu.studium.rest.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.kamchatgtu.studium.DAO.Factory;
import ru.kamchatgtu.studium.entity.Theme;
import ru.kamchatgtu.studium.rest.Service;

import java.util.Collection;


@RestController
@RequestMapping(value = "/theme_service")
public class ThemeService extends Service<Theme> {

    public ThemeService() {
        super(Factory.getInstance().getThemeDAO());
    }

    @Override
    @GetMapping(value = "/theme")
    public Theme get(@RequestParam Integer id) {
        return super.get(id);
    }

    @Override
    @GetMapping(value = "/themes")
    public Collection getAll() {
        return super.getAll();
    }

    @Override
    @PostMapping(value = "/add")
    @ResponseStatus(HttpStatus.CREATED)
    public Theme add(@RequestBody Theme request) {
        return super.add(request);
    }

    @Override
    @DeleteMapping(value = "/delete")
    @ResponseStatus(HttpStatus.OK)
    public Theme remove(@RequestBody Theme request) {
        return super.remove(request);
    }

    @Override
    @PutMapping(value = "/update")
    @ResponseStatus(HttpStatus.OK)
    public Theme update(@RequestBody Theme request) {
        return super.update(request);
    }
}
