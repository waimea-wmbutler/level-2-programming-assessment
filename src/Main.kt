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
 * like a dungeon in a door-door format. Two players will play separately and match coins and dungeon level.
 * Highest coin count and level wins.
 * =====================================================================
 */

// the main function should include the start of the game and have the game end.
// Build upon each room sector.
// Each room will be a different function linking to another function containing the different options at random.
// the rooms (Randomly selected amongst many) will be in part of a larger list.
// the list will be labeled by letters, E.g. A-Z or a-z

const val LEFT = 'L'
const val RIGHT = 'R'
var countCoin = 0
var countLevel =0
val roomType = (1..10).random()




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
        RIGHT -> {
            if (roomType == 1) {
                println("$roomType")
            }
        }
        LEFT -> {
            if (roomType == 6 || roomType == 4 ){
                println("")
            }
        }
    }
println("$roomType")
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

fun typeToPrompt () {
    while (true){
        roomType.toString()
        "1" == "You Found 5 Coins!"
        "2" == "The Room Is Empty!"
        "3" == "Ahh! A Goblin! He Stole 3 Coins!"
        "4" == "The Floor Opens Below You To Reveal A Lava Pit! This Is The End For You Adventurer"
        "5" == "This Room Is Filled With Furniture And Antiques, Gain 10 Coins"
        "6" == ""
        "7" == ""
        "8" == ""
        "9" == ""
        "10" == ""

    }
}

