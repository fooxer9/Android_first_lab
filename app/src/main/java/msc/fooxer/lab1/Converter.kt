package msc.fooxer.lab1

import java.lang.IllegalArgumentException
import java.lang.StringBuilder

class Converter {
    fun numInWord(x: Int): String {
        var x = x

        if (x == 1000000) {
            return "миллион"
        }
        val ansBuilder = StringBuilder()
        if (x / 1000 > 0) {
            ansBuilder.append(getNumberFrom1to999(x / 1000, true))
            ansBuilder.append(" ")
            ansBuilder.append(getFormOf1000(x / 1000))
            ansBuilder.append(" ")
        }
        x %=  1000
        if (x > 0) {
            ansBuilder.append(getNumberFrom1to999(x, false))
        }
        return ansBuilder.toString().trim { it <= ' ' }
    }

    private fun getFormOf1000(numberOf1000: Int): String {
        if (numberOf1000 < 1 || numberOf1000 > 999)
            throw IllegalArgumentException("numberOf1000 should be from 1 to 999\n"
                    + numberOf1000 + " found\n")
        if ((5 <= numberOf1000 % 100) && (numberOf1000 % 100 <= 20))
            return "тысяч"
        if (numberOf1000 % 10 == 1)
            return "тысяча"
        return if ((2 <= numberOf1000 % 10) && (numberOf1000 % 10 <= 4)) {
            "тысячи"
        } else "тысяч"
    }

    private fun getFormFor1to9(x: Int, is_female: Boolean): String {
        when (x) {
            1 -> return if (is_female) "одна" else "один"
            2 -> return if (is_female) "две" else "два"
            3 -> return "три"
            4 -> return "четыре"
            5 -> return "пять"
            6 -> return "шесть"
            7 -> return "семь"
            8 -> return "восемь"
            9 -> return "девять"
            else -> throw IllegalArgumentException("getFormFor1to9 expects number from 1 to 9\n"
                    + x + " found\n")
        }
    }

    private fun getFormFor10to19(x: Int): String {
        when (x) {
            10 -> return "десять"
            11 -> return "одиннадцать"
            12 -> return "двенадцать"
            13 -> return "тринадцать"
            14 -> return "четырнадцать"
            15 -> return "пятнадцать"
            16 -> return "шестнадцать"
            17 -> return "семнадцать"
            18 -> return "восемнадцать"
            19 -> return "девятнадцать"
            else -> throw IllegalArgumentException("getFormFor10to19 expects number from 10 to 19\n"
                    + x + " found\n")
        }
    }

    private fun getTensFrom2to9(x: Int): String {
        when (x) {
            2 -> return "двадцать"
            3 -> return "тридцать"
            4 -> return "сорок"
            5 -> return "пятьдесят"
            6 -> return "шестьдесят"
            7 -> return "семьдесят"
            8 -> return "восемьдесят"
            9 -> return "девяносто"
            else -> throw IllegalArgumentException("getTensFrom2to9 expects number from 2 to 9\n"
                    + x + " found\n")
        }
    }

    private fun getHundredsFrom1to9(x: Int): String {
        when (x) {
            1 -> return "сто"
            2 -> return "двести"
            3 -> return "триста"
            4 -> return "четыреста"
            5 -> return "пятьсот"
            6 -> return "шестьсот"
            7 -> return "семьсот"
            8 -> return "восемьсот"
            9 -> return "девятьсот"
            else -> throw IllegalArgumentException("getHundredsFrom1to9 expects number from 1 to 9\n"
                    + x + " found\n")
        }
    }

    private fun getNumberFrom1to999(x: Int, is_female: Boolean): String {
        var x = x
        val ansBuilder = StringBuilder()
        if (x / 100 > 0) {
            ansBuilder.append(getHundredsFrom1to9(x / 100))
            ansBuilder.append(" ")
        }
        x %= 100
        if ((10 <= x) && (x <= 19)) {
            ansBuilder.append(getFormFor10to19(x))
            return ansBuilder.toString()
        }
        if (x / 10 > 0) {
            ansBuilder.append(getTensFrom2to9(x / 10))
            ansBuilder.append(" ")
        }
        x = x % 10
        if (x > 0) {
            ansBuilder.append(getFormFor1to9(x, is_female))
        }
        return ansBuilder.toString().trim { it <= ' ' }
    }
}
