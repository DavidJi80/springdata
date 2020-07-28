package net.tongark.springdata.redisboot.controllers;

import net.tongark.springdata.redisboot.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountTemplateController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("add/{id}/{name}")
    public void add(@PathVariable String id,@PathVariable String name){
        Account account=new Account();
        account.setId(id);
        account.setName(name);
        redisTemplate.opsForValue().set("account"+account.getId(),account.toString());
    }

}
