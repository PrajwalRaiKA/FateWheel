package com.rai.fatewheel.data.entities


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Engineer(
    var id: Int?,
    var name: String?
) : Parcelable