package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
//commented this out because it caused my form to say that post method was not supported
//@RequestMapping("hello")
public class HelloController {

    // handles request at path /hello/hello
    @GetMapping("hello-spring")
    public String hello(){
        return "Hello, Spring";
    }

    // handles request at path /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye(){
        return "Goodbye, Spring";
    }

    // create a handler that handles requests of the form /hello?name = LaunchCode. Calls a query parameter called name

//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
//    public String helloWithQueryParam(@RequestParam String name, @RequestParam String friend){
//        return "Hello, " + name + " and " + friend + "!";
//    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public static String createMessage(@RequestParam String name, @RequestParam String language) {
        if (language.equals("spanish")) {
            return "Hola, " + name + "!";
        } else if (language.equals("german")) {
            return "Hallo, " + name + "!";
        }else if (language.equals("french")) {
            return "Bonjour, " + name + "!";
        }else if (language.equals("latin")) {
            return "Salve, " + name + "!";
            } else {
            return "Hello, " + name + "!";
        }
    }

    //handles requests of the form /hello/LaunchCode

    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name + "!";
    }

    //lives at /hello/form
    @GetMapping("form")
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action = 'hello' method = 'post'>" +
                "<input type = 'text' name = 'name'>" +
                "<select name = 'language' id = 'languageSelect>" +
                "<option value = ''> Please choose a language </option>" +
                "<option value = 'english'> English </option>" +
                "<option value = 'french'> French </option>" +
                "<option value = 'spanish'> Spanish </option>" +
                "<option value = 'german'> German </option>" +
                "<option value = 'latin'> Latin </option>" +
                "</select>" +
                "<input type = 'submit' value = 'Greet me!'/>" +
                "</form>" +
                "</body>" +
                "</html>";
    }
}
