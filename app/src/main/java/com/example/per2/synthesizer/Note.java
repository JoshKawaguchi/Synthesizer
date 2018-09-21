package com.example.per2.synthesizer;

public class Note {
    private int noteId;
    private int delay;
    public  static  final  int WHOLE_NOTE = 1000;

    public Note(int noteId) {
        this.noteId = noteId;
        delay = WHOLE_NOTE/3;
    }
    public Note(int noteId,int d)
    {
        this.noteId = noteId;
        delay = d;
    }
    public int getNoteId() {
        return noteId;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    @Override
    public String toString() {
        return "Note{" +
                "noteId=" + noteId +
                ", delay=" + delay +
                '}';
    }
}
