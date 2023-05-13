package com.investree.sandboxing.listener;

import com.investree.sandboxing.model.Transaksi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TransaksiListener {
    @JmsListener(
            destination = "TransaksiListener",
            containerFactory = "transaksiJmsContFactory")
    public void getTransaksiListener1(Transaksi trn) {
        log.info("Transaksi listener1: " + trn);
    }

    @JmsListener(
            destination = "TransaksiListener",
            containerFactory = "transaksiJmsContFactory")
    public void getTransaksiListener2(Transaksi trn) {
        log.info("Transkasi listener2: " + trn);
    }
}
