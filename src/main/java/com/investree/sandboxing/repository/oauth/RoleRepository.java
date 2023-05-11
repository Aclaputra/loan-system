package com.investree.sandboxing.repository.oauth;

import com.investree.sandboxing.model.oauth.Role;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface RoleRepository extends PagingAndSortingRepository<Role, Long> {
    Role findOneByName(String name);
    List<Role> findByNameIn(String[] names);
}
