package com.vd.wazirxnotifier.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.vd.wazirxnotifier.R;
import com.vd.wazirxnotifier.bean.Ticker;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Vinod Dirishala on 10-11-2021 17:38
 **/
public class Tickers extends RecyclerView.Adapter<Tickers.TickerViewHolder> {

    private Context mContext;
    ArrayList<Ticker> tickersArrayList;

    public Tickers(Context mContext, ArrayList<Ticker> tickersArrayList) {
        this.mContext = mContext;
        this.tickersArrayList = tickersArrayList;
    }

    @NonNull
    @Override
    public Tickers.TickerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new Tickers.TickerViewHolder(LayoutInflater.from(mContext).inflate(R.layout.item_ticker,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull Tickers.TickerViewHolder holder, int position) {
        Ticker ticker = tickersArrayList.get(position);
        holder.pairName.setText(ticker.getTickerProps().get(0).getPair()+" ");
        if ((position+1) % 2 == 0){
            holder.tickerItemRootLayout.setBackgroundColor(mContext.getResources().getColor(R.color.tickerItemColorCode));
        }else {
            holder.tickerItemRootLayout.setBackgroundColor(mContext.getResources().getColor(R.color.tickerItemColorCode2));
        }

    }

    @Override
    public int getItemCount() {
        return tickersArrayList.size();
    }

    public class TickerViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.pairName) TextView pairName;
        @BindView(R.id.tickerItemRootLayout) LinearLayout tickerItemRootLayout;

        public TickerViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
