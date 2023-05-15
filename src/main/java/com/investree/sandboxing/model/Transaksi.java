package com.investree.sandboxing.model;

import javax.persistence.*;

import com.investree.sandboxing.model.oauth.User;
import lombok.Data;

@Entity
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getTenor() {
        return tenor;
    }

    public void setTenor(Integer tenor) {
        this.tenor = tenor;
    }

    public Double getTotalPinjaman() {
        return totalPinjaman;
    }

    public void setTotalPinjaman(Double totalPinjaman) {
        this.totalPinjaman = totalPinjaman;
    }

    public Double getBungaPersen() {
        return bungaPersen;
    }

    public void setBungaPersen(Double bungaPersen) {
        this.bungaPersen = bungaPersen;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public User getPeminjam() {
        return peminjam;
    }

    public void setPeminjam(User peminjam) {
        this.peminjam = peminjam;
    }

    public User getMeminjam() {
        return meminjam;
    }

    public void setMeminjam(User meminjam) {
        this.meminjam = meminjam;
    }
}
