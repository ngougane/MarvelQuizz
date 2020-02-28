package marvelapp.quizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // text field initialization
        questionText.text = "Qui est-ce personnage Marvel ?"

        //Set a view full on click to the image view

            quizzImage.setOnClickListener{
                println("click !!!")
                quizzImage.setImageResource(R.drawable.batman)

            }


         //Text Button Radio initialization
        //Initialization data
        var responses = mutableListOf("Batman", "Aquaman", "Superman")
        //Call shuffle method to have random result
        responses.shuffle()

        for (response in responses){

            var radioButton = RadioButton(this)
            radioButton.text = response
            radioGroup.addView(radioButton)

        }


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
              //I will check in the radioGroup if a radio button has been checked
              val checkedRadioButtonId = radioGroup.checkedRadioButtonId
              val selectedRadioButton = radioGroup.findViewById<RadioButton>(checkedRadioButtonId)

              // If none is checked it returns -1
              //If it is checked I compared the value to the right answer
              if (selectedRadioButton.text ==  "Batman") {
                message += " Bravo !!! La bonne réponse est bien Batman !!!"
                toastMaker(message)
            } else {
                message += " Dommage :( La bonne réponse est Batman"
                toastMaker(message)
              }

       }

    }
}
