package fi.haagahelia.course.web;

import fi.haagahelia.course.domain.Friend;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FriendListController {
    private List<Friend> friends = new ArrayList<>();

    //constructor
    public FriendListController(){
        friends.add(new Friend("Kate", "Cole"));
        friends.add(new Friend("Dan", "Brown"));
        friends.add(new Friend("Mike", "Mars"));
    }

    @GetMapping("/index")
    public String getFriends(Model model) {
        model.addAttribute("friends", friends);
        return "friends";
    }
    @GetMapping("/add")
    public String addFriendForm() {
        return "addFriend";
    }
    @PostMapping("/add")
    public String addFriendToList(@RequestParam("firstName")String firstName, @RequestParam("lastName") String lastName) {
        friends.add(new Friend(firstName, lastName));
        
        return "redirect:/index";
    }
    @GetMapping("/addFriend")
    public String listAndFormView(Model model) {
        model.addAttribute("friends", friends);
        return "friendAndAddFriend";
    }
    @PostMapping("/addFriend")
    public String listAndFormViewAddFriend(@RequestParam("firstName")String firstName, 
                                            @RequestParam("lastName") String lastName,
                                            Model model) {
        friends.add(new Friend(firstName, lastName));    
        model.addAttribute("friends", friends);
        return "friendAndAddFriend";
    }
    
}

