package com.example.lugian.musicplayer;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class mp3Fragment extends Fragment {

    TextView title, artist, timeSong, timeTotal;
    SeekBar skSong;
    ImageButton btPrev, btPlay, btNext, btFav, btRepeat;
    ImageView imgAlbum;

    ArrayList<Song> arraySong;
    int position = 0;
    MediaPlayer mediaPlayer;

    public mp3Fragment (){

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mp3, container, false);
        imgAlbum = (ImageView) view.findViewById(R.id.imageviewAlbum);
        title = (TextView) view.findViewById(R.id.testviewTitle);
        artist =(TextView) view.findViewById(R.id.testviewArtist);
        timeSong = (TextView) view.findViewById(R.id.textviewTimeSong);
        timeTotal = (TextView) view.findViewById(R.id.textviewTimeTotal);
        skSong = (SeekBar) view.findViewById(R.id.seekbarSong);
        btPrev = (ImageButton) view.findViewById(R.id.imageButtonPrev);
        btPlay = (ImageButton) view.findViewById(R.id.imageButtonPlay);
        btNext = (ImageButton) view.findViewById(R.id.imageButtonNext);
        btFav = (ImageButton) view.findViewById(R.id.imageButtonFav);
        btRepeat = (ImageButton) view.findViewById(R.id.imageButtonRepeat);

        AddSong();
        CreateMediaPlayer();


        btRepeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.setLooping(true);
                mediaPlayer.start();
            }
        });

        btNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position++;
                if(position > arraySong.size() - 1){
                    position = 0;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                CreateMediaPlayer();
                mediaPlayer.start();
                btPlay.setImageResource(R.drawable.pause);
                SetTimeTotal();
                UpdateTimeSong();
            }
        });

        btPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                position-- ;
                if(position < 0){
                    position = arraySong.size() - 1;
                }
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                CreateMediaPlayer();
                mediaPlayer.start();
                btPlay.setImageResource(R.drawable.pause);
                SetTimeTotal();
                UpdateTimeSong();
            }
        });

        btPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    btPlay.setImageResource(R.drawable.play);
                } else{
                    mediaPlayer.start();
                    btPlay.setImageResource(R.drawable.pause);
                }
                SetTimeTotal();
                UpdateTimeSong();
            }
        });
        skSong.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                mediaPlayer.seekTo(skSong.getProgress());
            }
        });

        return view;

    }





    private void UpdateTimeSong(){
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                SimpleDateFormat typeOfTime = new SimpleDateFormat("mm:ss");
                timeSong.setText(typeOfTime.format(mediaPlayer.getCurrentPosition()));
                skSong.setProgress(mediaPlayer.getCurrentPosition());
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        position++;
                        if(position > arraySong.size() - 1){
                            position = 0;
                        }
                        if(mediaPlayer.isPlaying()){
                            mediaPlayer.stop();
                        }
                        CreateMediaPlayer();
                        mediaPlayer.start();
                        btPlay.setImageResource(R.drawable.pause);
                        SetTimeTotal();
                        UpdateTimeSong();
                    }
                });
                handler.postDelayed(this, 500);
            }
        }, 100);
    }

    private void SetTimeTotal(){
        SimpleDateFormat typeOfTime = new SimpleDateFormat("mm:ss");
        timeTotal.setText(typeOfTime.format(mediaPlayer.getDuration()));
        skSong.setMax(mediaPlayer.getDuration());
    }

    private void AddSong() {
        arraySong = new ArrayList<>();
        arraySong.add(new Song("Sau tất cả", R.drawable.sau_tat_ca,"Erik" , R.raw.sau_tat_ca_erik));
        arraySong.add(new Song("Yêu 5", R.drawable.yeu_5 ,"Rhymastic" , R.raw.yeu_5_rhymastic));
        arraySong.add(new Song("Thằng điên", R.drawable.thang_dien,"JustaTee ft Phương Ly", R.raw.thang_dien_justatee_phuongly));
    }



    public void CreateMediaPlayer(){
        mediaPlayer = MediaPlayer.create(getActivity(), arraySong.get(position).getFile());
        title.setText(arraySong.get(position).getTitle());
        artist.setText(arraySong.get(position).getArtist());
        imgAlbum.setImageResource(arraySong.get(position).getImageAlbum());
    }

}
