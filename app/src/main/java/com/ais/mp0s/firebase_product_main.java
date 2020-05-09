package com.ais.mp0s;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class firebase_product_main {

    private String product_main_name;
    private Long product_main_mrp;
    private Long product_main_gst;
    private Long product_main_sold;

    public firebase_product_main() {
    }

    public firebase_product_main(String product_main_name, Long product_main_mrp, Long product_main_gst, Long product_main_sold) {
        this.product_main_name = product_main_name;
        this.product_main_mrp = product_main_mrp;
        this.product_main_gst = product_main_gst;
        this.product_main_sold = product_main_sold;
    }

    public String getProduct_main_name() {
        return product_main_name;
    }

    public Long getProduct_main_mrp() {
        return product_main_mrp;
    }

    public Long getProduct_main_gst() {
        return product_main_gst;
    }

    public Long getProduct_main_sold() {
        return product_main_sold;
    }
}
