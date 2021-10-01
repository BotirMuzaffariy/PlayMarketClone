package uz.lazycoder.playmarketclone.models

data class GameAndAppM(
    var name: String,
    var category: String,
    var tags: List<String> = emptyList(),
    var icon: String,
    var rate: String,
    var sizeOrCost: String,
    var screenshot: String = ""
)