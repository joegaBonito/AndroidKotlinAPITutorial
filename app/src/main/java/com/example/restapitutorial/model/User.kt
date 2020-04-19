package com.example.restapitutorial.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User() : Parcelable {
    var firstName : String =""
    var lastName : String =""
    var email: String =""

    constructor(parcel: Parcel) : this() {
        firstName = parcel.readString().toString()
        lastName = parcel.readString().toString()
        email = parcel.readString().toString()
    }

    constructor(firstName : String, lastName : String, email: String): this() {
        this.firstName = firstName
        this.lastName = lastName
        this.email = email
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeString(email)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<User> {
        override fun createFromParcel(parcel: Parcel): User {
            return User(parcel)
        }

        override fun newArray(size: Int): Array<User?> {
            return arrayOfNulls(size)
        }
    }
}