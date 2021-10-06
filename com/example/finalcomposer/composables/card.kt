package com.example.finalcomposer.composables

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.LightGray
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.finalcomposer.R
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun Cardview() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clickable {
                Log.i("CardActivity", "U click on a Card")
            },
        elevation = 10.dp
    ) {
        Column(
            modifier = Modifier.padding(15.dp)
        ) {
            Text(
                buildAnnotatedString {
                    append("welcome to ")
                    withStyle(
                        style = SpanStyle(fontWeight = FontWeight.W900, color = Color(0xFF4552B8))
                    ) {
                        append("Jetpack Compose Playground")
                    }
                }
            )
            Text(
                buildAnnotatedString {
                    append("Now you are in the ")
                    withStyle(style = SpanStyle(fontWeight = FontWeight.W900)) {
                        append("Card")
                    }
                    append(" section")
                }
            )
        }
    }
}

@Composable
fun text(value: String) {
    Text(
        text = value,
        modifier = Modifier.padding(20.dp),
        style = MaterialTheme.typography.body1,
        textAlign = TextAlign.Center
    )
}

@ExperimentalCoilApi
@Composable
fun Cardviewimage() {
    Card(modifier = Modifier
        .padding(15.dp)
        .fillMaxWidth()
        .height(200.dp)
        .clickable {
            Log.i("CardActivity", "U click on a Card with Image")
        }
        .border(width = 2.dp, color = Color.Cyan)) {
        Row(
            modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically
        ) {
            val image =
                rememberImagePainter("https://www.thecocktaildb.com/images/ingredients/gin-Small.png")
            Image(
                painter = image,
                contentDescription = "null",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(5.dp)
                    .fillMaxHeight()
                    .width(120.dp)
                    .border(2.dp, color = Color.Black)
            )
            Column(
                modifier = Modifier.padding(10.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Text(text = "Heading", style = MaterialTheme.typography.h3)
                Text(text = "Description", style = MaterialTheme.typography.body1)
                text(value = "No mention")
            }
        }
    }
}

@Composable
fun Imageloader() {

    Box(
        modifier = Modifier
            .padding(5.dp)
            .height(250.dp)
            .width(250.dp),
        contentAlignment = Alignment.Center
    ) {
        val imageUrl = "https://www.thecocktaildb.com/images/ingredients/gin-Small.png"
        GlideImage(
            imageModel = imageUrl,
            // Crop, Fit, Inside, FillHeight, FillWidth, None
            contentScale = ContentScale.Fit,
            // shows an image with a circular revealed animation.
            circularReveal = CircularReveal(duration = 250),
            // shows a placeholder ImageBitmap when loading.
            placeHolder = ImageBitmap.imageResource(R.drawable.placeholder),
            // shows an error ImageBitmap when the request failed.
            error = ImageBitmap.imageResource(R.drawable.error),

            )
    }
}