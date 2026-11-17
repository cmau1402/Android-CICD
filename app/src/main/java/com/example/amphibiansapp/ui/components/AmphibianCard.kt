package com.example.amphibiansapp.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.amphibiansapp.data.Amphibian

@Composable
fun AmphibianCard(
    amphibian: Amphibian
) {
    var expanded by remember {
        mutableStateOf(false)
    }
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                expanded = !expanded
            }
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = amphibian.name
            )
            Text(
                text = amphibian.type
            )
            Spacer(
                modifier = Modifier.height(8.dp)
            )
            AsyncImage(
                model = amphibian.img_src,
                contentDescription = amphibian.name,
                modifier = Modifier.fillMaxWidth()
            )
            if (expanded) {
                Spacer(
                    modifier = Modifier.height(8.dp)
                )
                Text(
                    text = amphibian.description
                )
            }
        }
    }
}