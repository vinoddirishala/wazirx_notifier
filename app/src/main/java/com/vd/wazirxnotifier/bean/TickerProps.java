package com.vd.wazirxnotifier.bean;

/**
 * Created by Vinod Dirishala on 10-11-2021 17:43
 **/
public class TickerProps {

    public String base_unit;
    public String quote_unit;
    public String low;
    public String high;
    public String last;
    public String type;
    public long open;
    public String volume;
    public String sell;
    public String buy;
    public long at;
    public String pair;


    public TickerProps(String base_unit, String quote_unit, String low, String high, String last, String type, long open, String volume, String sell, String buy, long at, String pair) {
        this.base_unit = base_unit;
        this.quote_unit = quote_unit;
        this.low = low;
        this.high = high;
        this.last = last;
        this.type = type;
        this.open = open;
        this.volume = volume;
        this.sell = sell;
        this.buy = buy;
        this.at = at;
        this.pair = pair;
    }


    public String getBase_unit() {
        return base_unit;
    }

    public void setBase_unit(String base_unit) {
        this.base_unit = base_unit;
    }

    public String getQuote_unit() {
        return quote_unit;
    }

    public void setQuote_unit(String quote_unit) {
        this.quote_unit = quote_unit;
    }

    public String getLow() {
        return low;
    }

    public void setLow(String low) {
        this.low = low;
    }

    public String getHigh() {
        return high;
    }

    public void setHigh(String high) {
        this.high = high;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getOpen() {
        return open;
    }

    public void setOpen(long open) {
        this.open = open;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getSell() {
        return sell;
    }

    public void setSell(String sell) {
        this.sell = sell;
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public long getAt() {
        return at;
    }

    public void setAt(long at) {
        this.at = at;
    }

    public String getPair() {
        return pair;
    }

    public void setPair(String pair) {
        this.pair = pair;
    }
}
