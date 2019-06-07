package com.example.janken;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

import static android.graphics.Color.rgb;

public class MainActivity extends AppCompatActivity {

    //変数宣言　これからコーディングに必要なものを使うという宣言
    ImageView cpu;
    ImageView player;
    TextView result, playerResult;

    Random r = new Random();

    int win =0, lose=0, draw=0;

    ProgressBar playerHp, cpuHp;

    int playerHpInt = 5;
    int computerHpInt = 5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //activity_main内のViewとの紐づけ

        cpu = (ImageView) findViewById(R.id.cpu);
        player = (ImageView) findViewById(R.id.player);
        result = (TextView) findViewById(R.id.result);
        playerResult = (TextView)findViewById(R.id.resultTextView);

        playerHp = (ProgressBar)findViewById(R.id.playerHp);
        cpuHp = (ProgressBar)findViewById(R.id.cpuHp);

        playerHpInt = 5;
        computerHpInt = 5;

        playerHp.setProgress(playerHpInt);
        cpuHp.setProgress(computerHpInt);



        player.setImageResource(R.drawable.goo);


        Bitmap bitmap_origin = BitmapFactory.decodeResource(getResources(),R.drawable.goo);

// 画像の横、縦サイズを取得
        int imageWidth = bitmap_origin.getWidth();
        int imageHeight = bitmap_origin.getHeight();

// Matrix インスタンス生成
        Matrix matrix = new Matrix();

// 画像を中心に180度回転
        matrix.setRotate(180, imageWidth/2, imageHeight/2);

// 180度回転したBitmap画像を生成
        Bitmap bitmap_rotate = Bitmap.createBitmap(bitmap_origin, 0, 0, imageWidth, imageHeight, matrix, true);

