package com.investree.sandboxing.repository.oauth;

import com.investree.sandboxing.model.oauth.Role;

public interface RoleRepository {
    Role findOneByName(String name);
}
