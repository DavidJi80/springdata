package net.tongark.springdata.elasticsearch.controllers;

import net.tongark.springdata.elasticsearch.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ESRestController {

    private final ElasticsearchRestTemplate restTemplate;

    @Autowired
    public ESRestController(ElasticsearchRestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("add")
    public void add(){
        Account account=new Account();
        account.setId((long) 1);
        account.setName("David's Account");
        restTemplate.save(account);
    }

}
