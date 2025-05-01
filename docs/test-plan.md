# Plan for Testing the Program

The test plan lays out the actions and data I will use to test the functionality of my program.

Terminology:

- **VALID** data values are those that the program expects
- **BOUNDARY** data values are at the limits of the valid range
- **INVALID** data values are those that the program should reject

--- 

## Test 1: Invalid Input

    To get the results I needed, I had to get a valid input. it would display a number after asking the player for a prompt.

### Test Data To Use

    The test data was ASD and left. I selected these so that when i tested the code, i could test for non left or right answers. also i used right similar answers in 

### Expected Test Result

    Completing the test showed that if an invalid request was inserted, the program would not break, however it would continue to run, expecting a new result. And if a real input was chosen e.g. l, Left, LEFT, left or light-imobilisation, It would continue with the prompts. it will always get the first char of the input.
![Screen Recording 2025-04-29 at 12.41.04 PM.gif](screenshots/Screen%20Recording%202025-04-29%20at%2012.41.04%20PM.gif)
---

# Test 2: Boundary Level Travel

    The game may be infiite.

### Test Data To Use

    To test this theory, I had to play my game for as long as possible, however it is always a random number. I Achieved this by commenting out the dangerous options, leading to only peasefull dungeonering.

### Expected Test Result

    I expected the game to go on forever, so I tested weather that was true or not.
![Screen Recording 2025-04-29 at 12.56.15 PM.gif](screenshots/Screen%20Recording%202025-04-29%20at%2012.56.15%20PM.gif)

---

## Using Cheats To Go Past LVL 50 (End Level) Or Go Over Limits In Coins E.C.T

    This test was made to test if the values that were changed by the player after entering sudo enter, that they wouldnt effect the games playability.

### Test Data To Use

    I will use the cheat mode ( entering sudo enter instead of the left or right options ) to go past those levels and values to test limits.

### Expected Test Result

    When the player enters all the values in 'sudo enter', it should add those intergers, but if they go past lvl 50 it should go to the LVL 50 event and then end the code.
    I found when i was testing this that if i did under 100 levels, it would work, and the level would play and then end the adventre, however, when i did 100 or more it had a problem with going over the level 50 event.
![Screen Recording 2025-04-29 at 3.02.38 PM.gif](screenshots/Screen%20Recording%202025-04-29%20at%203.02.38%20PM.gif)
    All I had to do to fix it was add a little extra bit saying that if the level is 51 or higher, it would end the game


---
