package com.example.testsapp.viewmodels

import android.provider.ContactsContract.Data
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.testsapp.models.Test
import com.example.testsapp.sealed.DataState
import com.example.testsapp.singletone.SingletoneFirebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener

class MainViewModel: ViewModel() {
    private val database = SingletoneFirebase.instance.database

    val _response: MutableState<DataState> = mutableStateOf(DataState.Empty)
    var response: MutableState<DataState> = _response

    private var _tests = mutableStateOf<MutableList<Test>>(mutableListOf())
    val tests: State<MutableList<Test>> = _tests


    fun getTests(){
        val tempList = mutableStateListOf<Test>()
        _response.value = DataState.Loading
        database.getReference("Tests")
            .addValueEventListener(object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    for (DataSnap in snapshot.children){
                        val test = DataSnap.getValue(Test::class.java)
                        if (test != null){
                            tempList.add(test)
                        }
                    }
                    _tests.value = tempList
                    _response.value = DataState.Success
                }

                override fun onCancelled(error: DatabaseError) {
                    _response.value = DataState.Failure
                }

            })
    }
}