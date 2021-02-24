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

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Phone
import androidx.compose.material.icons.rounded.Textsms
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.ui.theme.shapes

@Composable
fun CatDetailFooter() {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Rounded.Phone,
            contentDescription = null,
            tint = MaterialTheme.colors.primary,
            modifier = Modifier
                .padding(8.dp)
                .size(35.dp, 35.dp)
                .clickable {}
        )
        Icon(
            imageVector = Icons.Rounded.Textsms,
            contentDescription = null,
            tint = MaterialTheme.colors.primary,
            modifier = Modifier
                .padding(8.dp)
                .size(35.dp, 35.dp)
                .clickable {}
        )
        Button(
            modifier = Modifier.requiredWidth(280.dp)
                .padding(8.dp),
            shape = shapes.small,
            onClick = {}
        ) {
            Text(
                "Adopt me",
                style = MaterialTheme.typography.body1,
                color = Color.White
            )
        }
    }
}