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

        //Text Button Radio initialization
        firstResponse.text = "Batman"
        secondResponse.text = "Aquaman"
        thirdResponse.text = "Thor"

        /*
         * Function to initialize a message toast
         * @parametre message : String
         * @return toast
         */
        fun toastMaker (message: String) {
            val duration = Toast.LENGTH_LONG
            var toast = Toast.makeText(applicationContext, message, duration)
            return toast.show()
        }

        //Definition button action
        validateButton.setOnClickListener{
            //message initialization
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
