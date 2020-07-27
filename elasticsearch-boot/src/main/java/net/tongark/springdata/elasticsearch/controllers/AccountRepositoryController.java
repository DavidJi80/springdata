package net.tongark.springdata.elasticsearch.controllers;

import net.tongark.springdata.elasticsearch.entities.Account;
import net.tongark.springdata.elasticsearch.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/account/repo/")
public class AccountRepositoryController {
    @Autowired
    private AccountRepository accountRepository;

    @GetMapping("add/{id}/{name}")
    public void add(@PathVariable Long id, @PathVariable String name){
        Account account=new Account();
        account.setId(id);
        account.setName(name);
        accountRepository.save(account);
    }

    @GetMapping("/")
    public List findAll(){
        Iterator<Account> iterator=accountRepository.findAll().iterator();
        List<Account> accounts = new ArrayList<Account>();
        while (iterator.hasNext())
            accounts.add(iterator.next());
        return accounts;
    }

    @GetMapping("find/{id}")
    public Account findById(@PathVariable long id){
        return accountRepository.queryAccountById(id);
    }

    @RequestMapping("delete/{id}")
    public String delete(@PathVariable long id) {
        Account account = accountRepository.queryAccountById(id);
        accountRepository.delete(account);
        return "success";
    }
}
