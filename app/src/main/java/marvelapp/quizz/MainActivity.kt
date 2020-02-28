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


    // instantiation Flashcard

    var batman = Flashcard("Qui est-ce personnage de Marvel ?", "batman_small", "batman", mutableListOf("Batman", "Groot", "Robin"), "Batman")

    var catwoman = Flashcard("De qui s'agit-il ? ", "batman_small", "batman", mutableListOf("Jessica Jones","Catwoman", "America Chavez"), "Catwoman")

    var blackPanther = Flashcard("Mais qui est-ce personnage ?", "batman_small", "batman", mutableListOf("Black Panther", "Le fauve", "Drax"), "Black Panther")

    var wolverine = Flashcard("Qui est ce superheroe ? ", "batman_small", "batman", mutableListOf("Colossus", "Drax", "Wolverine"), "Wolverine")


    // List of Flashcard object

    var marvels = mutableListOf<Flashcard>(batman, catwoman,blackPanther,wolverine)

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


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        //call shuffle method to have a random marvel flashcard
       // marvels.shuffle()


        //initialization flashcard
        var i = 0

        questionText.text = marvels.elementAt(i).question

        //Text Button Radio initialization
        var radiobuttonlist = marvels.elementAt(i).responses

        //Call shuffle method to have random result
        radiobuttonlist.shuffle()

        for (response in radiobuttonlist){

            println("${response}")

            var radioButton = RadioButton(this)
            radioButton.text = response
            radioGroup.addView(radioButton)
        }



        for(marvel in marvels){

            println(" avant :  ${i} ")

            validateButton.setOnClickListener{

                validateButton.text = "Valider"


                    if (i  < marvels.count()){

                        //answer verification
                        validateButton.setOnClickListener{
                            //initialization message toast
                            var message = "Réponse :"
                            //I will check in the radioGroup if a radio button has been checked
                            val checkedRadioButtonId = radioGroup.checkedRadioButtonId
                            val selectedRadioButton = radioGroup.findViewById<RadioButton>(checkedRadioButtonId)

                            // If none is checked it returns -1
                            // If it is checked I compared the value to the right answer

                            if (selectedRadioButton.text ==  marvels.elementAt(i).good_response) {

                                message += " Bravo !!! La bonne réponse est bien ${marvels.elementAt(i).good_response} !!!"
                                toastMaker(message)

                                //Transform the button
                                validateButton.text = "Question suivante"

                                i++

                                println(" après :  ${i} ")


                            } else {
                                message += " Dommage :( La bonne réponse est ${marvels.elementAt(i).good_response}"
                                toastMaker(message)
                        }

                    }

                }

            }

        }



        // text field initialization
       // questionText.text = first.question

        //Set a view full on click to the image view

           // quizzImage.setOnClickListener{
              //  println("click !!!")
               // quizzImage.setImageResource(R.drawable.batman_small)


           // }

        //Initialization data
       // var responses = first.responses
        //Call shuffle method to have random result
       // responses.shuffle()

       // for (response in responses){

         //   var radioButton = RadioButton(this)
           // radioButton.text = response
         //   radioGroup.addView(radioButton)

       // }

          //Definition button action
            //  validateButton.setOnClickListener{
            //message initialization
            //  var message = "Réponse :"
              //I will check in the radioGroup if a radio button has been checked
             // val checkedRadioButtonId = radioGroup.checkedRadioButtonId
             // val selectedRadioButton = radioGroup.findViewById<RadioButton>(checkedRadioButtonId)

              // If none is checked it returns -1
              //If it is checked I compared the value to the right answer
            //  if (selectedRadioButton.text ==  first.good_response) {
             //   message += " Bravo !!! La bonne réponse est bien Batman !!!"
             //   toastMaker(message)
              //Transform the button
              //  validateButton.text = "Question suivante"
               // questionText.text = second.question



              //} else {
               // message += " Dommage :( La bonne réponse est Batman"
               // toastMaker(message)
             // }

      // }

    }
}
