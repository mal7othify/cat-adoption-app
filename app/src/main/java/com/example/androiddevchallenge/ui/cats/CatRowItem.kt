/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.androiddevchallenge.ui.cats

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.model.Cat

@Composable
fun CatRowItem(
    cat: Cat,
    onItemClicked: (cat: Cat) -> Unit
) {
    Card(
        modifier = Modifier.padding(PaddingValues(8.dp))
            .fillMaxWidth()
            .clickable(onClick = { onItemClicked(cat) }),
        shape = MaterialTheme.shapes.medium,
        elevation = 15.dp,
        backgroundColor = MaterialTheme.colors.primary
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = cat.imageRes),
                contentDescription = "Picture of ${cat.name}",
                modifier = Modifier
                    .height(150.dp)
                    .width(150.dp)
                    .padding(PaddingValues(end = 10.dp)),
                contentScale = ContentScale.Crop,
            )
            Column(Modifier.padding(PaddingValues(end = 5.dp))) {
                Text(
                    text = cat.name,
                    style = MaterialTheme.typography.h2,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(text = cat.breed, modifier = Modifier.padding(bottom = 4.dp))
                Text(text = cat.age, style = MaterialTheme.typography.caption)
            }
        }
    }
}