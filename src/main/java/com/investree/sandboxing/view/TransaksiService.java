package com.investree.sandboxing.view;

import com.investree.sandboxing.model.Transaksi;

import java.util.Map;

public interface TransaksiService {
    public Map save(Transaksi obj);
    public Map updateStatus(Transaksi obj);

}
