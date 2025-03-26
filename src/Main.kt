@file:Suppress("KotlinConstantConditions")

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


// Left Or Right Door Choices
const val LEFT = 'L'
const val RIGHT = 'R'
// The Amount Of Coins Collected
var countCoin = 0
// The Amount Of Levels Travelled In The Dungeon
var countLevel = 0
// The Amount Of Stuff You Carry
var countStuff = 1
// The Amount Of Relics you Find
var countRelic = 0
// How Many Other Adventurers The Find
var countFriend = 0

fun main () {

    // Setting A List For The Room Types To Be Held Into So That We Can Grab Them By An Int (Index)
    val roomType = mutableListOf<String>()
    roomType.add("You Found 5 Coins!")
    roomType.add("The Room Is Empty!")
    roomType.add("Ahh! A Goblin! He Stole 10 Coins!")
    roomType.add("The Floor Opens Below You To Reveal A Lava Pit! \nThis Is The End For You Adventurer!")
    roomType.add("This Room Is Filled With Furniture And Antiques, Gain 5 Stuff!")
    roomType.add("The Room Has a Big Bad In It! \nDrop All Your Coins!")
    roomType.add("The Room Is Empty!")
    roomType.add("A Sign In The Center Of The Room States: 'Dont Look Down!' \nThe Floor Turns Into A Thin Bridge! Lose 3 Coins!")
    roomType.add("'The Room Is Empty?! What's Going On Here?' \nAn Axe Flies Into You! \nThis Is The End For You Adventurer!")
    roomType.add("A Sack Of Coins Fall In The Room, Spilling On The Floor. \nYou Grab As Many As You Can. You Collect 8 Coins!")
    roomType.add("You Found A Skeleton! ~Shiver~")
    roomType.add("The Room Is Empty!")
    roomType.add("You Found A Dragon Egg?!? You Gain 5 Relics")
    roomType.add("You Found A Ancient Relic! \nYou Gain 1 Relic")
    roomType.add("The Room Is Empty!")
    roomType.add("You Found Some Better Gear! \nDouble Your Stuff!")
    roomType.add("The Room Has A Huge Pile Of Gold! \nGrab As Much As You Can! Gain 50 Coins!!")
    roomType.add("You Found Another Adventurer! 'Fancy Seeing You Here!' \n Nothing Else Happens")
    roomType.add("A Trade Merchant? In This Dungeon? \nYou Sell Some Stuff For Coins!")
    roomType.add("'AHHHHHHHH!!!!!!! \nGIANT SPIDER!!!!!!! \nAHHHHHHHHHHHHHH!!!!!!!!!!'")
    roomType.add("You Found 5 Coins!")

    intro() // Intro To The Game

    while (true) {
        println()
        println("Please Select L For Left Door, Or R For Right Door ")

        var door = 'X' // Variable To Set The firstDoor Against L And R
        while (door != LEFT && door != RIGHT) {
            door = getLeftOrRight()
        }
        // What's inside the room
        val roomNum = (0 ..< roomType.size).random()

        when (door) { // After Getting The Option From The Player, Following These Rules To Show Inside The Room

            RIGHT -> {
                Thread.sleep(750)
                println (roomType[roomNum] )
                Thread.sleep(500)
            }
            LEFT -> {
                Thread.sleep(750)
                println ( roomType[roomNum] )
                Thread.sleep(500)
            }
        }

        countLevel++

        // Check roomNum To See What Has Happened
        when (roomNum) {
            0 -> countCoin += 5
            1 -> continue
            2 -> countCoin -= 10
            3 -> break
            4 -> countStuff += 5
            5 -> if (countCoin >= 0){ countCoin = 0 }
                 else {continue}
            6 -> continue
            7 -> countCoin -=3
            8 -> break
            9 -> countCoin += 8
            10 -> continue
            11 -> continue
            12 -> countRelic += 5
            13 -> countRelic += 1
            14 -> continue
            15 -> countStuff *= 2
            16 -> countCoin += 50
            17 -> countFriend ++
            18 -> {
                    if (countStuff >= 4) {
                        countStuff -= 4
                        countCoin += 10
                    }
                    if (countRelic >= 2 ){
                        countRelic -= 2
                        countCoin += 10
                    }
                    else{
                    continue
                    }
            }
            19 -> countFriend -= 1
            20 -> countCoin += 5


        }

    }
        // Game End! This Only Happens If The Adventurer Has Died. And As Such, Displays The Scores
    println()
    println()
    Thread.sleep(1000)
    println("Congrats Adventurer! ")
    Thread.sleep(1000)
    println()
    println("You Have Finished My Game!")
    Thread.sleep(1000)
    println()
    println("Your Coin Count Was: $countCoin,")
    Thread.sleep(1000)
    println("Your Level Was: $countLevel,")
    Thread.sleep(1000)
    println("You Had A Total Of $countStuff Stuff,")
    Thread.sleep(1000)
    println("You Found $countRelic Relics")
    Thread.sleep(1000)
    println("And You Made $countFriend Friends!")
    Thread.sleep(1500)

    if (countCoin < 0 ) {
        Thread.sleep(1000)
        println("Ahh! Debt! A Dungeoneer's Worst Nightmare! \nBetter Sell Your Relics And Items!")
    }
}
// Getting A Left Or Right From The Player
fun getLeftOrRight(): Char {
    var userInput: String


    while (true){
        userInput = readln()
        if (userInput.isNotBlank() ) {
            break
        }
    }

    return userInput.uppercase().first()

}

fun intro() { // Setting The Game Intro
    println()
    println()
    println("---------|------------------|------------")
    println("         ---To The Center---")
    println("---------|------------------|------------")
    println()
    println(" Welcome To The Dungeon Adventurer! ")
    println()
    println()
}
