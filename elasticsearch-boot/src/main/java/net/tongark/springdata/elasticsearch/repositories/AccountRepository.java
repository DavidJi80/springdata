package net.tongark.springdata.elasticsearch.repositories;

import net.tongark.springdata.elasticsearch.entities.Account;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface AccountRepository extends ElasticsearchRepository<Account,Long> {
    Account queryAccountById(long id);
}
