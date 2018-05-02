package com.example.rodneytressler.week4assessment;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by rodneytressler on 12/17/17.
 */

public class Player implements Parcelable {
    private String playerName;
    private String playerNumber;
    private String playerTeam;

    public Player(String playerName, String playerNumber, String playerTeam) {
        this.playerName = playerName;
        this.playerNumber = playerNumber;
        this.playerTeam = playerTeam;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerNumber() {
        return playerNumber;
    }

    public String getPlayerTeam() {
        return playerTeam;
    }

    protected Player(Parcel in) {
        playerName = in.readString();
        playerNumber = in.readString();
        playerTeam = in.readString();
    }

    public static final Creator<Player> CREATOR = new Creator<Player>() {
        @Override
        public Player createFromParcel(Parcel in) {
            return new Player(in);
        }

        @Override
        public Player[] newArray(int size) {
            return new Player[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(playerName);
        parcel.writeString(playerNumber);
        parcel.writeString(playerTeam);
    }
}
