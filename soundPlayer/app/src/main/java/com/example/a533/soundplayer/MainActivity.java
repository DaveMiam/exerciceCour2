package com.example.a533.soundplayer;

import android.app.Application;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mediaPlayer =  MediaPlayer.create(this, R.raw.farm);
        mediaPlayer.setLooping(false);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable(){


            @Override
            public void run() {
                SeekBar seekBarMedia = findViewById(R.id.seekBarMedia);
                seekBarMedia.setProgress(mediaPlayer.getCurrentPosition()*100 / mediaPlayer.getDuration());
                handler.postDelayed(this,1000);
            }
        },1000);
        setListener();
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                Toast.makeText(MainActivity.this,"salut",Toast.LENGTH_SHORT ).show();
            }
        });
    }


    public void setListener() {
        findViewById(R.id.buttonPlay).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playMediaPlayer();
            }
        });
            findViewById(R.id.buttonPause).setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                pauseMediaPlayer();
            }
        });
        setSeekBarListener();
        }



private void setSeekBarListener(){
        SeekBar seekBarMedia = findViewById(R.id.seekBarMedia);
        seekBarMedia.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if(fromUser){
                    seekInMedia(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

SeekBar seekBarVolume = findViewById(R.id.seekBarVolume);
seekBarVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        int maxVolume = 100;
        float log1=(float)(Math.log(maxVolume-progress)/Math.log(maxVolume));
        mediaPlayer.setVolume(1-log1 , 1-log1);

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
});
}

public void message(){


}

private void seekInMedia(int progress){
mediaPlayer.seekTo(progress * mediaPlayer.getDuration() / 100);
}

    private void playMediaPlayer() {
        if (!mediaPlayer.isPlaying()) {
            mediaPlayer.start();
        }
    }

    private void pauseMediaPlayer() {
        if (mediaPlayer.isPlaying()) {
            mediaPlayer.pause();
        }
    }



}












  //  public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser)
    //int MAX_VOLUME = 100;
   // final float volume = (float) (1 - (Math.log(MAX_VOLUME - soundVolume) / Math.log(MAX_VOLUME)));
     //   mediaPlayer.setVolume(volume, volume);


//private void setVolume()
   //     {

     //   }