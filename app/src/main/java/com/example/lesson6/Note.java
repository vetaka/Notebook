package com.example.lesson6;

import android.os.Parcel;
import android.os.Parcelable;

//1.	Создайте класс данных со структурой заметок:
// название заметки, описание заметки, дата создания и т. п.
public class Note implements Parcelable {

    public static final Creator<Note> CREATOR = new Creator<Note> () {
        @Override
        public Note createFromParcel ( Parcel in ) {
            return new Note ( in );
        }

        @Override
        public Note[] newArray ( int size ) {
            return new Note[size];
        }
    };
    private final String nameOfNote;
    private final String textOfNote;
    private final String dateOfNote;
    private final String markOfNote;

    public Note ( String nameOfNote, String textOfNote, String dateOfNote, String markOfNote ) {
        this.nameOfNote = nameOfNote;
        this.textOfNote = textOfNote;
        this.dateOfNote = dateOfNote;
        this.markOfNote = markOfNote;
    }

    protected Note ( Parcel in ) {
        nameOfNote = in.readString ();
        textOfNote = in.readString ();
        dateOfNote = in.readString ();
        markOfNote = in.readString ();
    }

    @Override
    public int describeContents () {
        return 0;
    }

    @Override
    public void writeToParcel ( Parcel parcel, int i ) {
        parcel.writeString ( getNameOfNote () );
        parcel.writeString ( getTextOfNote () );
        parcel.writeString ( getDateOfNote () );
        parcel.writeString ( getMarkOfNote () );
    }

    public String getNameOfNote () {
        return nameOfNote;
    }

    public String getTextOfNote () {
        return textOfNote;
    }

    public String getDateOfNote () {
        return dateOfNote;
    }

    public String getMarkOfNote () {
        return markOfNote;
    }
}

