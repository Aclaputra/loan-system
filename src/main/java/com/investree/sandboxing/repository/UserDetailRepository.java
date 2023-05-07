package com.investree.sandboxing.repository;

import com.investree.sandboxing.model.UserDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailRepository extends PagingAndSortingRepository<UserDetail, Long> {
    @Query("select u from UserDetail u where u.id = :id")
    public UserDetail getByUserId(@Param("id") Long id);
}
