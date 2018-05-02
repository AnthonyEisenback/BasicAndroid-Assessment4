package com.example.rodneytressler.week4assessment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.input_team)
    protected EditText teamInput;

    @BindView(R.id.input_number)
    protected EditText numberInput;

    @BindView(R.id.input_name)
    protected EditText nameInput;
    private PlayerAdapter adapter;

    private PlayersActivity playersActivity;

    private List<Player> playerList = new ArrayList<>();

    public static final String TAG = "PLAYER_LIST_TAG";

    @OnClick(R.id.button_add_player)
    protected void onAddPlayerButtonClicked() {
        String teamInputName = teamInput.getText().toString();
        String nameInputName = nameInput.getText().toString();
        String numberInputNum = numberInput.getText().toString();

        //checks if all fields are filled out using the TextUtils utility
        if (TextUtils.isEmpty(teamInputName) || TextUtils.isEmpty(nameInputName) || TextUtils.isEmpty(numberInputNum)) {
            Toast.makeText(this, "All Fields Are Required!", Toast.LENGTH_SHORT).show();
        } else {
            //makes a new player and adds them
            Player player = new Player(nameInputName, numberInputNum, teamInputName);
            playerList.add(player);
            Bundle bundle = new Bundle();
            bundle.putParcelable(TAG, playerList.get(0));
            //tells user a player has been added
            Toast.makeText(this, "Player Added", Toast.LENGTH_SHORT).show();
        }

    }



    @OnClick(R.id.button_view_players)
    protected void onViewPlayersButtonClicked() {

        if (playerList.isEmpty()) { // tests for empty players list
            Toast.makeText(this, "Error : No players Found", Toast.LENGTH_SHORT).show();
        } else {
            //if a list is found then it runs this code below to start a new activity passing parcelables thought the Activities from the Array

            Intent intent = new Intent(getApplicationContext(), PlayersActivity.class);

            intent.putParcelableArrayListExtra(TAG, (ArrayList<? extends Parcelable>) playerList);
            setResult(RESULT_OK, intent);

            startActivity(intent);


        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }


    
}
