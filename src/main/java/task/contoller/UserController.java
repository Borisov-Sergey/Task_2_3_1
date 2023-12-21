package task.contoller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import task.model.User;
import task.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String all(ModelMap model) {
        model.addAttribute("users", userService.getAll());
        return "all";
    }

    @GetMapping(value = "/user")
    public String user(@RequestParam(value = "id", required = false) Long id, ModelMap model) {
        model.addAttribute("user", userService.getById(id));
        return "user";
    }

    @GetMapping(value = "/new")
    public String newUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping()
    public String save(@ModelAttribute("user") User user) {
        userService.save(user);
        return "redirect:/users/";
    }

}
