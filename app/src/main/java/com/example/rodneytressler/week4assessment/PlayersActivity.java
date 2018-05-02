package com.example.rodneytressler.week4assessment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import static com.example.rodneytressler.week4assessment.MainActivity.TAG;


public class PlayersActivity extends AppCompatActivity {

    @BindView(R.id.recycler_view)
    protected RecyclerView recyclerView;

    private List<Player> playerList = new ArrayList<>();

    private PlayerAdapter adapter = new PlayerAdapter(playerList);

    private LinearLayoutManager linearLayoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);
        ButterKnife.bind(this);
        playerList = getIntent().getParcelableArrayListExtra(TAG);
        populateRecyclerView();

    }

    private void populateRecyclerView() {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new PlayerAdapter(playerList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();


    }
}
