package prv.hjh.boot.restcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 洪家豪
 * Created by HJH on 2017/10/24.
 */
@Controller
public class HelloThymeleafController {

    @RequestMapping(value = "/helloThymeleaf/{name}" , method = RequestMethod.GET)
    public String hello(@PathVariable("name") String name, Model model) {
        model.addAttribute("name", name);
        return "hello";
    }
}
