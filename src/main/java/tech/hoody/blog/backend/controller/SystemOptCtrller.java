package tech.hoody.blog.backend.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class SystemOptCtrller {

    @RequestMapping(value = "echo",method = RequestMethod.GET)
    public RespWrapper<String> hello(@RequestParam String msg){
        return new RespWrapper<>("echo"+msg);
    }

}
