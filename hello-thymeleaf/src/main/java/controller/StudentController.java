package controller; 

import domain.Student; 
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {


    @GetMapping("/hello")
    public String getStudents(Model model) {
        System.out.println("getStudents() method called");
        // Create student objects
        List<Student> students = new ArrayList<>();
        students.add(new Student("Kate", "Cole"));
        students.add(new Student("Dan", "Brown"));
        students.add(new Student("Mike", "Mars"));

        // Add students list to the model
        model.addAttribute("students", students);

        // Return view name
        return "students";
    }

@GetMapping("/greet")
public String greet(@RequestParam(name = "name") String name, Model model) {
    model.addAttribute("greeting", "Hello, " + name + "!");
    return "greet";
}

}

