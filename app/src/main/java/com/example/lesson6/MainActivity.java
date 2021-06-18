package com.example.lesson6;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
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

    @Override
    public boolean onCreateOptionsMenu ( Menu menu ) {
        getMenuInflater ().inflate ( R.menu.main_menu, menu );
//        return super.onCreateOptionsMenu ( menu );
        return true;

    }

    @Override
    public boolean onOptionsItemSelected ( @NonNull MenuItem item ) {
        switch (item.getItemId ()) {
            case R.id.about_app:
                Toast.makeText ( this, "Кратко о нашем приложении", Toast.LENGTH_LONG ).show ();
                break;
            case R.id.gide_of_app:
                Toast.makeText ( this, "Как пользоваться?", Toast.LENGTH_LONG ).show ();
                break;
            default:
                break;

        }
//        return super.onOptionsItemSelected ( item );
        return true;
    }
}