        cpu.setImageBitmap(bitmap_rotate);
    }

    //gooを押したときの処理
    public void goo(View v){

        //playerの手をグー
        player.setImageResource(R.drawable.goo);

        //背景を指定するツール
        //player.setBackgroundResource(R.drawable.shape);


        //0～２までのランダムの数を取り出す
        int random = r.nextInt(3);

        if(random == 0){
            Bitmap bitmap_origin = BitmapFactory.decodeResource(getResources(),R.drawable.goo);

// 画像の横、縦サイズを取得
            int imageWidth = bitmap_origin.getWidth();
            int imageHeight = bitmap_origin.getHeight();

// Matrix インスタンス生成
            Matrix matrix = new Matrix();

// 画像を中心に180度回転
            matrix.setRotate(180, imageWidth/2, imageHeight/2);

// 180度回転したBitmap画像を生成
            Bitmap bitmap_rotate = Bitmap.createBitmap(bitmap_origin, 0, 0, imageWidth, imageHeight, matrix, true);

            cpu.setImageBitmap(bitmap_rotate);



            result.setText("ひきわけ！");
            result.setTextColor(Color.rgb(255,238,85));

            draw = draw + 1;

        }else if(random==1){
            Bitmap bitmap_origin = BitmapFactory.decodeResource(getResources(),R.drawable.choki);

// 画像の横、縦サイズを取得
            int imageWidth = bitmap_origin.getWidth();
            int imageHeight = bitmap_origin.getHeight();

// Matrix インスタンス生成
            Matrix matrix = new Matrix();

// 画像を中心に180度回転
            matrix.setRotate(180, imageWidth/2, imageHeight/2);

// 180度回転したBitmap画像を生成
            Bitmap bitmap_rotate = Bitmap.createBitmap(bitmap_origin, 0, 0, imageWidth, imageHeight, matrix, true);

            cpu.setImageBitmap(bitmap_rotate);

            result.setText("かち！");
            result.setTextColor(Color.rgb(239,73,51));
            win = win + 1;

            computerHpInt = computerHpInt - 1;


        }else if(random==2){
            Bitmap bitmap_origin = BitmapFactory.decodeResource(getResources(),R.drawable.paa);

// 画像の横、縦サイズを取得
            int imageWidth = bitmap_origin.getWidth();
            int imageHeight = bitmap_origin.getHeight();

// Matrix インスタンス生成
            Matrix matrix = new Matrix();

// 画像を中心に180度回転
            matrix.setRotate(180, imageWidth/2, imageHeight/2);

// 180度回転したBitmap画像を生成
            Bitmap bitmap_rotate = Bitmap.createBitmap(bitmap_origin, 0, 0, imageWidth, imageHeight, matrix, true);

            cpu.setImageBitmap(bitmap_rotate);

            result.setText("まけ！");
            result.setTextColor(Color.rgb(41,171,226));

            lose = lose + 1;

            playerHpInt = playerHpInt - 1;

        }
        playerResult.setText(win + "勝"+lose+"負"+ draw + "分");

        playerHp.setProgress(playerHpInt);
        cpuHp.setProgress(computerHpInt);

        reset();

    }

    public void choki(View v){

        //playerの手をチョキ
        player.setImageResource(R.drawable.choki);
        //player.setBackgroundResource(R.drawable.shape2);

        //0～２までのランダムの数を取り出す
        int random = r.nextInt(3);

        if(random == 0){
            Bitmap bitmap_origin = BitmapFactory.decodeResource(getResources(),R.drawable.goo);

// 画像の横、縦サイズを取得
            int imageWidth = bitmap_origin.getWidth();
            int imageHeight = bitmap_origin.getHeight();

// Matrix インスタンス生成
            Matrix matrix = new Matrix();

// 画像を中心に180度回転
            matrix.setRotate(180, imageWidth/2, imageHeight/2);

// 180度回転したBitmap画像を生成
            Bitmap bitmap_rotate = Bitmap.createBitmap(bitmap_origin, 0, 0, imageWidth, imageHeight, matrix, true);

            cpu.setImageBitmap(bitmap_rotate);

            result.setText("まけ！");
            result.setTextColor(Color.rgb(41,171,226));

            lose = lose + 1;

            playerHpInt = playerHpInt - 1;

        }else if(random==1){
            Bitmap bitmap_origin = BitmapFactory.decodeResource(getResources(),R.drawable.choki);

// 画像の横、縦サイズを取得
            int imageWidth = bitmap_origin.getWidth();
            int imageHeight = bitmap_origin.getHeight();

// Matrix インスタンス生成
            Matrix matrix = new Matrix();

// 画像を中心に180度回転
            matrix.setRotate(180, imageWidth/2, imageHeight/2);

// 180度回転したBitmap画像を生成
            Bitmap bitmap_rotate = Bitmap.createBitmap(bitmap_origin, 0, 0, imageWidth, imageHeight, matrix, true);

            cpu.setImageBitmap(bitmap_rotate);

            result.setText("ひきわけ！");
            result.setTextColor(Color.rgb(255,238,85));

            draw = draw + 1;

        }else if(random==2){
            Bitmap bitmap_origin = BitmapFactory.decodeResource(getResources(),R.drawable.paa);

// 画像の横、縦サイズを取得
            int imageWidth = bitmap_origin.getWidth();
            int imageHeight = bitmap_origin.getHeight();

// Matrix インスタンス生成
            Matrix matrix = new Matrix();

// 画像を中心に180度回転
            matrix.setRotate(180, imageWidth/2, imageHeight/2);

// 180度回転したBitmap画像を生成
            Bitmap bitmap_rotate = Bitmap.createBitmap(bitmap_origin, 0, 0, imageWidth, imageHeight, matrix, true);

            cpu.setImageBitmap(bitmap_rotate);

            result.setText("かち！");
            result.setTextColor(Color.rgb(239,73,51));

            win = win + 1;

            computerHpInt = computerHpInt - 1;

        }

        playerResult.setText(win + "勝"+lose+"負"+ draw + "分");

        playerHp.setProgress(playerHpInt);
        cpuHp.setProgress(computerHpInt);

        reset();

    }

    public void paa(View v){

        //playerの手をグパー
        player.setImageResource(R.drawable.paa);
       // player.setBackgroundResource(R.drawable.shape3);

        //0～２までのランダムの数を取り出す
        int random = r.nextInt(3);

        if(random == 0){
            Bitmap bitmap_origin = BitmapFactory.decodeResource(getResources(),R.drawable.goo);

// 画像の横、縦サイズを取得
            int imageWidth = bitmap_origin.getWidth();
            int imageHeight = bitmap_origin.getHeight();

// Matrix インスタンス生成
            Matrix matrix = new Matrix();

// 画像を中心に180度回転
            matrix.setRotate(180, imageWidth/2, imageHeight/2);

// 180度回転したBitmap画像を生成
            Bitmap bitmap_rotate = Bitmap.createBitmap(bitmap_origin, 0, 0, imageWidth, imageHeight, matrix, true);

            cpu.setImageBitmap(bitmap_rotate);

            result.setText("かち！");
            result.setTextColor(Color.rgb(239,73,51));

            win = win + 1;

            computerHpInt = computerHpInt - 1;

        }else if(random==1){
            Bitmap bitmap_origin = BitmapFactory.decodeResource(getResources(),R.drawable.choki);

// 画像の横、縦サイズを取得
            int imageWidth = bitmap_origin.getWidth();
            int imageHeight = bitmap_origin.getHeight();

// Matrix インスタンス生成
            Matrix matrix = new Matrix();

// 画像を中心に180度回転
            matrix.setRotate(180, imageWidth/2, imageHeight/2);

// 180度回転したBitmap画像を生成
            Bitmap bitmap_rotate = Bitmap.createBitmap(bitmap_origin, 0, 0, imageWidth, imageHeight, matrix, true);

            cpu.setImageBitmap(bitmap_rotate);

            result.setText("まけ！");
            result.setTextColor(Color.rgb(41,171,226));

            lose = lose + 1;

            playerHpInt = playerHpInt - 1;

        }else if(random==2){
            Bitmap bitmap_origin = BitmapFactory.decodeResource(getResources(),R.drawable.paa);

// 画像の横、縦サイズを取得
            int imageWidth = bitmap_origin.getWidth();
            int imageHeight = bitmap_origin.getHeight();

// Matrix インスタンス生成
            Matrix matrix = new Matrix();

// 画像を中心に180度回転
            matrix.setRotate(180, imageWidth/2, imageHeight/2);

// 180度回転したBitmap画像を生成
            Bitmap bitmap_rotate = Bitmap.createBitmap(bitmap_origin, 0, 0, imageWidth, imageHeight, matrix, true);

            cpu.setImageBitmap(bitmap_rotate);
            result.setText("ひきわけ！");
            result.setTextColor(Color.rgb(255,238,85));

            draw = draw + 1;

        }

        playerResult.setText(win + "勝"+lose+"負"+ draw + "分");

        playerHp.setProgress(playerHpInt);
        cpuHp.setProgress(computerHpInt);

        reset();

    }

    public void reset(){
        if(win == 5){
            result.setText("5勝したよ");
            result.setTextColor(Color.rgb(255, 128, 0));
            win = 0;
            lose = 0;
            draw = 0;

            playerHpInt = 5;
            computerHpInt = 5;


        }else if (lose == 5){
            result.setText("5敗したよ");
            result.setTextColor(Color.rgb(100, 46, 254));
            win = 0;
            lose = 0;
            draw = 0;

            playerHpInt = 5;
            computerHpInt = 5;

        }
    }

}
