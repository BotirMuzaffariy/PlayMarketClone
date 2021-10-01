package uz.lazycoder.playmarketclone.models.movies

data class MovieAndBookM(
    var name: String,
    var cost: String,
    var rate: String = "",
    var category: String = "",
    var image: String
)