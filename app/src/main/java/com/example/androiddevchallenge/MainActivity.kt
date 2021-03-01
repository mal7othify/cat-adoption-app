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
package com.example.androiddevchallenge

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import com.example.androiddevchallenge.model.data.Cats
import com.example.androiddevchallenge.navigation.Screen
import com.example.androiddevchallenge.ui.catInfo.CatDetail
import com.example.androiddevchallenge.ui.cats.AllCats
import com.example.androiddevchallenge.ui.theme.MyTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                window.statusBarColor = colors.primaryVariant.toArgb()
                val navController = rememberNavController()
                NavHost(navController, startDestination = Screen.AllCats.route) {
                    composable(Screen.AllCats.route) { AllCats(Cats, navController) }
                    composable(
                        "${Screen.CatDetail.route}/{catId}",
                        arguments = listOf(navArgument("catId") { type = NavType.IntType })
                    ) {
                        CatDetail(navController, it.arguments?.getInt("catId") ?: 1)
                    }
                }
            }
        }
    }
}
