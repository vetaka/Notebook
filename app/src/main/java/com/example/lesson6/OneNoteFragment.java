package com.example.lesson6;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;


public class OneNoteFragment extends Fragment {
    public static final String CURRENT_NOTE = "currentNote";
    public Note currentNote = null;
    private EditText nameOfNote;
    private EditText textOfNote;
    private EditText dateOfNote;
    private EditText markOfNote;
    private Button saveButton;

    // Фабричный метод создания фрагмента
    // Фрагменты рекомендуется создавать через фабричные методы
    public static OneNoteFragment newInstance ( Note currentNote ) {
        OneNoteFragment f = new OneNoteFragment ();
        // Передача параметра
        Bundle args = new Bundle ();
        args.putParcelable ( CURRENT_NOTE, currentNote );
        f.setArguments ( args );
        return f;
    }
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        if (getArguments() != null) {
//           currentNote = getArguments().getParcelable (CURRENT_NOTE);
//        }
//    }

    @Override
    public View onCreateView ( LayoutInflater inflater, ViewGroup container,
                               Bundle savedInstanceState ) {
        // Получить из ресурсов массив названий заметок
        // TypedArray notes = getResources().obtainTypedArray(R.array.notebook);

        // Таким способом можно получить головной элемент из макета
        View view = inflater.inflate ( R.layout.fragment_one_note_view, null );
        // найти в контейнере элемент-EditText -имя заметки
        nameOfNote = view.findViewById ( R.id.name_of_note );
        textOfNote = view.findViewById ( R.id.text_of_note );
        dateOfNote = view.findViewById ( R.id.date_of_note );
        markOfNote = view.findViewById ( R.id.mark_of_note );
        saveButton = view.findViewById ( R.id.save_button );
// Установить реквизиты заметки
        saveButton.setOnClickListener ( v -> {
            Controller controller = (Controller) getActivity ();
            controller.saveResult ( new Note (
                    nameOfNote.getText ().toString (),
                    textOfNote.getText ().toString (),
                    dateOfNote.getText ().toString (),
                    markOfNote.getText ().toString ()
            ) );
        } );
        return view;
    }

    @Override
    public void onViewCreated ( View view, Bundle savedInstanceState ) {
        nameOfNote.setText ( currentNote.getNameOfNote () );
        textOfNote.setText ( currentNote.getTextOfNote () );
        dateOfNote.setText ( currentNote.getDateOfNote () );
        markOfNote.setText ( currentNote.getMarkOfNote () );
    }

    @Override
    public void onAttach ( Context context ) {
        super.onAttach ( context );

        if (!(context instanceof Controller)) {
            throw new RuntimeException ( "Activity must implement ProfileFragment.Controller" );
        }
        if (getArguments () != null) {
            currentNote = getArguments ().getParcelable ( CURRENT_NOTE );
        }
    }

    public interface Controller {
        void saveResult ( Note currentNote );
    }
}




