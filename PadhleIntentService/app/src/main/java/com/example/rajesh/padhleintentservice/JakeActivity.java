package com.example.rajesh.padhleintentservice;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

public class JakeActivity extends AppCompatActivity implements DownloadResultReceiver.Receiver {

    RecyclerView recycler;
    String TAG="JakeActivity";

    DownloadResultReceiver mReceiver;
    ArrayList<JakeWhartonDataEntity> _dataEntities=new ArrayList<>();

    JakeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jake);
        initialize();

         /* Starting Download Service */
        mReceiver = new DownloadResultReceiver(new Handler());
        mReceiver.setReceiver(this);
        Intent intent = new Intent(Intent.ACTION_SYNC, null, this, DownloadService.class);

        /* Send optional extras to Download IntentService */
        intent.putExtra("url", Constants.BASE_URL+"?page=1&per_page=15");
        intent.putExtra("receiver", mReceiver);
        intent.putExtra("requestId", 101);

        startService(intent);

        //setup recycler
        adapter=new JakeAdapter(JakeActivity.this,_dataEntities);
        recycler.setAdapter(adapter);
        recycler.setHasFixedSize(true);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recycler.setLayoutManager(layoutManager);
    }

    public void initialize()
    {
        recycler=findViewById(R.id.recycler);
    }

    @Override
    public Object getSystemService(String name) {
        return super.getSystemService(name);
    }

    @Override
    public void onReceiveResult(int resultCode, Bundle resultData)
    {
        switch (resultCode)
        {
            case DownloadService.STATUS_RUNNING:
                Log.e(TAG,"dialog moving");
                break;

            case DownloadService.STATUS_FINISHED:

                _dataEntities=new ArrayList<>();
                _dataEntities=resultData.getParcelableArrayList("result");

                adapter=new JakeAdapter(JakeActivity.this,_dataEntities);
                recycler.setAdapter(adapter);
                recycler.setHasFixedSize(true);
                final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
                layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
                recycler.setLayoutManager(layoutManager);

                Log.e(TAG,_dataEntities.size()+"");

                //check number of entries

                break;

            case DownloadService.STATUS_ERROR:

                break;
        }
    }
}
