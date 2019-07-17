package com.example.hahaj.chapter7

import android.os.Parcel
import android.os.Parcelable

class Board constructor (var title: String, var content: String, var author: String) : Parcelable{

    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString()) {}

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(title)
        dest.writeString(content)
        dest.writeString(author)
    }

    override fun describeContents(): Int {
               return 0
    }

    companion object CREATOR: Parcelable.Creator<Board> {
        override fun createFromParcel(source: Parcel): Board {
            return Board(source)
        }

        override fun newArray(size: Int): Array<Board?> {
            return arrayOfNulls(size)
        }

    }

}