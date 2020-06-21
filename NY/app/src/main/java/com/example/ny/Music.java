package com.example.ny;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Music extends AppCompatActivity {
    TextView txtloinhan;
    ListView lvBaihat;
    ConstraintLayout mhmusic;
    MediaPlayer song;
    ArrayList<String> mangTenBH, mangLoiNhan;
    ArrayList<Integer> mangMP3;
    public void AnhXa()
    {
        txtloinhan =(TextView)findViewById(R.id.txtloinhan);
        lvBaihat=(ListView)findViewById(R.id.lvBaihat);
        mhmusic=(ConstraintLayout)findViewById(R.id.mhMusic);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);
        //Anhxa
        AnhXa();
        //Hinhnen
        mhmusic.setBackgroundResource(R.drawable.bgpng2);
        //Playnhac
        song =MediaPlayer.create(getApplicationContext(),R.raw.happynewyear);
        song.start();
        //loinhan
        txtloinhan.setText("Chúc Mừng Năm Mới!!!");
        createAnimation();
        //taomang
        TaoMang();
        //Listview
        ArrayAdapter adapter = new ArrayAdapter(
                getApplicationContext(), android.R.layout.simple_list_item_1, mangTenBH
        );
        lvBaihat.setAdapter(adapter);
        //Listview Onitemclick
        lvBaihat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                song.stop();
                song = MediaPlayer.create(getApplicationContext(), mangMP3.get(position));
                song.start();
                txtloinhan.setText(mangLoiNhan.get(position));
                createAnimation();
            }
        });
        //back
        txtloinhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                song.stop();
                Intent mhMain = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(mhMain);
            }
        });

    }

    public void TaoMang(){
        mangTenBH = new ArrayList<String>();
        mangLoiNhan = new ArrayList<String>();
        mangMP3 = new ArrayList<Integer>();

        mangMP3.add(R.raw.happynewyear);
        mangTenBH.add("Happy New Year");
        mangLoiNhan.add("HAPPYNEWYEAR!!!!!!!!!!!!");

        mangMP3.add(R.raw.xuanyeuthuong);
        mangTenBH.add("Xuân Yêu Thương");
        mangLoiNhan.add("Chúc mừng năm mới. Mong một năm đầy may lành, hạnh phúc, thành công, sức khoẻ dồi dào tới tất cả mọi người.");

        mangMP3.add(R.raw.cauchuyendaunam);
        mangTenBH.add("Câu Chuyện Đầu Năm");
        mangLoiNhan.add("Giao thừa sắp đến. Chúc bạn đáng mến. Sự nghiệp tiến lên. Gặp nhiều điều hên!");

        mangMP3.add(R.raw.ngayxuanlongphungxumvay);
        mangTenBH.add("Ngày Xuân Long Phụng Xum Vầy");
        mangLoiNhan.add("Năm mới năm me Gia đình mạnh khỏe Mọi người tươi trẻ Đi chơi vui vẻ.");

        mangMP3.add(R.raw.didetrove);
        mangTenBH.add("Đi Để Trở Về");
        mangLoiNhan.add("Cung chúc tân niên một chữ Nhàn.\n" +
                "Chúc mừng gia quyến đặng bình an.");

        mangMP3.add(R.raw.lamgiphaihot);
        mangTenBH.add("Làm Gì Phải Hốt");
        mangLoiNhan.add("Hoa đào nở, chim én về, mùa Xuân lại đến. Chúc nghìn sự như ý, vạn sự như mơ, triệu sự bất ngờ, tỷ lần hạnh phúc…");

        mangMP3.add(R.raw.baogiolaychong);
        mangTenBH.add("Bao Giờ Lấy Chồng");
        mangLoiNhan.add("Tân niên đem lại niềm Hạnh Phúc.\n" +
                "Xuân đến rồi hưởng trọn niềm vui.");

        mangMP3.add(R.raw.muaxuanoi);
        mangTenBH.add("Mùa Xuân Ơi");
        mangLoiNhan.add("Chúc mừng năm mới.");
    }
    public void createAnimation(){
        Animation zoom = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom);
        zoom.reset();
        txtloinhan.clearAnimation();
        txtloinhan.startAnimation(zoom);
    }
}
