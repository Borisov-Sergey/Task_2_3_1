package task.contoller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import task.model.User;
import task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/user")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String allUser(ModelMap model) {
        model.addAttribute("users", userService.getAll());
        return "userTable";
    }

    @GetMapping(value = "/update")
    public String getUpdate(@RequestParam(value = "id", required = false) Long id, ModelMap model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "updateUser";
    }

    @PostMapping(value = "/update")
    public String updateUser(@ModelAttribute User user) {
        userService.update(user);
        return "redirect:/user/";
    }

    @GetMapping(value = "/new")
    public String newUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @PostMapping(value = "/new")
    public String saveUser(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/user/";
    }

    @GetMapping(value = "/delete")
    public String deleteUser(@RequestParam(value = "id", required = false) Long id) {
        userService.removeById(id);
        return "redirect:/user/";
    }

}
