package com.example.jubbahack.xnulls;

import android.app.Activity;
import android.view.View;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class GameFieldActivity extends Activity implements View.OnClickListener {

    ImageButton[] XOButtons;
    Bitmap xBitmap, oBitmap;
    int[] intXOButtons;
    Button btnStartGame, btnMainMenu;
    boolean stop;
    int gameMode;
    int umove;
    int win;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.onStart();
        setContentView(R.layout.activity_game_field);
        xBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_x);
        oBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_o);

        XOButtons = new ImageButton[25];

        XOButtons[0] = (ImageButton) findViewById(R.id.XOButtons0);
        XOButtons[1] = (ImageButton) findViewById(R.id.XOButtons1);
        XOButtons[2] = (ImageButton) findViewById(R.id.XOButtons2);
        XOButtons[3] = (ImageButton) findViewById(R.id.XOButtons3);
        XOButtons[4] = (ImageButton) findViewById(R.id.XOButtons4);
        XOButtons[5] = (ImageButton) findViewById(R.id.XOButtons5);
        XOButtons[6] = (ImageButton) findViewById(R.id.XOButtons6);
        XOButtons[7] = (ImageButton) findViewById(R.id.XOButtons7);
        XOButtons[8] = (ImageButton) findViewById(R.id.XOButtons8);
        XOButtons[9] = (ImageButton) findViewById(R.id.XOButtons9);
        XOButtons[10] = (ImageButton) findViewById(R.id.XOButtons10);
        XOButtons[11] = (ImageButton) findViewById(R.id.XOButtons11);
        XOButtons[12] = (ImageButton) findViewById(R.id.XOButtons12);
        XOButtons[13] = (ImageButton) findViewById(R.id.XOButtons13);
        XOButtons[14] = (ImageButton) findViewById(R.id.XOButtons14);
        XOButtons[15] = (ImageButton) findViewById(R.id.XOButtons15);
        XOButtons[16] = (ImageButton) findViewById(R.id.XOButtons16);
        XOButtons[17] = (ImageButton) findViewById(R.id.XOButtons17);
        XOButtons[18] = (ImageButton) findViewById(R.id.XOButtons18);
        XOButtons[19] = (ImageButton) findViewById(R.id.XOButtons19);
        XOButtons[20] = (ImageButton) findViewById(R.id.XOButtons20);
        XOButtons[21] = (ImageButton) findViewById(R.id.XOButtons21);
        XOButtons[22] = (ImageButton) findViewById(R.id.XOButtons22);
        XOButtons[23] = (ImageButton) findViewById(R.id.XOButtons23);
        XOButtons[24] = (ImageButton) findViewById(R.id.XOButtons24);
        XOButtons[0].setOnClickListener(this);
        XOButtons[1].setOnClickListener(this);
        XOButtons[2].setOnClickListener(this);
        XOButtons[3].setOnClickListener(this);
        XOButtons[4].setOnClickListener(this);
        XOButtons[5].setOnClickListener(this);
        XOButtons[6].setOnClickListener(this);
        XOButtons[7].setOnClickListener(this);
        XOButtons[8].setOnClickListener(this);
        XOButtons[9].setOnClickListener(this);
        XOButtons[10].setOnClickListener(this);
        XOButtons[11].setOnClickListener(this);
        XOButtons[12].setOnClickListener(this);
        XOButtons[13].setOnClickListener(this);
        XOButtons[14].setOnClickListener(this);
        XOButtons[15].setOnClickListener(this);
        XOButtons[16].setOnClickListener(this);
        XOButtons[17].setOnClickListener(this);
        XOButtons[18].setOnClickListener(this);
        XOButtons[19].setOnClickListener(this);
        XOButtons[20].setOnClickListener(this);
        XOButtons[21].setOnClickListener(this);
        XOButtons[22].setOnClickListener(this);
        XOButtons[23].setOnClickListener(this);
        XOButtons[24].setOnClickListener(this);

        intXOButtons = new int[25];

        for (int i = 0; i < 25; i++) {
            intXOButtons[i] = 0;
        }

        btnMainMenu = (Button) findViewById(R.id.btnMainMenu);
        btnStartGame = (Button) findViewById(R.id.btnStartGame);
        btnMainMenu.setOnClickListener(this);
        btnStartGame.setOnClickListener(this);

        stop = false;

        gameMode = getIntent().getIntExtra("game_mode", 1);
        umove = 1;
    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntArray("game", intXOButtons);
        outState.putInt("game_mode", gameMode);
        outState.putInt("user", umove);
        outState.putInt("win", win);
        outState.putBoolean("stop", stop);
    }

    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        intXOButtons = savedInstanceState.getIntArray("game");
        gameMode = savedInstanceState.getInt("game_mode");
        umove = savedInstanceState.getInt("user");
        win = savedInstanceState.getInt("win");
        stop = savedInstanceState.getBoolean("stop");

        xBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_x);
        oBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.ic_o);
        for (int i = 0; i < 25; i++) {
            if (intXOButtons[i] == 1) {
                XOButtons[i].setImageBitmap(xBitmap);
            }
            if (intXOButtons[i] == 2) {
                XOButtons[i].setImageBitmap(oBitmap);
            }
        }
        if (win == 0) {
            status(umove == 1 ? getString(R.string.crossturn) : getString(R.string.nullturn));
        }
        else if (win == 1){
            //Крестики победили
            status(getString(R.string.crosswon));
        }
        //Нолики победили
        else if (win == 2){
            status(getString(R.string.nullwon));
        }
        //Ничья
        else if (win == 3){
            status(getString(R.string.standoff));
        }

    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch (v.getId()) {
            case R.id.XOButtons0:
                move(0);
                break;
            case R.id.XOButtons1:
                move(1);
                break;
            case R.id.XOButtons2:
                move(2);
                break;
            case R.id.XOButtons3:
                move(3);
                break;
            case R.id.XOButtons4:
                move(4);
                break;
            case R.id.XOButtons5:
                move(5);
                break;
            case R.id.XOButtons6:
                move(6);
                break;
            case R.id.XOButtons7:
                move(7);
                break;
            case R.id.XOButtons8:
                move(8);
                break;
            case R.id.XOButtons9:
                move(9);
                break;
            case R.id.XOButtons10:
                move(10);
                break;
            case R.id.XOButtons11:
                move(11);
                break;
            case R.id.XOButtons12:
                move(12);
                break;
            case R.id.XOButtons13:
                move(13);
                break;
            case R.id.XOButtons14:
                move(14);
                break;
            case R.id.XOButtons15:
                move(15);
                break;
            case R.id.XOButtons16:
                move(16);
                break;
            case R.id.XOButtons17:
                move(17);
                break;
            case R.id.XOButtons18:
                move(18);
                break;
            case R.id.XOButtons19:
                move(19);
                break;
            case R.id.XOButtons20:
                move(20);
                break;
            case R.id.XOButtons21:
                move(21);
                break;
            case R.id.XOButtons22:
                move(22);
                break;
            case R.id.XOButtons23:
                move(23);
                break;
            case R.id.XOButtons24:
                move(24);
                break;
            case R.id.btnMainMenu:
                intent = new Intent(this, SettingsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                break;
            case R.id.btnStartGame:
                intent = new Intent(this, GameFieldActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.putExtra("game_mode", gameMode);
                startActivity(intent);
                break;
        }
    }

    private void move(int n) {
        if (stop) return;

        if (intXOButtons[n] == 0) {
            if (gameMode == 1) {
                XOButtons[n].setImageBitmap(xBitmap);
                intXOButtons[n] = 1;
            } else if (gameMode == 2) {
                if (umove == 1) {
                    XOButtons[n].setImageBitmap(xBitmap);
                    status("Ход ноликов");
                    intXOButtons[n] = 1;
                    umove = 2;
                } else {
                    XOButtons[n].setImageBitmap(oBitmap);
                    status("Ход крестиков");
                    intXOButtons[n] = 2;
                    umove = 1;
                }
            }
        } else {
            return;
        }

        checkMove();
        if (stop) return;

        if (gameMode == 1) {
            int nf = 0;

            for (int i = 0; i < 25; i++) {
                if (intXOButtons[i] == 0) {
                    nf++;
                }
            }

            if (nf != 0) {
                int nm = (int) (Math.random() * nf + 1);

                for (int i = 0, j = 0; i < 25; i++) {
                    if (intXOButtons[i] == 0) {
                        j++;
                    }

                    if (j == nm) {
                        XOButtons[i].setImageBitmap(oBitmap);
                        intXOButtons[i] = 2;
                        break;
                    }
                }
            }

            checkMove();
        }
    }

    private void checkMove() {
        int nf = 0;

        for (int i = 0; i < 25; i++) {
            if (intXOButtons[i] == 0) {
                nf++;
            }
        }

        if (check(1)) {
            status("Победили крестики!");
            stop = true;
            win = 1;
        } else if (check(2)) {
            status("Победили нолики!");
            stop = true;
            win = 2;
        } else if (nf == 0) {
            status("Ничья");
            stop = true;
            win = 3;
        }
    }

    private boolean check(int n) {
        int t = 0, g = 0, v = 0, s = 0;

        for (int i = 0; i < 5; i++) {
            g = 0;
            for (int j = 0; j < 5; j++) {
                if (j != 5 && intXOButtons[t] == n) g++;
                t++;
            }
            if (g == 5) {
                return true;
            }
        }

        t = 0;
        for (int i = 0; i <= 5; i++) {
            v = 0;
            for (int j = 0; j < 5; j++) {
                if (j != 5 && intXOButtons[t] == n) v++;
                t += 3;
            }
            t = i;
            if (v == 5) {
                return true;
            }
        }

        t = 0;
        for (int j = 0; j < 5; j++) {
            if (j != 3 && intXOButtons[t] == n) s++;
            t += 4;
        }
        if (s == 5) {
            return true;
        }

        s = 0;
        t = 0;
        for (int j = 0; j < 5; j++) {
            t += 5;
            if (j != 5 && intXOButtons[t] == n) s++;
        }
        if (s == 5) {
            return true;
        }

        return false;
    }

    private void status(String str) {
        TextView GameStatus = (TextView) findViewById(R.id.GAME_STATUS);
        GameStatus.setText(str);
    }
}