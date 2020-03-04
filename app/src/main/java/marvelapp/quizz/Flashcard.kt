package marvelapp.quizz

class Flashcard(
    val question: String = "Qui est ce personnage de Marvel",
    var image_small: String, val image: String,
    val responses: MutableList<String>,
    val good_response: String )