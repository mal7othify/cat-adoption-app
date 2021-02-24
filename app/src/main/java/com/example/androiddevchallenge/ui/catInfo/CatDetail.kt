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

import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.ScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.androiddevchallenge.model.data.Cats

@Composable
fun CatDetail(
    navController: NavController,
    catId: Int
) {
    val cat = Cats.find { it.id == catId }!!
    Column(modifier = Modifier.fillMaxSize()) {
        CatDetailHeader(cat, navController)
        Column {
            Text(
                text = cat.name,
                style = MaterialTheme.typography.h3,
                modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp)
            )
            Row(
                modifier = Modifier.padding(bottom = 20.dp)
                    .fillMaxWidth()
                    .scrollable(
                        enabled = true,
                        state = ScrollableState { 0.5f },
                        orientation = Orientation.Horizontal
                    )
            ) {
                CatDetailShips("Breed", cat.breed)
                CatDetailShips("Age", cat.age)
                CatDetailShips("Sex", cat.sex)
                CatDetailShips("Hair", cat.hair)
            }
            CatDetailFooter()
        }
    }
}
