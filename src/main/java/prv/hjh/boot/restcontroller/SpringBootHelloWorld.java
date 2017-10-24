package prv.hjh.boot.restcontroller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 洪家豪
 *         Created by HJH on 2017/10/24.
 */

@RestController
@EnableAutoConfiguration
public class SpringBootHelloWorld {

    @RequestMapping("hello")
    public String hello(){
        return "hello.SpringBoot!!";
    }

    @RequestMapping("/word/{name}")
    public String word(@PathVariable String name){
        return "word--spring boot:" + name;
    }


}
