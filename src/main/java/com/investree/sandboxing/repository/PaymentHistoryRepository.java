package com.investree.sandboxing.repository;

import com.investree.sandboxing.model.PaymentHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentHistoryRepository extends PagingAndSortingRepository<PaymentHistory, Long> {
    @Query("select p from PaymentHistory p WHERE p.id = :id")
    public PaymentHistory getById(@Param("id") Long id);

    @Query("select p from PaymentHistory p WHERE p.pembayaranKe = :pembayaranKe")
    Page<PaymentHistory> getByPembayaranKe(Integer pembayaranKe, Pageable pageable);

    @Query("select p from PaymentHistory p")
    Page<PaymentHistory> getAllData(Pageable pageable);

    // others method for fk
}
