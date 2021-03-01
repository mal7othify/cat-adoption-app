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
package com.example.androiddevchallenge.ui.catInfo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androiddevchallenge.model.Cat

@Composable
fun CatDetailHeader(cat: Cat, navController: NavController) {
    val starred = remember { mutableStateOf(Color.DarkGray) }
    Box {
        Image(
            painter = painterResource(id = cat.imageRes),
            contentDescription = null,
            modifier = Modifier
                .height(500.dp)
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(PaddingValues(bottom = 10.dp)),
            contentScale = ContentScale.Crop,
        )
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
                .background(Color(0xB3c5cae9))
        ) {
            Icon(
                imageVector = Icons.Rounded.ArrowBack,
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.Bottom)
                    .size(24.dp, 24.dp)
                    .clickable {
                        navController.navigateUp()
                    },
                tint = Color.DarkGray
            )
            Text(
                text = "${cat.name} Info",
                modifier = Modifier.align(Alignment.CenterVertically),
                style = MaterialTheme.typography.h1,
                color = Color.DarkGray
            )
            Icon(
                imageVector = Icons.Rounded.Star,
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .align(Alignment.Bottom)
                    .size(24.dp, 24.dp)
                    .clickable {
                        starred.value = Color.Yellow
                    },
                tint = starred.value
            )
        }
    }
}
