package com.example.per2.synthesizer;

import android.media.AudioManager;
import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;


public class SynthesizerActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonA;
    private Button buttonBb;
    private Button buttonB;
    private Button buttonScale;
    private Button buttonC;
    private Button buttonCc;
    private Button buttonD;
    private Button buttonDd;
    private Button buttonE;
    private Button buttonF;
    private Button buttonFf;
    private Button buttonG;
    private Button buttonGg;
    private Button buttonSong;
    private Map<Integer, Integer> noteMap;

    private int noteA;
    private int noteBb;
    private int noteB;
    private int noteC;
    private int noteCc;
    private int noteD;
    private int noteDd;
    private int noteE;
    private int noteEe;
    private int noteF;
    private int noteFf;
    private int noteG;
    private int noteGg;
    private SoundPool soundPool;


    public static final float DEFAULT_VOLUME = 1.0f;
    public static final float DEFAULT_RATE = 1.0f;
    public static  final int DEFAULT_PRIORITY = 1;
    public static final int WHOLE_NOTE = 1000; //in ms

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synthesizer);

        wireWidgets();
        setListeners();
        initializeSoundPool();
        initializeNoteMap();
    }

    private void initializeNoteMap() {
        noteMap = new HashMap<>();
        //in a map. you store a key:value pair
        //in this case the key is the buddon Id, the value is the noteId
        noteMap.put(R.id.button_synth_a,noteA);
        noteMap.put(R.id.button_synth_b,noteB);
        noteMap.put(R.id.button_synth_bb,noteBb);
        noteMap.put(R.id.button_synth_c,noteC);
        noteMap.put(R.id.button_synth_csharp,noteCc);
        noteMap.put(R.id.button_synth_d,noteD);
        noteMap.put(R.id.button_synth_dsharp,noteDd);
        noteMap.put(R.id.button_synth_e,noteE);
        noteMap.put(R.id.button_synth_f,noteF);
        noteMap.put(R.id.button_synth_fsharp,noteFf);
        noteMap.put(R.id.button_synth_g,noteG);
        noteMap.put(R.id.button_synth_gsharp,noteGg);
    }

    private void initializeSoundPool() {
        soundPool = new SoundPool( 10, AudioManager.STREAM_MUSIC, 0);
        noteA = soundPool.load(this, R.raw.scalehigha, 1);
        noteBb = soundPool.load(this, R.raw.scalehighbb, 1);
        noteB = soundPool.load(this, R.raw.scalehighb, 1);
        noteC = soundPool.load(this, R.raw.scalehighc,1);
        noteCc = soundPool.load(this, R.raw.scalehighcs,1);
        noteD = soundPool.load(this, R.raw.scalehighd,1);
        noteDd = soundPool.load(this, R.raw.scalehighds,1);
        noteE = soundPool.load(this, R.raw.scalehighe,1);
        noteEe = soundPool.load(this, R.raw.scalehighds,1);
        noteF = soundPool.load(this, R.raw.scalehighf,1);
        noteFf = soundPool.load(this, R.raw.scalehighfs,1);
        noteG = soundPool.load(this, R.raw.scalehighg, 1);
        noteGg = soundPool.load(this, R.raw.scalehighgs, 1);
    }

    private void setListeners() {
        KeyboardNoteListener noteListener = new KeyboardNoteListener();
        //challenge buttons still use the activity's implementation

        buttonA.setOnClickListener(noteListener);
        buttonBb.setOnClickListener(noteListener);
        buttonB.setOnClickListener(noteListener);
        buttonC.setOnClickListener(noteListener);
        buttonCc.setOnClickListener(noteListener);
        buttonD.setOnClickListener(noteListener);
        buttonDd.setOnClickListener(noteListener);
        buttonE.setOnClickListener(noteListener);
        buttonF.setOnClickListener(noteListener);
        buttonFf.setOnClickListener(noteListener);
        buttonG.setOnClickListener(noteListener);
        buttonGg.setOnClickListener(noteListener);
        buttonScale.setOnClickListener(this);
        buttonSong.setOnClickListener(this);

    }

    private void wireWidgets() {
        buttonA = findViewById(R.id.button_synth_a);
        buttonBb = findViewById(R.id.button_synth_bb);
        buttonB = findViewById((R.id.button_synth_b));
        buttonC = findViewById(R.id.button_synth_c);
        buttonCc = findViewById(R.id.button_synth_csharp);
        buttonD = findViewById(R.id.button_synth_d);
        buttonDd = findViewById(R.id.button_synth_dsharp);
        buttonE = findViewById(R.id.button_synth_e);
        buttonF = findViewById(R.id.button_synth_f);
        buttonFf = findViewById(R.id.button_synth_fsharp);
        buttonG = findViewById(R.id.button_synth_g);
        buttonGg = findViewById(R.id.button_synth_gsharp);
        buttonScale = findViewById(R.id.button_synth_playScale);
        buttonSong = findViewById(R.id.button_synth_playSong);
    }

    @Override
    public void onClick(View view) {
        // one method to handle the clocks of all the buttons
        // but don't forget t otell the buttons who is doing
        // the listening
////        switch (view.getId()){
////            case R.id.button_synth_a:
////                soundPool.play(noteA, 1.0f, 1.0f, 1, 1, 1.0f);
////                break;
////            case R.id.button_synth_bb:
////                soundPool.play(noteBb, 1.0f, 1.0f, 1, 1, 1.0f);
////                break;
////            case R.id.button_synth_b:
////                soundPool.play(noteB, 1.0f, 1.0f, 1, 1, 1.0f);
////                break;
////            case R.id.button_synth_c:
////                soundPool.play(noteC, 1.0f, 1.0f, 1, 1, 1.0f);
////                break;
////            case R.id.button_synth_csharp:
////                soundPool.play(noteCc, 1.0f, 1.0f, 1, 1, 1.0f);
////                break;
////            case R.id.button_synth_d:
////                soundPool.play(noteD, 1.0f, 1.0f, 1, 1, 1.0f);
////                break;
////            case R.id.button_synth_dsharp:
////                soundPool.play(noteDd, 1.0f, 1.0f, 1, 1, 1.0f);
////                break;
////            case R.id.button_synth_e:
////                soundPool.play(noteE, 1.0f, 1.0f, 1, 1, 1.0f);
////                break;
////            case R.id.button_synth_f:
////                soundPool.play(noteF, 1.0f, 1.0f, 1, 1, 1.0f);
////                break;
////            case R.id.button_synth_fsharp:
////                soundPool.play(noteFf, 1.0f, 1.0f, 1, 1, 1.0f);
////                break;
////            case R.id.button_synth_g:
////                soundPool.play(noteG, 1.0f, 1.0f, 1, 1, 1.0f);
////                break;
////            case R.id.button_synth_gsharp:
////                soundPool.play(noteGg, 1.0f, 1.0f, 1, 1, 1.0f);
////                break;
//            case R.id.button_synth_playScale:
//                playScale();
//                break;
//            case R.id.button_synth_playSong:
//                playSong();
//                break;
//        }
        switch(view.getId()) {
            case R.id.button_synth_playScale:
                playSong();
                break;
            case R.id.button_synth_playSong:
                playScale();
                break;
        }
    }

    private void playSong() {
    com.example.per2.synthesizer.Song scale = new com.example.per2.synthesizer.Song();

        playNote(noteA);
        playNote(noteA);
        playNote(noteE);
        playNote(noteE);
        playNote(noteFf);
        playNote(noteFf);
        playNote(noteE);
        playNote(noteD);
        playNote(noteD);
        playNote(noteCc);
        playNote(noteCc);
        playNote(noteB);
        playNote(noteB);
        playNote(noteA);

        playNote(noteE);
        playNote(noteE);
        playNote(noteD);
        playNote(noteD);
        playNote(noteCc);
        playNote(noteCc);
        playNote(noteB);
        playNote(noteE);
        playNote(noteE);
        playNote(noteD);
        playNote(noteD);
        playNote(noteCc);
        playNote(noteCc);
        playNote(noteB);

        playNote(noteA);
        playNote(noteA);
        playNote(noteE);
        playNote(noteE);
        playNote(noteFf);
        playNote(noteFf);
        playNote(noteE);
        playNote(noteD);
        playNote(noteD);
        playNote(noteCc);
        playNote(noteCc);
        playNote(noteB);
        playNote(noteB);
        playNote(noteA);



    }

    private void playSong1(Song scale){
        for(Note note : scale.getNotes()){
            playNote(note);
            delay(note.getDelay());
        }
    }

    private void playScale() {
        //play all notes one at a time with a break in between
        Song scale = new Song();

//        scale.add(new Note(noteD));
//        scale.add(new Note(noteA));
//        scale.add(new Note(noteA));
//        scale.add(new Note(noteA));
//        scale.add(new Note(noteG));
//        scale.add(new Note(noteC));
//
//        scale.add(new Note(noteC));
//        scale.add(new Note(noteA));
//        scale.add(new Note(noteG));
//        scale.add(new Note(noteG));
//

        scale.add(new Note(noteD,Note.WHOLE_NOTE/3));
        scale.add(new Note(noteD,Note.WHOLE_NOTE/3));
        scale.add(new Note(noteD,Note.WHOLE_NOTE/3));
        scale.add(new Note(noteD,Note.WHOLE_NOTE));
        scale.add(new Note(noteD,Note.WHOLE_NOTE/3));
        scale.add(new Note(noteC,Note.WHOLE_NOTE/3));
        scale.add(new Note(noteA,Note.WHOLE_NOTE/3));
        scale.add(new Note(noteF,Note.WHOLE_NOTE));

        scale.add(new Note(noteG));
        scale.add(new Note(noteD));
        scale.add(new Note(noteD));
        scale.add(new Note(noteC));
        scale.add(new Note(noteBb));
        scale.add(new Note(noteC,Note.WHOLE_NOTE));

        scale.add(new Note(noteEe));
        scale.add(new Note(noteEe));
        scale.add(new Note(noteEe));
        scale.add(new Note(noteD));
        scale.add(new Note(noteC));
        scale.add(new Note(noteBb,Note.WHOLE_NOTE));

        scale.add(new Note(noteBb));
        scale.add(new Note(noteD));
        scale.add(new Note(noteD));
        scale.add(new Note(noteC));
        scale.add(new Note(noteBb));
        scale.add(new Note(noteD,Note.WHOLE_NOTE));

        scale.add(new Note(noteD,Note.WHOLE_NOTE/3));
        scale.add(new Note(noteD,Note.WHOLE_NOTE/3));
        scale.add(new Note(noteD,Note.WHOLE_NOTE/3));
        scale.add(new Note(noteD,Note.WHOLE_NOTE/3));
        scale.add(new Note(noteD,Note.WHOLE_NOTE/2));
        scale.add(new Note(noteC));
        scale.add(new Note(noteA));
        scale.add(new Note(noteF,Note.WHOLE_NOTE));

        scale.add(new Note(noteD));
        scale.add(new Note(noteD));
        scale.add(new Note(noteC));
        scale.add(new Note(noteBb));
        scale.add(new Note(noteC,Note.WHOLE_NOTE));

        scale.add(new Note(noteEe));
        scale.add(new Note(noteEe));
        scale.add(new Note(noteEe));
        scale.add(new Note(noteEe));
        scale.add(new Note(noteEe));
        scale.add(new Note(noteD));
        scale.add(new Note(noteC));
        scale.add(new Note(noteBb,Note.WHOLE_NOTE));

        scale.add(new Note(noteBb));
        scale.add(new Note(noteD));
        scale.add(new Note(noteD));
        scale.add(new Note(noteC));
        scale.add(new Note(noteBb));
        scale.add(new Note(noteD,Note.WHOLE_NOTE));

        scale.add(new Note(noteD));
        scale.add(new Note(noteF));
        scale.add(new Note(noteG,Note.WHOLE_NOTE));
        scale.add(new Note(noteD));
        scale.add(new Note(noteD));
        scale.add(new Note(noteF));
        scale.add(new Note(noteG));
        scale.add(new Note(noteG));
        scale.add(new Note(noteF,Note.WHOLE_NOTE));

        scale.add(new Note(noteG));
        scale.add(new Note(noteG));
        scale.add(new Note(noteA));
        scale.add(new Note(noteBb));
        scale.add(new Note(noteG));
        scale.add(new Note(noteF));
        scale.add(new Note(noteD));

        scale.add(new Note(noteD));
        scale.add(new Note(noteF));
        scale.add(new Note(noteG,Note.WHOLE_NOTE));
        scale.add(new Note(noteG,Note.WHOLE_NOTE));
        scale.add(new Note(noteG));
        scale.add(new Note(noteF));
        scale.add(new Note(noteD));
        scale.add(new Note(noteC));
        scale.add(new Note(noteBb,Note.WHOLE_NOTE));

        scale.add(new Note(noteBb));
        scale.add(new Note(noteC));
        scale.add(new Note(noteD));
        scale.add(new Note(noteD));
        scale.add(new Note(noteC));
        scale.add(new Note(noteBb));
        scale.add(new Note(noteD,Note.WHOLE_NOTE));

        scale.add(new Note(noteD));
        scale.add(new Note(noteF));
        scale.add(new Note(noteG,Note.WHOLE_NOTE));
        scale.add(new Note(noteD));
        scale.add(new Note(noteD));
        scale.add(new Note(noteF));
        scale.add(new Note(noteG));
        scale.add(new Note(noteG));
        scale.add(new Note(noteF,Note.WHOLE_NOTE));

        scale.add(new Note(noteG));
        scale.add(new Note(noteG));
        scale.add(new Note(noteA));
        scale.add(new Note(noteBb));
        scale.add(new Note(noteA));
        scale.add(new Note(noteG));
        scale.add(new Note(noteF,Note.WHOLE_NOTE));

        scale.add(new Note(noteE));
        scale.add(new Note(noteBb));
        scale.add(new Note(noteBb));
        scale.add(new Note(noteBb));
        scale.add(new Note(noteF));
        scale.add(new Note(noteBb));
        scale.add(new Note(noteBb,Note.WHOLE_NOTE));

        scale.add(new Note(noteBb));
        scale.add(new Note(noteBb));
        scale.add(new Note(noteBb));
        scale.add(new Note(noteA,Note.WHOLE_NOTE));

        scale.add(new Note(noteD));
        scale.add(new Note(noteD));
        scale.add(new Note(noteF));
        scale.add(new Note(noteG));
        scale.add(new Note(noteG,Note.WHOLE_NOTE));
        scale.add(new Note(noteD));
        scale.add(new Note(noteD));
        scale.add(new Note(noteF));
        scale.add(new Note(noteG));
        scale.add(new Note(noteBb));
        scale.add(new Note(noteG,Note.WHOLE_NOTE));

        scale.add(new Note(noteD));
        scale.add(new Note(noteC));
        scale.add(new Note(noteBb));
        scale.add(new Note(noteG));


        playSong1(scale);
    }

    private void delay(int duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void playNote(int note, int loop) {
        soundPool.play(note,DEFAULT_VOLUME,DEFAULT_VOLUME,DEFAULT_PRIORITY,loop,DEFAULT_RATE);

    }
    private  void playNote(int note){
        playNote(note,0);
        delay(WHOLE_NOTE/3);
    }
    private void playNote(Note note){
        playNote(note.getNoteId(),0);
        //delay(WHOLE_NOTE/10);
    }


    private class KeyboardNoteListener implements  View.OnClickListener {

        @Override
        public void onClick(View view) {
            //get the id of the button that was clicked
            int id = view.getId();
            //use the map to figure out what ntoe to play
            int note = noteMap.get(id);
            //play the note
            playNote(note);
        }
    }

}
