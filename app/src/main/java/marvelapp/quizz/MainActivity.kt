package marvelapp.quizz

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import com.squareup.picasso.Picasso;



class MainActivity : AppCompatActivity() {


    // List of Flashcard object
    var marvels = mutableListOf<Flashcard>()

    var currentIndex: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // instantiation Flashcard

        marvels.add(
            Flashcard(
                "Qui est-ce personnage de Marvel ?",
                "https://www.superherodb.com/pictures2/portraits/10/100/1496.jpg",
                "batman",
                mutableListOf("Batman", "Groot", "Robin"),
                "Batman"
            )
        )

        marvels.add(
            Flashcard(
                "De qui s'agit-il ? ",
                "https://www.superherodb.com/pictures2/portraits/10/100/659.jpg",
                "batman",
                mutableListOf("Jessica Jones", "Catwoman", "America Chavez"),
                "Catwoman"
            )
        )

        marvels.add(
            Flashcard(
                "Mais qui est-ce personnage ?",
                "https://www.superherodb.com/pictures2/portraits/10/100/247.jpg",
                "batman",
                mutableListOf("Black Panther", "Le fauve", "Drax"),
                "Black Panther"
            )
        )

        marvels.add(
            Flashcard(
                "Qui est ce superheroe ? ",
                "https://www.superherodb.com/pictures2/portraits/10/100/161.jpg",
                "batman",
                mutableListOf("Colossus", "Drax", "Wolverine"),
                "Wolverine"
            )
        )

        //shuffle the list of flashcard
        marvels.shuffle()

        //fill the flashcard
        showQuestion(marvels.get(currentIndex))

        indexQuizz(currentIndex,marvels.size)


    }


    fun indexQuizz(currentIndex : Int, total : Int){

        supportActionBar!!.title = "Marvel Quizz - ${currentIndex + 1} / ${total}"
    }

    /*
  * Function to initialize a message toast
  * @parametre message : String
  * @return toast
  */

    fun toastMaker(message: String) {
        val duration = Toast.LENGTH_LONG
        var toast = Toast.makeText(applicationContext, message, duration)
        return toast.show()
    }


    fun showQuestion(flashcard: Flashcard) {

        //Question initialization
        questionText.text = flashcard.question

        //Loading image using Picasso
       Picasso.get().load("http://i.imgur.com/DvpvklR.png")
           .into(quizzImage)


        //Text Button Radio initialization
        var radiobuttonlist = flashcard.responses
        //Filling the radio buttons
        createRadioButton(radiobuttonlist)
        // Checking the right answer
        answerIsCorrect(flashcard)

    }

    fun createRadioButton(responses: MutableList<String>) {

        //Call shuffle method to have random result
        responses.shuffle()

        //Adding radio button into radioGroup
        for (response in responses) {
            var radioButton = RadioButton(this)
            radioButton.text = response
            radioGroup.addView(radioButton)
        }
    }

    fun answerIsCorrect(flashcard: Flashcard) {

        //answer verification
        validateButton.setOnClickListener {
            //initialization message toast
            var message = "Réponse :"
            //I will check in the radioGroup if a radio button has been checked
            val checkedRadioButtonId = radioGroup.checkedRadioButtonId
            val selectedRadioButton = radioGroup.findViewById<RadioButton>(checkedRadioButtonId)

            // If none is checked it returns -1
            // If it is checked I compared the value to the right answer
            if (selectedRadioButton.text == flashcard.good_response) {
                message += " Bravo !!! La bonne réponse est bien ${flashcard.good_response} !!!"
                toastMaker(message)
                //Transform the button
                validateButton.text = "Question suivante"
            } else {
                message += " Dommage :( La bonne réponse est ${flashcard.good_response}"
                toastMaker(message)
            }

            //Going to the next question
            currentIndex++
            //I check if there are other questions
            if(currentIndex >= marvels.size){
                validateButton.text = "Voir les résultats"
            }else{ // we going to the next question
                radioGroup.removeAllViews()
                showQuestion(marvels.get(currentIndex))
                indexQuizz(currentIndex,marvels.size)
            }

        }
    }


}
