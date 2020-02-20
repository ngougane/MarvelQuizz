package marvelapp.quizz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
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

        //

    }
}
