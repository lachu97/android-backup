package com.example.finalcomposer.composables

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun rowlist(title: List<String>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.height(54.dp).fillMaxWidth().padding(5.dp)
    ) {
        itemsIndexed(items = title) { index, item ->
            chips(title = item, onclick = { Log.i("Click","message on click fucntion ${item} and " +
                    "${index}")})
        }
    }
}

@Composable
fun chips(title: String, onclick: () -> Unit) {
    Surface(
        elevation = 8.dp, modifier = Modifier
            .padding(5.dp)
            .border(1.dp, color = Color.Black)
            .fillMaxSize(), shape = MaterialTheme.shapes.medium
    ) {
        Row(
            modifier = Modifier
                .padding(2.dp)
                .clickable(onClick = onclick)
        ) {
            Text(text = title, style = MaterialTheme.typography.body1)
        }
    }
}