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
    private EditText nameOfNoteET;
    private EditText textOfNoteET;
    private EditText dateOfNoteET;
    private EditText markOfNoteET;
    private Button saveButton;

    // Фабричный метод создания фрагмента
    // Фрагменты рекомендуется создавать через фабричные методы
    public static OneNoteFragment newInstance ( Note currentNote ) {
        OneNoteFragment oneNF = new OneNoteFragment ();
        // Передача параметра
        Bundle args = new Bundle ();
        args.putParcelable ( CURRENT_NOTE, currentNote );
        oneNF.setArguments ( args );
        return oneNF;
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

        // Таким способом можно получить головной элемент из макета
        View view = inflater.inflate ( R.layout.fragment_one_note_view, null );
        // найти в контейнере элементы-EditText
        nameOfNoteET = view.findViewById ( R.id.name_of_note );
        textOfNoteET = view.findViewById ( R.id.text_of_note );
        dateOfNoteET = view.findViewById ( R.id.date_of_note );
        markOfNoteET = view.findViewById ( R.id.mark_of_note );

        saveButton = view.findViewById ( R.id.save_button );
// Установить реквизиты заметки
        saveButton.setOnClickListener ( v -> {
            Controller controller = (Controller) getActivity ();
            controller.saveResult ( new Note (
                    nameOfNoteET.getText ().toString (),
                    textOfNoteET.getText ().toString (),
                    dateOfNoteET.getText ().toString (),
                    markOfNoteET.getText ().toString ()
            ) );
        } );
        return view;
    }

    @Override
    public void onViewCreated ( View view, Bundle savedInstanceState ) {
        nameOfNoteET.setText ( currentNote.nameOfNote );
        textOfNoteET.setText ( currentNote.textOfNote );
        dateOfNoteET.setText ( currentNote.dateOfNote );
        markOfNoteET.setText ( currentNote.markOfNote );
    }

    @Override
    public void onAttach ( Context context ) {
        super.onAttach ( context );

        if (!(context instanceof Controller)) {
            throw new RuntimeException ( "Activity must implement OneNoteFragment.Controller" );
        }
        if (getArguments () != null) {
            currentNote = getArguments ().getParcelable ( CURRENT_NOTE );
        }
    }

    public interface Controller {
        void saveResult ( Note currentNote );
    }
}




