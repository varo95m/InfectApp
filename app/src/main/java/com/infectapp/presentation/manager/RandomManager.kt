package com.infectapp.presentation.manager

import com.infectapp.domain.*
import kotlin.random.Random

/**
 * <p>
 * Copyright (c) 2019, InfectApp Inc. All rights reserved.
 * </p>
 *
 * @author <a href=“mailto:alvaro.montero@babel.es”>Alvaro Montero</a>
 *
 * Date: 2019-12-24
 */

class RandomManager {
    fun generateRandomNumberOrDigit(): String {
        var inviteCode: String = STRING_EMPTY

        for (num in INT_ZERO..INT_FOUR) {
            inviteCode += when (Random.nextInt(INT_THREE)) {
                INT_ZERO -> Random.nextInt(INT_NINE)
                INT_ONE -> Random.nextInt(
                    INT_SIX_FIVE,
                    INT_NINE_ONE
                ).toChar()
                INT_TWO -> Random.nextInt(
                    INT_NINE_SEVEN,
                    INT_ONE_TWO_THREE
                ).toChar()
                else -> INT_ZERO
            }
        }
        return inviteCode
    }
}