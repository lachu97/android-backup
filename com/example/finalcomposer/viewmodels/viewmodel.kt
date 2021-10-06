package com.example.finalcomposer.viewmodels

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalcomposer.models.meals
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.launch

class netviewmodel:ViewModel() {
    private val _food= MutableLiveData<List<meals>>()
    val foodstate:LiveData<List<meals>> get() = _food
    val newfoods: MutableState<List<meals>> = mutableStateOf(listOf())

        val url="http://blacky.tech/mealsapi/meals.php"
        val Client= HttpClient{
            install(JsonFeature){
                serializer= GsonSerializer()
                accept(ContentType.Any)

            }
        }
    init {
        viewModelScope.launch {
            try {
                val meals:ArrayList<meals> =Client.get(url)
                Log.i("Mainactivity","Values in try is ${meals}")
                newfoods.value=meals
            }catch (e: NoTransformationFoundException){
                Log.i("MainActivity","Value ${e.message}")
            }

        }
    }

}