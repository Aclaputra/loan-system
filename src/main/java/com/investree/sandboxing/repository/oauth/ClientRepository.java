package com.investree.sandboxing.repository.oauth;

import com.investree.sandboxing.model.oauth.Client;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ClientRepository extends PagingAndSortingRepository<Client, Long> {
    Client findOneByClientId(String clientId);
}
