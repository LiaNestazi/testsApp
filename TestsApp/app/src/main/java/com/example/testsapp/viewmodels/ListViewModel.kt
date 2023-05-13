package com.example.testsapp.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.testsapp.models.Test
import com.example.testsapp.sealed.DataState
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class ListViewModel : ViewModel() {

    val response: MutableState<DataState> = mutableStateOf(DataState.Empty)

    init {
        fetchDataFromFirebase()
    }

    private fun fetchDataFromFirebase() {
        val tempList = mutableStateListOf<Test>()
        response.value = DataState.Loading
        Log.d("MyTag", "Loading")
        Firebase
            .database("https://testsapp-5092c-default-rtdb.europe-west1.firebasedatabase.app/")
            .getReference("Tests")
            .addValueEventListener(object: ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (DataSnap in snapshot.children){
                        val test = DataSnap.getValue(Test::class.java)
                        if (test != null){
                            tempList.add(test)
                        }
                    }
                    Log.d("MyTag", "Success")
                    response.value = DataState.Success
                }

                override fun onCancelled(error: DatabaseError) {
                    Log.d("MyTag", "Failure")
                    response.value = DataState.Failure
                }

            })
    }
}