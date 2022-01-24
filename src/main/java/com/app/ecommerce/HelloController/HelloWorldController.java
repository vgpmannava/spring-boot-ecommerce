package com.app.ecommerce.HelloController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
// @RESTController
public class HelloWorldController {

    // @ResponseBody is necessary if you want the response written to the HTTP response body instead of
    // model and not placed in a view name
    // @ResponseBody can be placed on the method level or on the class level
    // You do not need @ResponseBody for @RESTController
    @RequestMapping("/")
    @ResponseBody
    public String helloWorld(){

        return "Hello From HelloWorldController";
    }
}
