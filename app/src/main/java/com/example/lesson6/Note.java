package com.example.lesson6;

import android.os.Parcel;
import android.os.Parcelable;

//1.	Создайте класс данных со структурой заметок:
// название заметки, описание заметки, дата создания и т. п.
public class Note implements Parcelable {
    public final String nameOfNote;
    public final String textOfNote;
    public final String dateOfNote;
    public final String markOfNote;

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
    public String toString () {
        return nameOfNote + ' ' + textOfNote + ' ' + dateOfNote + ' ' + markOfNote;
    }

    @Override
    public void writeToParcel ( Parcel parcel, int i ) {
        parcel.writeString ( nameOfNote );
        parcel.writeString ( textOfNote );
        parcel.writeString ( dateOfNote );
        parcel.writeString ( markOfNote );
    }

    @Override
    public int describeContents () {
        return 0;
    }

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

