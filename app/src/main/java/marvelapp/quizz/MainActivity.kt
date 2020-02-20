package marvelapp.quizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // text field initialization
        questionText.text = "Qui est-ce personnage Marvel ?"

        //Text Button Radio initialisation
        firstResponse.text = "Batman"
        secondResponse.text = "Aquaman"
        thirdResponse.text = "Thor"

        fun toastMaker (message: String) {
            val duration = Toast.LENGTH_LONG
            var toast = Toast.makeText(applicationContext, message, duration)
            return toast.show()
        }

        //Definition button action
        //Evénement que l'on va déclencher au click
        validateButton.setOnClickListener{
            //initialisation du message de résultat
            var message = "Réponse :"


            // Vérification des réponses
            if (firstResponse.isChecked) {
                message += " Bravo !!! La bonne réponse est bien Batman !!!"
                toastMaker(message)
            } else {
                message += " Dommage :( La bonne réponse est Batman"
                toastMaker(message)
            }

        }

    }
}
