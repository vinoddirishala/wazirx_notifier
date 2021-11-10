package com.vd.wazirxnotifier.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Vinod Dirishala on 10-11-2021 17:39
 **/
public class Ticker implements Serializable {

   public String tickerName;
   public ArrayList<TickerProps> tickerProps;


    public Ticker(String tickerName, ArrayList<TickerProps> tickerProps) {
        this.tickerName = tickerName;
        this.tickerProps = tickerProps;
    }

    public String getTickerName() {
        return tickerName;
    }

    public void setTickerName(String tickerName) {
        this.tickerName = tickerName;
    }

    public ArrayList<TickerProps> getTickerProps() {
        return tickerProps;
    }

    public void setTickerProps(ArrayList<TickerProps> tickerProps) {
        this.tickerProps = tickerProps;
    }
}
