package io.pivotal.demo;

import io.pivotal.demo.domain.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by chenw13 on 28/10/2016.
 */
@RestController
public class DemoController {

    @Autowired
    private CityRepository cityRepository;

    public DemoController() {

    }

    @RequestMapping( path = "/hello" )
    public String Hello(@RequestParam("name") String who) {
        return "Hello" + who;
    }

    @RequestMapping( path = "/cities/add/{name}", method = RequestMethod.GET)
    public String AddCity(@PathVariable String name) {
        City city = new City(name);
        cityRepository.save(city);
        return "City " + name + " added";
    }


}
