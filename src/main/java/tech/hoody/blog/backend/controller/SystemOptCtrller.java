package tech.hoody.blog.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.hoody.blog.backend.domain.Option;
import tech.hoody.blog.backend.service.OptionsService;

@RestController
@RequestMapping(value = "/option")
public class SystemOptCtrller {

    private OptionsService optionsService;

    @Autowired
    public SystemOptCtrller(OptionsService optionsService) {
        this.optionsService = optionsService;
    }

    @RequestMapping(value = "echo",method = RequestMethod.GET)
    public RespWrapper<String> hello(@RequestParam String msg){
        return new RespWrapper<>("echo"+msg);
    }

    @RequestMapping(value = "save",method = RequestMethod.POST)
    public RespWrapper<Option> saveOption(@RequestBody Option option){
        optionsService.saveOption(option);
        return new RespWrapper<>(option);
    }


}
