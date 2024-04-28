package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {
//    @ResponseBody
//    @GetMapping("/hello")
//    public String hello(){
//        return "Hello dog";
//    }


//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
//    @ResponseBody
//    public String requestWithParams(@RequestParam String name){
//            return "Hello, " + name + "!";
//            }
    @ResponseBody
@GetMapping("goodbye")
    public String goodbye(@PathVariable String name){
        return "hello, " + name + "!";
    }
    @ResponseBody
    @RequestMapping(method = {RequestMethod.POST}, value = "hello")
public String helloPost(@RequestParam String name, @RequestParam String language){
        if (name == null){
            name = "World";
        }
      return  createMessage(name, language);
}

public static String createMessage( String name, String language){
        String greeting = "";

   switch(language){
       case "English":
           greeting = "Hello ";
           break;
       case "French":
           greeting = "Bonjour ";
           break;
       case  "italian":
           greeting = "Bonjourno ";
           break;
       case "spanish":
           greeting = "Hola ";
           break;
       case "german":
           greeting = "Guten Tag ";
           break;
   }

        return greeting + " " + name + "!";
}
    @ResponseBody
    @GetMapping("form")
    public String helloForm(){

        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +
                "<input type='text' name='name'/>" +
                " <label for=\"language-select\">Language:</label>\n" +
                "    <select name=\"language\" id=\"language-select\">\n" +
                "      <option value=\"english\" selected>English</option>\n" +
                "      <option value=\"spanish\">Spanish</option>\n" +
                "      <option value=\"french\">French</option>\n" +
                "      <option value=\"german\">German</option>\n" +
                "      <option value=\"italian\">Italian</option>\n" +
                "    </select>" +
                "<input type='submit' value='Greet me! '/>" +
                "</form>" +
                "</body>" +
                "</html>";

    }

}
