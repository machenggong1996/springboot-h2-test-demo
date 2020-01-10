package h2demo.controller;

import h2demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by machenggong on 2020/1/8.
 */
@RestController
public class PersonController {

    @Autowired
    PersonService personService;

    @GetMapping("person/update")
    public String update(@RequestParam int id, @RequestParam String name) {
        personService.update(id, name);
        return "true";
    }


}
