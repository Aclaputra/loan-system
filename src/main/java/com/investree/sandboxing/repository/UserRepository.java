package com.investree.sandboxing.repository;

import com.investree.sandboxing.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {
    @Query("select u from User u WHERE u.id = :id")
    public User getUsersById(@Param("id") Long id);
    @Query("select u from User u WHERE u.username = :username")
    public User getByUsername(String username);
    @Query("select u from User u")
    Page<User> getAllUsers(Pageable pageable);
    @Query("select u from User u WHERE u.isActive = :isActive")
    Page<User> getByActive(Boolean isActive, Pageable pageable);

    // other methods for foreign key
}
