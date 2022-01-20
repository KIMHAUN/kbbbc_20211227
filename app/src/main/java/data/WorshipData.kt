package data

import com.google.gson.annotations.SerializedName

data class WorshipData (
    @SerializedName("worshipId")
    val worshipId: String,
    @SerializedName("worshipUrl")
    val worshipUrl : String,
    @SerializedName("worshipTitle")
    val worshipTitle : String,
    @SerializedName("worshipSubtitle")
    val worshipSubtitle:String = "큰빛성서침례교회",
    @SerializedName("worshipImg")
    val worshipImg: String,
    @SerializedName("worshipDate")
    val worshipDate: String,
    @SerializedName("worshipType")
    val worshipType: String
)