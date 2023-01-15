package org.hyrical.fundamental.utility

object NumberUtils {
    fun isInteger(input: String): Boolean {
        return try {
            input.toInt()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }

    fun isShort(input: String): Boolean {
        return try {
            input.toShort()
            true
        } catch (e: NumberFormatException) {
            false
        }
    }
}