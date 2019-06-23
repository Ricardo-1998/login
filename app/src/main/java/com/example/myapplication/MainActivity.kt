package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val firebaseAuth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        bt_signin.setOnClickListener{
            progressBar.visibility = View.VISIBLE

            firebaseAuth.createUserWithEmailAndPassword(et_email.text.toString(),
                et_pass.text.toString())
                .addOnCompleteListener{
                    progressBar.visibility = View.GONE
                    if(it.isSuccessful){
                        Toast.makeText(this,"Registered succesful",Toast.LENGTH_SHORT).show()
                        et_email.setText("")
                        et_pass.setText("")
                    }else{
                        Toast.makeText(this,it.exception?.message.toString(),Toast.LENGTH_SHORT).show()
                    }
                }

        }
    }
    //https://www.youtube.com/watch?v=KFULmVXpO-A



}
