package prv.hjh.boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import prv.hjh.boot.domain.User;
import prv.hjh.boot.service.UserService;

import java.util.List;

/**
 * @author 洪家豪
 * Created by acer on 2017/11/15.
 * 用户控制器
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/")
    public String index() {
        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<User> users = userService.findAll();
        System.out.println(users.toArray().toString());
        model.addAttribute("users", users);
        return "user/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "user/userAdd";
    }

    @RequestMapping("/add")
    public String add(User user) {
        userService.save(user);
        return "redirect:/list";
    }


    @RequestMapping("/toEdit")
    public String toEdit(Model model, Integer id) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "user/userEdit";
    }

    @RequestMapping("/edit")
    public String edit(User user) {
        userService.edit(user);
        return "redirect:/list";
    }


    @RequestMapping("/delete")
    public String delete(Integer id) {
        userService.delete(id);
        return "redirect:/list";
    }
}
