package com.example.finalcomposer.composables

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.finalcomposer.models.data
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun verticalist(data: List<data>) {
    LazyColumn(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxSize()
            .border(1.dp, color = Color.DarkGray)
    ) {
        itemsIndexed(items = data) { index, item ->
            customcard(data = item, onclick = { Log.i("Clickable","mseeg ${index} and clicked value" +
                    "=${item}")})
        }
    }
}

@Composable
fun customcard(data: data, onclick: () -> Unit) {
    Card(
        shape = MaterialTheme.shapes.small, modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .height(150.dp)
            .clickable(onClick = onclick)
            .border(1.dp, color = Color.DarkGray),
        elevation = 5.dp
    ) {
        Row(
            modifier = Modifier.fillMaxSize(), verticalAlignment = Alignment.CenterVertically
        ) {
            data.image.let {
              Surface(elevation = 5.dp,border = BorderStroke(1.dp,color = Color.Black)) {
                  CoilImage(imageModel = it,modifier = Modifier.width(160.dp).fillMaxHeight().padding(10.dp),contentScale = ContentScale.Crop, shimmerParams = ShimmerParams(
                      baseColor = MaterialTheme.colors.background,
                      highlightColor = Color.LightGray,
                      durationMillis = 350,
                      dropOff = 0.65f,
                      tilt = 20f
                  ),
                      // shows an error text message when request failed.
                      failure = {
                          Text(text = "image request failed.")
                      })
                }

            }
            Column(
                modifier = Modifier.padding(1.dp),
                horizontalAlignment = Alignment.Start
            ) {
                data.title.let {
                    Text(text = it, style = MaterialTheme.typography.h3)
                }
                data.desc.let {
                    Text(text = it, style = MaterialTheme.typography.body2)
                }
            }
        }
    }
}