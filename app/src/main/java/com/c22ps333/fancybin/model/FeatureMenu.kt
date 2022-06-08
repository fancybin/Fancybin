package com.c22ps333.fancybin.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class FeatureMenu(
    var title: String,
    var description: String,
    var image: Int
) : Parcelable