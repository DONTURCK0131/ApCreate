from graphicsforcreate import *

import os

import random

def userAnswer():
    return input("What country is this? ").strip()

def numberOfFlags():
     example = input("How many country flags would you like to guess? ").strip()
     return int(example)
     

def main_menu() -> str:
    print("[1] Country Flag Game Start")
    print("[0] Exit Game")
    return input("please select an option: ").strip()


def flagGame(flags, window, num, correct, index):
    while index < num:
        s = random.choice(flags)
        picture = Image(Point(400, 400), s).draw(window)
        user = userAnswer()
        if user.lower() == s[:-4]:
            correct += 1
            index += 1
            flags.remove(s)
            picture.undraw()
            print("Correct!")
        else:
            index += 1
            print("It's not that! The correct country was " + s[:-4])
            flags.remove(s)
            picture.undraw()
    print("You got " + str(correct) + " out of " + str(num) + " correct!")
    exit(0)

def gameSetup(num, correct, index):
    flags = []
    for fileName in os.listdir():
        if fileName.endswith(".png"):
             flags.append(fileName)
    window = GraphWin("Guess the Flag", 800, 800, autoflush = True)
    window.setBackground("dark slate gray")
    flagGame(flags, window, num, correct, index)
    
def main():
    command = main_menu()
    while command != "0":
        if command == "":
            num = numberOfFlags()
            correct = 0
            index = 0
            gameSetup(num, correct, index)
        else:
            print("Please try another option")
        command = main_menu()
    print("Goodbye.")


if __name__ == "__main__":
    main()