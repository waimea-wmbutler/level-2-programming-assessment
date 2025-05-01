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
 * like a dungeon in a door-door format. Two players will play separately and match points, made by; coins, level ect.
 * Highest points wins.
 * Yes I Used ChatGPT To **Help** Me, Not To Do It For Me
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
var countItem = 1
// The Amount Of Relics you Find
var countRelic = 0
// How Many Other Adventurers The Find
var countFriend = 0
// Keeping The Game Two Player By Holding The Value Of the First Player and Matching it To The Second Player
var prevPlayerValues1 = 0
var prevPlayerValues2 = 0
// Keeps The Number Of Players Under A Specific Number
var countPlayers = 0
// Magic Items To Stop Bad Guys!
var countMagic = 0
//Event Triggers
var hasTriggeredLevel50Event = false

fun main () {
    // Setting A List For The Room Types To Be Held Into So That We Can Grab Them By An Int (Index)
    val roomType = mutableListOf(
        "You Found 5 Coins!",
        "The Room Is Empty!",
        "Ahh! A Goblin! What Can You Do?!?\n",
        "The Floor Opens Below You To Reveal A Lava Pit! \nThis Is The End For You Adventurer!",
        "This Room Is Filled With Furniture And Antiques, Gain 5 Items!",
        "The Room Has a Big Bad In It! \nWhat Are You Going To Do?!?\n",
        "This Room Has Arcane Wizards In It! Better Leave Them Alone..",
        "A Sign In The Center Of The Room States: 'Dont Look Down!' \nThe Floor Turns Into A Thin Bridge! Lose 3 Coins!",
        "Your Surrounded By Angry Dwarfs! \nThey, Uhhhh, Dwarf You.. \nThis Is The End For You Adventurer!",
        "A Sack Of Coins Fall In The Room, Spilling On The Floor. \nYou Grab As Many As You Can. You Collect 8 Coins!",
        "You Found A Old Magic Book? That Might Be Useful!",
        "Wow! A Cool Hat! Better Grab That! Gain 2 Magic!",
        "You Found A Dragon Egg?!? \nYou Gain 5 Relics And Some Magic!",
        "You Found An Ancient Temple! \nYou Gain 1 Relic!",
        "The Room Is Filled With Papers, Documents And Other Random Pages!\nGain 2 Relics!",
        "You Found Some Better Gear! \nDouble Your Items!",
        "The Room Has A Huge Pile Of Gold! \nGrab As Much As You Can! Gain 50 Coins!!",
        "You Found Another Adventurer! 'Fancy Seeing You Here!' \nNothing Else Happens",
        "A Trade Merchant? In This Dungeon? \nYou Sell Some Items For Coins!",
        "'AHHHH!! GIANT SPIDER!!!!!!! AHHHHHHHH!!'\n\n'Dont Be Scared! Im George! George The Giant Spider!'\n\n*George Daps Up The Adventurer*",
        "The Room Is Pitch Black! What Will You Do?!?\n",
        "Whoa! A Cool Robe! Better Grab That! Gain 1 Magic!",
        "The Dungeon Calls You Further in..\n You Black Out!\nYou Seem To Have Travelled 3 Levels?!?",
        "There Is A Cry In The Room Ahead! Go Investigate!",
        "Arrows Fly From The Wall! \nThis Is The End For You Adventurer!",
        "Looks Like An Old Wizard Hideout! Gain Some Leftover Knowledge!")



    intro() // Intro To The Game
    println(" What Is Your Name, Brave Soul? ")
    val playerName: String = readln()
    println()
    println("Good luck, $playerName!")
    Thread.sleep(1000)
    println(" What Is Your Name, Brave Soul Number 2? (We See You...) ")
    val playerName2: String = readln()
    println()
    println("Good luck, $playerName2!")
    println()
    println()
    Thread.sleep(1000)

    // Keep Looping Until Both Players Have Completed The Dungeon
    while (countLevel == 0) {
        if (countPlayers == 0) {
            println("You First $playerName!")
        }
        if (countPlayers == 1) {
            println("Your Turn $playerName2!")
        }
        if (countPlayers >= 2) {
            break
        }

        // Get The Player's Action (L/R)
        while (true) {
            println()
            println("Please Select L For Left Door, Or R For Right Door ")
            var door = 'X' // Variable To Set The firstDoor Against L And R
            while (door != LEFT && door != RIGHT) {
                door = getLeftOrRight()
            }
            // What's Inside The Room
            val roomNum = (0..<roomType.size).random()
            when (door) { // After Getting The Option From The Player, Following These Rules To Show Inside The Room
                RIGHT -> {
                    Thread.sleep(750)
                    println()
                    println(roomType[roomNum])
                    Thread.sleep(500)

                }

                LEFT -> {
                    Thread.sleep(750)
                    println()
                    println(roomType[roomNum])
                    Thread.sleep(500)
                }
            }
            countLevel++
            // Check roomNum (Random Number) To See What Has Happened
            when (roomNum) {
                0 -> countCoin += 5
                1 -> continue
                2 -> if (countMagic >= 1) {
                    println("Quick Use Magic! The Goblin Dies!")
                    countMagic -= 1
                } else {
                    println("He Stole 10 Coins!")
                    countCoin -= 10
                }

                3 -> break
                4 -> countItem += 5
                5 -> if (countMagic >= 3) {
                    println("You Can Magic Him Away! Gain His Coins!")
                    countMagic -= 3
                    countCoin += 20
                } else {
                    if (countCoin >= 0) {
                        countCoin = 0
                        println("He Steals All Your Coins!")
                    } else {
                        println("You Square Him Up, And Run Away!")
                        continue

                    }
                }

                6 -> continue
                7 -> countCoin -= 3
                8 -> break
                9 -> countCoin += 8
                10 -> countMagic += 5
                11 -> countMagic += 2
                12 -> {
                    countRelic += 5
                    countMagic += 1
                }

                13 -> countRelic += 1
                14 -> countRelic += 2
                15 -> countItem *= 2
                16 -> countCoin += 50
                17 -> countFriend++
                18 -> {
                    if (countItem >= 4) {
                        countItem -= 4
                        countCoin += 10
                    }
                    if (countRelic >= 2) {
                        countRelic -= 2
                        countCoin += 10
                    } else {
                        continue
                    }
                }

                19 -> countFriend += 1
                20 -> if (countMagic >= 1) {
                    println("Light The Way With Magic! You Find Some Coins!")
                    countCoin += 3
                } else {
                    println("Its So Dark You Cant See! \nYou Drop Some Coins Finding Your Way Out!")
                    countCoin -= 3
                }

                21 -> countMagic += 1
                22 -> countLevel += 2
                23 -> countLevel += 1
                24 -> break
                25 -> countMagic += 3
            }
            // If The Player Reaches Level 50, A Special Dragon Event Will Appear!
            if (countLevel >= 50 && !hasTriggeredLevel50Event) {
                hasTriggeredLevel50Event = true
                println()
                println()
                Thread.sleep(2000)
                println("You Feel A Powerful Presence Ahead... ")
                Thread.sleep(1000)
                println("You've Reached Level 50! A Massive Chamber Opens Before You.")
                Thread.sleep(1000)

                val eventType = (1..4).random() // 1 = Fight, 2 = Befriend, 3 = Sneak, 4 = Steal
                when (eventType) {
                    1 -> { // FIGHT THE DRAGON
                        println("A Dragon Appears And Screeches! It Looks Angry. Do You Fight?!")
                        Thread.sleep(1000)
                        if (countMagic >= 10 || countItem >= 20) {
                            println("You Gear Up And Unleash Your Magic For The Fight. — The Dragon Is Defeated!")
                            Thread.sleep(1000)
                            countCoin += 100
                            countRelic += 5
                            countItem += 10
                        } else {
                            println("You're Not Strong Enough! The Dragon Burns Your Stuff!")
                            countItem = (countItem / 2)
                            countCoin = (countCoin - 30)
                            Thread.sleep(1000)
                        }
                    }

                    2 -> { // BEFRIEND THE DRAGON
                        println("A Dragon Seems Curious About You. It Doesn’t attack...")
                        Thread.sleep(1000)
                        if (countRelic >= 10 || countFriend >= 3) {
                            println("You Show Your Relics And Talk With It. You Gain A Powerful Ally!")
                            Thread.sleep(1000)
                            countCoin += 30
                            countMagic += 5
                            countFriend += 3
                        } else {
                            println("It Loses Interest And Flies Away, Dropping Some Gold.")
                            countCoin += 10
                            Thread.sleep(1000)
                        }
                    }

                    3 -> { // SNEAK PAST THE DRAGON
                        println("You Try To Sneak Past The Dragon...")
                        Thread.sleep(1000)
                        if (countItem >= 10) {
                            println("You Blend In Using Some Items And Escape! You Snatch Some Treasure Too!")
                            Thread.sleep(1000)
                            countCoin += 20
                        } else {
                            println("You Stumble And The Dragon Notices! You Drop Some Items Fleeing!")
                            countItem = (countItem - 5)
                            Thread.sleep(1000)
                        }
                    }

                    4 -> { // STEAL THE DRAGONS GOLD
                        println("You Spot A Mountain Of Treasure Behind The Dragon. Try To Steal?")
                        Thread.sleep(1000)
                        if (countMagic >= 5 && countRelic >= 3) {
                            println("With Some Magical Stealth, You Steal The Gold And Escape!")
                            Thread.sleep(1000)
                            countCoin += 150
                            countItem += 3
                        } else {
                            println("You Trip A Trap! The Dragon Catches You, And You Barely Make It Out.")
                            countCoin = (countCoin - 50)
                            countRelic = (countRelic / 2)
                            Thread.sleep(1000)
                        }
                    }
                }
                Thread.sleep(1000)
                println("You Survived The Dragon's Lair... For Now.")
                Thread.sleep(1000)
                println("The Surface Is Just Ahead, Its Time To Leave")
                break
            }
            if (countLevel >= 51){
                break
        }
        }
        // Game End! This Only Happens If The Adventurer Has Died. And As Such, Displays The Scores Gained During The Play through
        // It Also Shows The Players Score, And Then Re-sets The Game So That The Second Player Can Go Through
        println()
        println()
        Thread.sleep(1000)
        println("Congrats Adventurer! ")
        Thread.sleep(1000)
        println()
        println("You Have Finished My Game!")
        println()
        Thread.sleep(1000)
        println()
        println("Your Coin Count Was: $countCoin,")
        Thread.sleep(1000)
        println("Your Level Was: $countLevel,")
        Thread.sleep(1000)
        println("You Had A Total Of $countItem Items,")
        Thread.sleep(1000)
        println("You Found $countRelic Relics,")
        Thread.sleep(1000)
        println("You Collected $countMagic Magic Items,")
        Thread.sleep(1000)
        println("And You Made $countFriend Friends!")
        Thread.sleep(1500)

        countPlayers += 1
        if (countCoin < 0) {
            Thread.sleep(1000)
            println()
            println("Ahh! Debt! A Dungeoneer's Worst Nightmare!")
            Thread.sleep(1000)
            println("Better Sell Your Relics And Items!")
        }
        if (countPlayers == 2) {
            savePlayerData2()
            println()
            Thread.sleep(1000)
            println("Your Score Was: $prevPlayerValues2!")
            Thread.sleep(1000)
            println("Thanks For Playing $playerName2!")
        }
        if (countPlayers <= 1) {
            savePlayerData1()
            println()
            Thread.sleep(1000)
            println("Your Score Was: $prevPlayerValues1!")
            Thread.sleep(1000)
            println("Thanks For Playing $playerName!")
            Thread.sleep(1000)
            println("Resetting...")
            Thread.sleep(1000)
            countCoin = 0
            countItem = 0
            countFriend = 0
            countRelic = 0
            countLevel = 0
            countMagic = 0
            continue
        }
    }

    // Doing A Little Maths To See The Winner!
    Thread.sleep(1000)
    println("Let's See Who Won!")
    Thread.sleep(1000)
    if (prevPlayerValues1 > prevPlayerValues2){
        println("$playerName Has Won! Congrats! $prevPlayerValues1 Points!")
    }
    if (prevPlayerValues2 > prevPlayerValues1) {
        println("$playerName2 Has Won! Congrats! $prevPlayerValues2 Points!")
    }
    if (prevPlayerValues1 == prevPlayerValues2) {
        println("Wow! A Tie! Maybe Play Again?")
    }
    println("Thanks So Much For Playing My Game!")
    Thread.sleep(15000)
    //Lore Hint. Unrelated But Thought It Was Cool For An Easter Egg
    println("̴Y̷o̸u̷ ̵w̵e̸r̷e̷ ̴n̵e̸v̴e̵r̸ ̸m̵e̷a̵n̸t̶ ̶t̵o̵ ̸r̷e̷a̸c̶h̵ ̶t̵h̶e̵ ̷c̷e̵n̵t̷e̵r̵.̸ ̵Y̶o̶u̴ ̷w̷e̸r̶e̵ ̵t̸h̶e̸ ̴c̶e̶n̶t̷e̷r̵’̴s̷ ̴d̴r̷e̴a̶m̶.̸")
}
// Functions To Find The PlayerInput, Save Player data, ect.
// Getting A Left Or Right From The Player
fun getLeftOrRight(): Char {
    var userInput: String
    while (true) {
        userInput = readln()
        if (userInput.isBlank()) continue
        if (userInput.lowercase() == "sudo enter") {
            showCheatMenu()
            continue // After editing variables, re-prompt for door
        }
        val inputChar = userInput.uppercase().first()
        if (inputChar == LEFT || inputChar == RIGHT) {
            return inputChar
        }
        println("Invalid input. Please enter Left or Right.")
    }
}
//Getting A Cheat Menu So I Can Edit My Scores And Levels, To Test The LVL 50 Event.
fun showCheatMenu() {
    println("\nCheat Mode Activated! Choose a stat to edit:")
    val options = listOf(
        "0: Coins ($countCoin)",
        "1: Levels ($countLevel)",
        "2: Items ($countItem)",
        "3: Relics ($countRelic)",
        "4: Friends ($countFriend)",
        "5: Magic ($countMagic)"
    )
    options.forEach { println(it) }
    val choice = getInt("Enter the number of the stat you want to edit (0–5):")
    val value = getInt("Enter the number to add/subtract (use negative numbers to decrease):")
    when (choice) {
        0 -> countCoin += value
        1 -> countLevel += value
        2 -> countItem += value
        3 -> countRelic += value
        4 -> countFriend += value
        5 -> countMagic += value
        else -> println("Invalid option.")
    }
    println("✅ Value updated! Returning to game...\n Left Or Right?")
}
//Function To Get Int So Previous Functions Work. This Function Includes A Parameter (Prompt) To Set What's Happening Inside
fun getInt(prompt: String): Int {
    while (true) {
        println(prompt)
        val input = readln()
        val number = input.toIntOrNull()
        if (number != null) return number
        println("Please enter a valid number.")
    }
}
// Game Intro Screen
fun intro() { // Setting The Game Intro
    println()
    println()
    println("---------|------------------|------------")
    println("         ---To The Center---")
    println("---------|------------------|------------")
    println()
    println()
    Thread.sleep(1000)
    println(" Welcome To The Dungeon Adventurer! ")
}
// Saving The First Players Data!
fun savePlayerData1 (): Int {
    countCoin /= 2
    countItem /= 2
    countMagic /= 2
    prevPlayerValues1 = countCoin + countRelic + countLevel + countFriend + countItem + countMagic

    return prevPlayerValues1
}
// Saving The Second Players Data!
fun savePlayerData2 (): Int {
    countCoin /= 2
    countItem /= 2
    countMagic /= 2
    prevPlayerValues2 = countCoin + countRelic + countLevel + countFriend + countItem + countMagic

    return prevPlayerValues2
}
// Error Would Show Unless This Function Is Here
private operator fun Boolean.compareTo(i: Int): Int {
return i
}