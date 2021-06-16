package com.example.lesson6;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 * Use the  factory method to
 * create an instance of this fragment.
 */
public class NotesFragment extends Fragment {
    // public static final String CURRENT_NOTE = "currentNote";
    private Note currentNote; // **
    private boolean isLandscape;
    private LinearLayout linearLayout;

    private void addNoteToList ( Note currentNote ) {
        Button button = new Button ( getContext () );
        button.setText ( currentNote.nameOfNote );
        button.setOnClickListener ( v -> ((Controller) getActivity ()).openOneNoteScreen ( currentNote ) );
        linearLayout.addView ( button );
    }


    // При создании фрагмента укажем его макет
    @Override
    public View onCreateView ( LayoutInflater inflater, ViewGroup container,
                               Bundle savedInstanceState ) {
        return inflater.inflate ( R.layout.fragment_notes, null );
    }

    @Override
    public void onAttach ( Context context ) {
        super.onAttach ( context );
        if (!(context instanceof Controller)) {
            throw new RuntimeException ( "Activity must implement NotesFragment.Controller" );
        }
    }

    // вызывается после создания макета фрагмента, здесь мы проинициализируем список
    @Override
    public void onViewCreated ( View view, Bundle savedInstanceState ) {

        linearLayout = view.findViewById ( R.id.linear );
        initList ();
    }


    // создаём список заметок из массива в ресурсах
    private void initList () {

        String[] notes = getResources ().getStringArray ( R.array.notebook );

        for (int i = 0; i < notes.length; i = i + 4) {
            //получить объект заметки:
            currentNote = new Note ( notes[i], notes[i + 1], notes[i + 2], notes[i + 3] );
            addNoteToList ( currentNote );
            // передать текущую запись Note методу показа тек.записи
        }
    }

//    // Сохраним текущую позицию (вызывается перед выходом из фрагмента)
//    @Override
//    public void onSaveInstanceState ( @NonNull Bundle outState ) {
//        outState.putParcelable ( CURRENT_NOTE, currentNote );
//        super.onSaveInstanceState ( outState );
//    }


    public interface Controller {
        void openOneNoteScreen ( Note currentNote );
    }
}








