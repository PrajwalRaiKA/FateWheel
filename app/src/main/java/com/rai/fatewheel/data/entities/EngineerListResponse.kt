package com.rai.fatewheel.data.entities


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class EngineerListResponse(
    var engineers: List<Engineer>
) : Parcelable