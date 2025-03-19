private infix fun String.or(s: String): Any {
    return 0
}

/**
 * =====================================================================
 * Programming Project for NCEA Level 2, Standard 91896
 * ---------------------------------------------------------------------
 * Project Name:   TO THE CENTER
 * Project Author: William Butler
 * GitHub Repo:    https://github.com/waimea-wmbutler/level-2-programming-assessment
 * ---------------------------------------------------------------------
 * Notes:
 * This is an adventure game where a certain thing will happen with each different choice.
 * like a dungeon in a door-door format. Two players will play separately and match coins and dungeon level
 * =====================================================================
 */

// the main function should include the start of the game and have the game end.
// Build upon each room sector.
// Each room will be a different function linking to another function containing the different options at random.
// the rooms (Randomly selected amongst many) will be in part of a larger list.
// the list will be labeled by letters, E.g. A-Z or a-z

const val LEFT = 'L'
const val RIGHT = 'R'
var count = 0

val roomType= ("This Room is Empty")




fun main () {
    while (true) {
            println("---------------------------------------")
            println("         ---To The Center---")
            println("---------------------------------------")
            println()
            println(" Welcome Adventurer! To The Dungeon!")
            println("Please Select L For Left, Or R For Right Door")
            break
    }

    var firstDoor = 'X'
    while (firstDoor != 'L' && firstDoor != 'R') {
        firstDoor = getLeftOrRight("Enter Left Or Right Door: ")
    }

    when (firstDoor) {
        'R' -> {
            println("$roomType")
        }
        'L' -> {
            println("$roomType")
        }
    }

}

fun getLeftOrRight (prompt: String): Char {
    print(prompt)
    var userInput: String
    while (true){
        userInput = readln()
        if (userInput.isNotBlank()) break
    }
    return userInput.uppercase().first()
}
fun roomToInt (): String {
    roomType.toInt(1..10)
    return roomType
}

