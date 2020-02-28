package marvelapp.quizz


data class Flashcard( val question : String = "Qui est ce personnage de Marvel" , val image_small : String , val image : String , val responses : MutableList<String> , val good_response : String)