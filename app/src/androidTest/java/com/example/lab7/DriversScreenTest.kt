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
class DriversScreenTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun navigate_add_driver_clear_and_return_home() {
        // 从首页进入 Drivers 页面
        composeTestRule
            .onNodeWithTag("driversButton")
            .performClick()

        // 确认进入 Drivers 页面
        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()

        // 输入司机姓名
        composeTestRule
            .onNodeWithTag("driverInput")
            .performTextInput("Lewis Hamilton")

        // 添加司机，输入框随之清空
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // 确认司机出现在列表中
        composeTestRule
            .onNodeWithText("Lewis Hamilton")
            .assertExists()

        // 清空司机列表
        composeTestRule
            .onNodeWithTag("clearDriversButton")
            .performClick()

        // 确认司机已被移除
        composeTestRule
            .onNodeWithText("Lewis Hamilton")
            .assertDoesNotExist()

        // 返回首页
        composeTestRule
            .onNodeWithTag("driversBackButton")
            .performClick()

        // 确认返回首页
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}