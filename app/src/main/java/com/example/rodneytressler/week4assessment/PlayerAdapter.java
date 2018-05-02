package com.example.rodneytressler.week4assessment;

import android.app.AlertDialog;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by rodneytressler on 12/17/17.
 */

public class PlayerAdapter extends RecyclerView.Adapter<PlayerAdapter.PlayerViewholder> {

    private List<Player> playerList;
    private Player player;

    public PlayerAdapter(List<Player> playerList) {
        this.playerList = playerList;
    }

    @Override
    public PlayerViewholder onCreateViewHolder(ViewGroup container, int viewType) {
        View itemView = LayoutInflater.from(container.getContext()).inflate(R.layout.item_player, container, false);
        return new PlayerViewholder(itemView);
    }

    @Override
    public void onBindViewHolder(PlayerViewholder holder, int position) {
        holder.bindPlayer(playerList.get(position));


    }



    @Override
    public int getItemCount() {
        return  playerList.size();
    }


    public class PlayerViewholder extends RecyclerView.ViewHolder {

        @BindView(R.id.text_player_team)
        protected TextView playerTeam;

        @BindView(R.id.text_player_number)
        protected TextView playerNumber;

        @BindView(R.id.text_player_name)
        protected TextView playerName;

        public PlayerViewholder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindPlayer(Player player) {
            playerName.setText(player.getPlayerName());
            playerNumber.setText(player.getPlayerNumber());
            playerTeam.setText(player.getPlayerTeam());

        }
    }
}
