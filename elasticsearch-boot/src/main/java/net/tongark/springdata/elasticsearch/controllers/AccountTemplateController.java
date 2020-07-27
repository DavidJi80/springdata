package net.tongark.springdata.elasticsearch.controllers;

import net.tongark.springdata.elasticsearch.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.query.GetQuery;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountTemplateController {

    @Autowired
    private ElasticsearchRestTemplate restTemplate;

    @GetMapping("add/{id}/{name}")
    public void add(@PathVariable long id,@PathVariable String name){
        Account account=new Account();
        account.setId(id);
        account.setName(name);
        restTemplate.save(account);
    }

}
