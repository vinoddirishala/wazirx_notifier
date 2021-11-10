package com.vd.wazirxnotifier.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.vd.wazirxnotifier.R;
import com.vd.wazirxnotifier.bean.Ticker;
import com.vd.wazirxnotifier.bean.TickerProps;
import com.vd.wazirxnotifier.ui.adapter.Tickers;
import com.vd.wazirxnotifier.utils.Constants;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

import butterknife.BindView;
import butterknife.ButterKnife;

public class Dashboard extends AppCompatActivity {

    @BindView(R.id.tickers) RecyclerView tickers;
    @BindView(R.id.noTickersLayout) RelativeLayout noTickersLayout;

    LinearLayoutManager linearLayoutManager;
    ArrayList<Ticker> tickerItems = new ArrayList<Ticker>();
    Tickers tickerAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(Dashboard.this);
        linearLayoutManager = new LinearLayoutManager(Dashboard.this);
        tickerAdapter = new Tickers(Dashboard.this,tickerItems);
        tickers.setLayoutManager(linearLayoutManager);
        tickers.setHasFixedSize(true);
        tickers.setAdapter(tickerAdapter);
        fetchTickers();
    }


    private void fetchTickers() {
        tickerItems.clear();
        AndroidNetworking.get(Constants.TICKERS)
                .setPriority(Priority.IMMEDIATE)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            Log.d("tickerWazirX", response.length() + " is the tickers length");
                            if (response.length() != 0) {

                                Iterator<String> tickerNameIterator = response.keys();
                                while (tickerNameIterator.hasNext()) {
                                    String key = tickerNameIterator.next();
                                    JSONObject propsObject = null;

                                    propsObject = response.getJSONObject(key);

                                    ArrayList<TickerProps> tickerProps = new ArrayList<>();
                                    tickerProps.add(new TickerProps(
                                            propsObject.getString("base_unit"),
                                            propsObject.getString("quote_unit"),
                                            propsObject.getString("low"),
                                            propsObject.getString("high"),
                                            propsObject.getString("last"),
                                            propsObject.getString("type"),
                                            propsObject.getLong("open"),
                                            propsObject.getString("volume"),
                                            propsObject.getString("sell"),
                                            propsObject.getString("buy"),
                                            propsObject.getLong("at"),
                                            propsObject.getString("name")
                                    ));
                                    tickerItems.add(new Ticker(key, tickerProps));
                                }
                                tickerAdapter.notifyDataSetChanged();
                            } else {
                                // No tickers given from api
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(ANError error) {
                        Log.d("tickerWazirX", "error" + error.getErrorDetail() + "/////" + error.getErrorBody());

                    }
                });
    }

}