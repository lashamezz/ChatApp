package com.example.chatify.Fragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.chatify.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class FragmentProfile:Fragment(R.layout.fragment_profile) {


    private lateinit var firebaseUser: FirebaseUser
    private lateinit var welcomeText: TextView

    private lateinit var chatsButton: Button


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firebaseUser = FirebaseAuth.getInstance().currentUser!!

        chatsButton = view.findViewById(R.id.profileToChatsButton)
        welcomeText = view.findViewById(R.id.welcomeText)

        welcomeText.text = firebaseUser.displayName


    }
}