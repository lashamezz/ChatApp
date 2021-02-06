package com.example.chatify.Fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.fragment.app.Fragment
import com.example.chatify.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.*

class FragmentMessages:Fragment(R.layout.fragment_messages) {


    private lateinit var chatbox: TextView
    private lateinit var sendButton: Button
    private lateinit var firebaseUser: FirebaseUser
    private lateinit var messageBox: TextView
    private lateinit var scrollviewBox1: ScrollView
    private lateinit var myDataBase: DatabaseReference
    private lateinit var username: String

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myDataBase = FirebaseDatabase.getInstance().getReference("Message")


        scrollviewBox1 = view.findViewById(R.id.scrollviewbox)
        firebaseUser = FirebaseAuth.getInstance().currentUser!!

        username = firebaseUser.email.toString()

        chatbox = view.findViewById(R.id.messagesBox)


        sendButton = view.findViewById(R.id.sendButton)
        messageBox = view.findViewById(R.id.messageEditText)

        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                chatbox.append(dataSnapshot.getValue().toString() + "\n")

            }

            override fun onCancelled(databaseError: DatabaseError) {
                chatbox.setText("cancelled")
            }
        }
        myDataBase.addValueEventListener(postListener)

        sendButton.setOnClickListener{
            myDataBase.child("").setValue(messageBox.getText().toString());
            messageBox.setText("")
        }

    }

}