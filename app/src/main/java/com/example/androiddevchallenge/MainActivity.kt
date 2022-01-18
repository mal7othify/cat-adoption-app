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
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.material.MaterialTheme.colors
import androidx.compose.ui.graphics.toArgb
import androidx.navigation.NavType
import androidx.navigation.compose.navArgument
import com.example.androiddevchallenge.model.data.Cats
import com.example.androiddevchallenge.navigation.Screen
import com.example.androiddevchallenge.ui.catInfo.CatDetail
import com.example.androiddevchallenge.ui.cats.AllCats
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

class MainActivity: ComponentActivity() {
    @OptIn(ExperimentalAnimationApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                window.statusBarColor = colors.primaryVariant.toArgb()
                val navController = rememberAnimatedNavController()

                val enterTransition = slideInHorizontally(
                    initialOffsetX = { 300 },
                    animationSpec = tween(300)
                ) + fadeIn(animationSpec = tween(300))

                val exitTransition = slideOutHorizontally(
                    targetOffsetX = { -300 },
                    animationSpec = tween(300)
                ) + fadeOut(animationSpec = tween(300))

                val initialPopEnterTransition = slideInHorizontally(
                    initialOffsetX = { -300 },
                    animationSpec = tween(300)
                ) + fadeIn(animationSpec = tween(300))

                val targetPopEnterTransition = slideOutHorizontally(
                    targetOffsetX = { 300 },
                    animationSpec = tween(300)
                ) + fadeOut(animationSpec = tween(300))

                AnimatedNavHost(navController, startDestination = Screen.AllCats.route) {
                    composable(
                        route = Screen.AllCats.route,
                        enterTransition = { initial, _ ->
                            when (initial.destination.route) {
                                Screen.CatDetail.route -> enterTransition
                                else -> null
                            }
                        },
                        exitTransition = { _, target ->
                            when (target.destination.route) {
                                Screen.CatDetail.route -> exitTransition
                                else -> null
                            }
                        },
                        popEnterTransition = { initial, _ ->
                            when (initial.destination.route) {
                                Screen.CatDetail.route -> initialPopEnterTransition
                                else -> null
                            }
                        }
                    ) { AllCats(Cats, navController) }
                    composable(
                        route = "${Screen.CatDetail.route}/{catId}",
                        arguments = listOf(navArgument("catId") { type = NavType.IntType }),
                        enterTransition = { initial, _ ->
                            when (initial.destination.route) {
                                Screen.AllCats.route -> enterTransition
                                else -> null
                            }
                        },
                        exitTransition = { _, target ->
                            when (target.destination.route) {
                                Screen.AllCats.route -> targetPopEnterTransition
                                else -> null
                            }
                        }
                    ) {
                        CatDetail(navController, it.arguments?.getInt("catId") ?: 1)
                    }
                }
            }
        }
    }
}
