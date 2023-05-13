package com.example.testsapp.singletone

import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.example.testsapp.models.Test
import com.example.testsapp.models.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SingletoneFirebase private constructor(){
    companion object {
        val instance = SingletoneFirebase()
    }
    val database = Firebase.database("https://testsapp-5092c-default-rtdb.europe-west1.firebasedatabase.app/")
    val auth = FirebaseAuth.getInstance()
    val testsReference = database.getReference("Tests")
    private var testsList = mutableListOf<Test>()

    fun addTestToDB(test: Test): Boolean{
        val id = testsReference.push().key
        if (id != null) {
            Log.d("MyTag",id)
            test.id = id
            testsReference.child(id).setValue(test)
            return true
        }
        return false
    }
    fun setTestsList(list: MutableList<Test>){
        this.testsList = list
    }
    fun getTestsList(): MutableList<Test>{
        return testsList
    }

}