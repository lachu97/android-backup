package com.example.finalcomposer

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import com.example.finalcomposer.composables.*
import com.example.finalcomposer.models.Food
import com.example.finalcomposer.models.data
import com.example.finalcomposer.models.meals
import com.example.finalcomposer.ui.theme.FinalcomposerTheme
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.request.*
import io.ktor.http.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    @ExperimentalCoilApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        val foods = buildlist()
        val data = builddata()
        CoroutineScope(IO).launch {
            fetchnetwork()
        }
        val title = listOf("No Number", "one number", "2 no", "3 Nomber","dhjflsdh","dohf","hsflh","sgfhlk")


        setContent {
            FinalcomposerTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android", data = data, title = title)
                }
            }
        }
    }
}

fun builddata(): List<data> {
    val data = listOf(
        data(
            1,
            "Hone",
            "some random thing",
            "https://www.thecocktaildb.com/images/ingredients/gin-Small.png"
        ),
        data(
            2,
            "Hoe right ",
            "some random thing",
            "https://www.thecocktaildb.com/images/ingredients/gin-Small.png"
        ),
        data(
            3,
            "Hitle",
            "some hitler thing",
            "https://www.thecocktaildb.com/images/ingredients/gin-Small.png"
        ),
        data(
            4,
            "stalin",
            "some storym thing",
            "https://www.thecocktaildb.com/images/ingredients/gin-Small.png"
        ),
        data(
            5,
            "Lenin",
            "some rawith respect thing",
            "https://www.thecocktaildb.com/images/ingredients/gin-Small.png"
        )

    )
    return data
}

suspend fun fetchnetwork() {
    val url="http://blacky.tech/mealsapi/meals.php"
    val Client=HttpClient{
        install(JsonFeature){
            serializer=GsonSerializer()
            accept(ContentType.Any)

        }
    }
//    val meals:List<meals>
    try {
        val meals:ArrayList<meals> =Client.get(url)
        Log.i("Mainactivity","Values in try is ${meals}")
    }catch (e:NoTransformationFoundException){
        Log.i("MainActivity","Value ${e.message}")
    }
//    val url = "http://blacky.tech/mealsapi/meals.php"
//    val ktorHttpClient = HttpClient {
//        install(JsonFeature) {
//            serializer = KotlinxSerializer()
//            accept(ContentType.Application.Json)
//        }
//    }
//    var meals: meals? = null
//    try {
//        meals = ktorHttpClient.get(url)
//    } catch (e: NoTransformationFoundException) {
//        var mealsString: List<meals> = ktorHttpClient.get(url)
//        val json = kotlinx.serialization.json.Json {
//            ignoreUnknownKeys = true
//        }
//        meals = json.decodeFromString(mealsString.toString())
//    } finally {
//        println("Meals: ${meals}")
//    }

//    val mylist:ArrayList<meals> = ktorHttpClient.get(url)
//        val response = ktorHttpClient.get<HttpResponse>("https://api.openbrewerydb.org/breweries")
//        Log.i("Coroutines", "Value from Networkis ${response.status} and ${response.content}")
//    Log.i("Coroutines", "Value from Networkis ${mylist}")
//    for (list in mylist) {
//        Log.i("Coroutines", "Value from Networkis ${list}")
//
//    }
}


fun buildlist(): List<Food> {
    val food = listOf(
        Food(1, "Rice", "ric", "A rice of some value"),
        Food(2, "Wheat", "wheat image", "A wheat has protein of some value"),
        Food(3, "Bajwa", "bajwa imagesc", "A bajwa has some micronutrients of some value"),
        Food(4, "Jowar", "jowar rice", "A jowar has some value of some value")


    )
    return food
}

@ExperimentalCoilApi
@Composable
fun Greeting(name: String, data: List<data>, title: List<String>) {
    FinalcomposerTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            text(value = "Cater23")
            rowlist(title = title)
            text(value = "Cater")
            Spacer(modifier = Modifier.padding(5.dp))
            verticalist(data = data)
        }

    }
}

@ExperimentalCoilApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    FinalcomposerTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            Cardview()
            Imageloader()
            Cardviewimage()
            Cardviewimage()
        }

    }
}