package prv.hjh.boot.controller;

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
public class SpringBootHelloWorldController {

    @RequestMapping("hello")
    public String hello(){
        return "hello.SpringBoot!!";
    }

    @RequestMapping("helloWorld")
    public String helloWorld(){
        return "SpringBoot HelloWorld!!!";
    }
    
    /**
      * @author 洪家豪
      * @Date 2017/10/25 14:46
      */
    @RequestMapping("/word/{name}")
    public String word(@PathVariable String name){
        return "word--spring boot:" + name;
    }

    @RequestMapping("{id}")
    public String getId(@PathVariable String id){return id;}


}
