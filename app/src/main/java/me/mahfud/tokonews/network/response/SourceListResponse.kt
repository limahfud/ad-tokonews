package me.mahfud.tokonews.network.response

import com.google.gson.annotations.SerializedName
import me.mahfud.tokonews.model.Source

data class SourceListResponse(@SerializedName("status") val status: String,
                              @SerializedName("sources") val sources: List<Source>)