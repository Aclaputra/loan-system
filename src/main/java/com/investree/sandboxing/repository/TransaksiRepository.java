package com.investree.sandboxing.repository;

import com.investree.sandboxing.model.Transaksi;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TransaksiRepository extends PagingAndSortingRepository<Transaksi, Long> {
    @Query("select t from Transaksi t WHERE t.id = :id")
    public Transaksi getById(@Param("id") Long id);
    @Query("select t from Transaksi t")
    Page<Transaksi> getAllData(Pageable pageable);
    @Query("select t from Transaksi t WHERE t.status = :status")
    Page<Transaksi> getByStatus(String status, Pageable pageable);

    // others method for foreign key

}
