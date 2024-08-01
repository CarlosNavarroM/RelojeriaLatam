package com.desafiolatam.desafio3.model

import android.os.Parcel
import android.os.Parcelable

data class Sucursal(
    val nombre: String,
    val direccion: String,
    val horario: String,
    val foto: Int,
    val historia: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(direccion)
        parcel.writeString(horario)
        parcel.writeInt(foto)
        parcel.writeString(historia)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Sucursal> {
        override fun createFromParcel(parcel: Parcel): Sucursal {
            return Sucursal(parcel)
        }

        override fun newArray(size: Int): Array<Sucursal?> {
            return arrayOfNulls(size)
        }
    }
}
