package com.example.lab7

import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FormulaZeroTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun navigate_to_races_add_race_and_return_home() {
        // 点击首页的比赛按钮
        composeTestRule
            .onNodeWithTag("raceButton")
            .performClick()

        // 检查已经进入比赛页面
        composeTestRule
            .onNodeWithText("Upcoming Races")
            .assertExists()

        // 输入比赛地点
        composeTestRule
            .onNodeWithTag("locationInput")
            .performTextInput("Canada")

        // 点击 Add
        composeTestRule
            .onNodeWithTag("addRaceButton")
            .performClick()

        // 检查列表中出现 Canada
        composeTestRule
            .onNodeWithText("Canada")
            .assertExists()

        // 点击 Back
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // 检查已经返回首页
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}