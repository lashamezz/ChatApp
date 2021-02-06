package com.example.chatify.Fragments

import android.content.Intent.getIntent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.chatify.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class FragmentProfile:Fragment(R.layout.fragment_profile) {


    private lateinit var firebaseUser: FirebaseUser
    private lateinit var welcomeText: TextView
    private lateinit var navController : NavController
    private lateinit var chatsButton: Button


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        firebaseUser = FirebaseAuth.getInstance().currentUser!!

        navController = Navigation.findNavController(view)
        chatsButton = view.findViewById(R.id.profileToChatsButton)
        welcomeText = view.findViewById(R.id.welcomeText)

        chatsButton.setOnClickListener{


            navController.navigate(R.id.action_navigation_profile_to_navigation_messages)

        }


        welcomeText.text = "Welcome Back \n  ${firebaseUser.email} \n proceed to messages by clicking button below"

    }
}