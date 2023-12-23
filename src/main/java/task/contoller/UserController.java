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

    @GetMapping(value = "/update")
    public String update(@RequestParam(value = "id", required = false) Long id, ModelMap model) {
        model.addAttribute("userUpdate", userService.getById(id));
        return "userUpdate";
    }

    @PostMapping(value = "/update")
    public String updating(@ModelAttribute User user) {
        userService.update(user);
        return "redirect:/users/";
    }

    @GetMapping(value = "/new")
    public String newUser(ModelMap model) {
        model.addAttribute("user", new User());
        return "new";
    }

    @PostMapping(value = "/new")
    public String save(@ModelAttribute User user) {
        userService.save(user);
        return "redirect:/users/";
    }

    @GetMapping(value = "/delete")
    public String delete(@RequestParam(value = "id", required = false) Long id) {
        userService.removeById(id);
        return "redirect:/users/";
    }

}
