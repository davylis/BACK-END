package fi.haagahelia.course.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import fi.haagahelia.course.domain.Car;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class CarController {
    @RequestMapping("/carlist")
    public String listCars(Model model) {
        // ALWAYS WHEN YOU PROGRAM, DO SMALL PARTS AT A TIME AND
        // TEST THEM
        System.out.println("WE ARE IN METHOD LISTCARS!");

        // CREATE SOME CARS AND SAVE THEM TO A LIST
        Car tesla = new Car("Tesla", 2019);
        Car toyota = new Car("Toyota", 2006);
        // CREATE A LIST, WHICH IS ARRAYLIST HAVING THESE CARS
        List<Car> cars = new ArrayList<Car>();
        cars.add(tesla);
        cars.add(toyota);

        // LIKE IN SLIDES SAVE CARLIST TO THE MODEL
        model.addAttribute("carlist", cars);
        return "cars";
    }

}
