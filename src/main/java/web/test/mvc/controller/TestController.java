package web.test.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by PC on 02.09.14.
 */
@Controller
public class TestController {

    @RequestMapping("/spring.html")
    public String test() {
        return "next";
    }

}
