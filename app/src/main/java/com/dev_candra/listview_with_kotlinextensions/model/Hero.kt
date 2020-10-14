package com.dev_candra.listview_with_kotlinextensions.model

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Hero (
    var name : String,
    var description : String,
    var photo : Int
): Parcelable