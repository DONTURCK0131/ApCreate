from graphicsforcreate import *

def main():
    window = GraphWin("Guess the Flag", 400, 600, autoflush = False)
    window.setCoords(0, 0, 800, 800)

# Work here lucas

# Work here Donovan
def flagAppearance(UserInput:str) -> (str, float):
    inputBox = Entry(Point(200, 300), 25)  
    UserInput = inputBox.getText()
    
    FlagNames = ["Kosovo", "Italy", "France"]

    KosovoImage = Image(Point(200, 500), "KosovoFlag.png")
    ItalyImage = Image(Point(200, 500), "ItalyFlag.png")
    FranceImage = Image(Point(200, 500), "FranceFlag.png")

    FlagDict = {FlagNames[0]:KosovoImage, FlagNames[1]:ItalyImage, FlagNames[2]:FranceImage}




    
main()