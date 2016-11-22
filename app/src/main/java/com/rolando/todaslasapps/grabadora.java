package com.rolando.todaslasapps;

import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;

public class grabadora extends AppCompatActivity implements MediaPlayer.OnCompletionListener {
    TextView estado;
    MediaRecorder recorder;
    MediaPlayer player;
    File archivo;
    Button grab;
    Button pau;
    Button rep;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grabadora);
        estado = (TextView) findViewById(R.id.textView2);
        grab = (Button) findViewById(R.id.button);
        pau = (Button) findViewById(R.id.button2);
        rep = (Button) findViewById(R.id.button3);

    }

    public void btnGrabar (View v){
        recorder = new MediaRecorder();
        recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        recorder.setOutputFormat(MediaRecorder.OutputFormat.THREE_GPP);
        recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AMR_NB);
        File path = new File(Environment.getExternalStorageDirectory()
                .getPath());
        try {
            archivo = File.createTempFile("temporal", ".3gp", path);
        } catch (IOException e) {
        }
        recorder.setOutputFile(archivo.getAbsolutePath());
        try {
            recorder.prepare();
        } catch (IOException e) {
        }
        recorder.start();
        estado.setText("Grabando");
        rep.setEnabled(false);
        pau.setEnabled(true);
    }
    public void btnReproducir (View v){
        player.start();
        pau.setEnabled(false);
        rep.setEnabled(false);
        grab.setEnabled(false);
        estado.setText("Reproduciendo");

    }
    public void btnDetener (View v){
        recorder.stop();
        recorder.release();
        player = new MediaPlayer();
        player.setOnCompletionListener(this);
        try {
            player.setDataSource(archivo.getAbsolutePath());
        } catch (IOException e) {
        }
        try {
            player.prepare();
        } catch (IOException e) {
        }
        rep.setEnabled(true);
        pau.setEnabled(false);
        grab.setEnabled(true);
        estado.setText("Listo para reproducir");

    }
    public void onCompletion (MediaPlayer mp){
        rep.setEnabled(true);
        grab.setEnabled(true);
        pau.setEnabled(true);
        estado.setText("Listo");
    }
}
