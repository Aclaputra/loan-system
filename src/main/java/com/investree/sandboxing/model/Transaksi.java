package com.investree.sandboxing.model;

import javax.persistence.*;

import com.investree.sandboxing.model.oauth.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "transaksi")
public class Transaksi {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "tenor", nullable = false, length = 3)
    private Integer tenor;

    @Column(name = "total_pinjaman")
    private Double totalPinjaman;

    @Column(name = "bunga_persen")
    private Double bungaPersen;

    @Column(name = "status", nullable = false, length = 50)
    private String status;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "id_peminjam")
    private User peminjam;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "id_meminjam")
    private User meminjam;

}
