package xyz.beever.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController("MainController")
public class Controller {

    @RequestMapping("/")
    public String index() {
        return "<b>Hello World! <input type=\"button\"><input type=\"submit\" value=\"Send Request\" />";
    }

}
