package org.hyrical.fundamental.utility

import org.bukkit.ChatColor

object CC {

    val BLUE = ChatColor.BLUE.toString()
    val AQUA = ChatColor.AQUA.toString()
    val YELLOW = ChatColor.YELLOW.toString()
    val RED = ChatColor.RED.toString()
    val GRAY = ChatColor.GRAY.toString()
    val GOLD = ChatColor.GOLD.toString()
    val GREEN = ChatColor.GREEN.toString()
    val WHITE = ChatColor.WHITE.toString()
    val BLACK = ChatColor.BLACK.toString()
    val BOLD = ChatColor.BOLD.toString()
    val ITALIC = ChatColor.ITALIC.toString()
    val STRIKE_THROUGH = ChatColor.STRIKETHROUGH.toString()
    val RESET = ChatColor.RESET.toString()
    val MAGIC = ChatColor.MAGIC.toString()
    val OBFUSCATED = MAGIC
    val B = BOLD
    val M = MAGIC
    val O = MAGIC
    val I = ITALIC
    val S = STRIKE_THROUGH
    val R = RESET
    val DARK_BLUE = ChatColor.DARK_BLUE.toString()
    val DARK_AQUA = ChatColor.DARK_AQUA.toString()
    val DARK_GRAY = ChatColor.DARK_GRAY.toString()
    val DARK_GREEN = ChatColor.DARK_GREEN.toString()
    val DARK_PURPLE = ChatColor.DARK_PURPLE.toString()
    val DARK_RED = ChatColor.DARK_RED.toString()
    val D_BLUE = DARK_BLUE
    val D_AQUA = DARK_AQUA
    val D_GRAY = DARK_GRAY
    val D_GREEN = DARK_GREEN
    val D_PURPLE = DARK_PURPLE
    val D_RED = DARK_RED
    val LIGHT_PURPLE = ChatColor.LIGHT_PURPLE.toString()
    val L_PURPLE = LIGHT_PURPLE
    val PINK = L_PURPLE
    val B_BLUE = BLUE + B
    val B_AQUA = AQUA + B
    val B_YELLOW = YELLOW + B
    val B_RED = RED + B
    val B_GRAY = GRAY + B
    val B_GOLD = GOLD + B
    val B_GREEN = GREEN + B
    val B_WHITE = WHITE + B
    val B_BLACK = BLACK + B
    val BD_BLUE = D_BLUE + B
    val BD_AQUA = D_AQUA + B
    val BD_GRAY = D_GRAY + B
    val BD_GREEN = D_GREEN + B
    val BD_PURPLE = D_PURPLE + B
    val BD_RED = D_RED + B
    val BL_PURPLE = L_PURPLE + B
    val I_BLUE = BLUE + I
    val I_AQUA = AQUA + I
    val I_YELLOW = YELLOW + I
    val I_RED = RED + I
    val I_GRAY = GRAY + I
    val I_GOLD = GOLD + I
    val I_GREEN = GREEN + I
    val I_WHITE = WHITE + I
    val I_BLACK = BLACK + I
    val ID_RED = D_RED + I
    val ID_BLUE = D_BLUE + I
    val ID_AQUA = D_AQUA + I
    val ID_GRAY = D_GRAY + I
    val ID_GREEN = D_GREEN + I
    val ID_PURPLE = D_PURPLE + I
    val IL_PURPLE = L_PURPLE + I
    const val BLANK_LINE = "§8 §8 §1 §3 §3 §7 §8 §r"
    const val BL = BLANK_LINE
    val SB_BAR = GRAY + S + "-------------------"

    fun translate(string: String): String {
        return ChatColor.translateAlternateColorCodes('&', string)
    }
}