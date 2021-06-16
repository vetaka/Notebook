package com.example.lesson6;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements NotesFragment.Controller, OneNoteFragment.Controller {

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );

        getSupportFragmentManager ()
                .beginTransaction ()
                .add ( R.id.container, new NotesFragment () )
                .commit ();
    }

    @Override
    public void saveResult ( Note currentNote ) {
        // todo
    }

    @Override
    public void openOneNoteScreen ( Note currentNote ) {
        boolean isLandscape = getResources ().getConfiguration ().orientation == Configuration.ORIENTATION_LANDSCAPE;
        getSupportFragmentManager ()
                .beginTransaction ()
                .add ( isLandscape ? R.id.one_note_container : R.id.container, OneNoteFragment.newInstance ( currentNote ) )
                .addToBackStack ( null )
                .commit ();

    }
}

