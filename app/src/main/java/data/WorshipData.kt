package data

data class WorshipData (
    val worshipId: String,
    val worshipUrl : String,
    val worshipTitle : String,
    val worshipSubtitle:String = "큰빛성서침례교회",
    val worshipImg: String,
    val worshipDate: String,
    val worshipType: String
)