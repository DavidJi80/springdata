package net.tongark.springdata.redisboot.repositories;

import net.tongark.springdata.redisboot.entities.Account;
import org.springframework.data.repository.CrudRepository;

public interface  AccountRepository extends CrudRepository<Account, String> {
}
