package com.example.insta_demo


//import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.insta_demo.databinding.ActivityFeedBinding
import com.example.insta_demo.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var auth : FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view =  binding.root
        setContentView(view)

        auth = Firebase.auth
    }

    fun signInClick(view: View){
        val email = binding.emailText.text.toString()
        val password = binding.passwordText.text.toString()

        if(email.equals("") || password.equals("")){
            Toast.makeText(this, "Enter email or password!", Toast.LENGTH_LONG).show()
        } else{
            auth.signInWithEmailAndPassword(email,password).addOnSuccessListener{
                val intent = Intent(this@MainActivity,FeedActivity::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener {
                Toast.makeText(this@MainActivity,it.localizedMessage,Toast.LENGTH_LONG).show()
            }

        }

    }

    fun signUpClick(view : View){
        val email = binding.emailText.text.toString()
        val password = binding.passwordText.text.toString()

        if(email.equals("") || password.equals("")){
            Toast.makeText(this, "Enter email or password!", Toast.LENGTH_LONG).show()
        } else{
            auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener{
                val intent = Intent(this@MainActivity,FeedActivity::class.java)
                startActivity(intent)
                finish()
            }.addOnFailureListener {
                Toast.makeText(this@MainActivity,it.localizedMessage,Toast.LENGTH_LONG).show()
            }

        }
    }
}