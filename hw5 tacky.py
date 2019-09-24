#==========================================================================
# PROGRAM PURPOSE:... Program that resembles the Tick-Tack-Toe game, played locally
# AUTHOR:............ Rini, Nicholas
# COURSE:............ CSC 131-006
# TERM:.............. Spring 2018
# COLLABORATION:..... N/A
# WORK TIME(h:mm):... 4:00
#==========================================================================
import random

#welcome message and instructions
print("Welcome to Tick Tack Toe!")
print("Instructions:)")
print("Press the number that corresponds to where you want to move:")
print()
print("1 2 3")
print("4 5 6")
print("7 8 9")
print()
print("Remember, X goes first! (whoever wants to be X, simply move first)")
print("Or, if you would like to play single-player mode, press enter")

#defining the board
b1 = ['-','-','-']
b2 = ['-','-','-']
b3 = ['-','-','-']
    
#xmove and omove interact with lists b1 b2 and b3 to move X and O on the board
def xmove(pos):
         if pos == '1':
            del b1[0]
            b1.insert(0,'X')
            
         elif pos == '2':
            del b1[1]
            b1.insert(1,'X')
            
         elif pos == '3':
            del b1[2]
            b1.insert(2,'X')
            
         elif pos == '4':
            del b2[0]
            b2.insert(0,'X')
            
         elif pos == '5':
            del b2[1]
            b2.insert(1,'X')

         elif pos == '6':
            del b2[2]
            b2.insert(2,'X')

         elif pos == '7':
            del b3[0]
            b3.insert(0,'X')

         elif pos == '8':
            del b3[1]
            b3.insert(1,'X')

         elif pos == '9':
            del b3[2]
            b3.insert(2,'X')

def omove(pos):
        if pos == '1':
            del b1[0]
            b1.insert(0,'O')
            
        elif pos == '2':
            del b1[1]
            b1.insert(1,'O')
            
        elif pos == '3':
            del b1[2]
            b1.insert(2,'O')
            
        elif pos == '4':
            del b2[0]
            b2.insert(0,'O')
            
        elif pos == '5':
            del b2[1]
            b2.insert(1,'O')

        elif pos == '6':
            del b2[2]
            b2.insert(2,'O')
            
        elif pos == '7':
            del b3[0]
            b3.insert(0,'O')

        elif pos == '8':
            del b3[1]
            b3.insert(1,'O')

        elif pos == '9':
            del b3[2]
            b3.insert(2,'O')
            
#xwin and owin are for checking if X or O won
def xwin():
    if b1 == ['X','X','X']:
        return True
    elif b2 == ['X','X','X']:
        return True
    elif b3 == ['X','X','X']:
        return True
    elif b1[0] == 'X' and b2[0] == 'X' and b3[0] == 'X':
        return True
    elif b1[1] == 'X' and b2[1] == 'X' and b3[1] == 'X':
        return True
    elif b1[2] == 'X' and b2[2] == 'X' and b3[2] == 'X':
        return True
    elif b1[0] == 'X' and b2[1] == 'X' and b3[2] == 'X':
        return True
    elif b1[2] == 'X' and b2[1] == 'X' and b3[0] == 'X':
        return True
    else:
        return False

    
    
   
def owin():
    if b1 == ['O','O','O']:
        return True
    elif b2 == ['O','O','O']:
        return True
    elif b3 == ['O','O','O']:
        return True
    elif b1[0] == 'O' and b2[0] == 'O' and b3[0] == 'O':
        return True
    elif b1[1] == 'O' and b2[1] == 'O' and b3[1] == 'O':
        return True
    elif b1[2] == 'O' and b2[2] == 'O' and b3[2] == 'O':
        return True
    elif b1[0] == 'O' and b2[1] == 'O' and b3[2] == 'O':
        return True
    elif b1[2] == 'O' and b2[1] == 'O' and b3[0] == 'O':
        return True
    else:
        return False

def bot(movesLeft):
    moved = False
    while not moved:
        move = str(random.randint(1,9))
        if move in movesLeft:
            moved = True

        else:
            continue
    moves.remove(move)
    return move
        

moves = ['1','2','3','4','5','6','7','8','9']



#the game

#single-player option
sO = True
sX = True
pos = str(input("press m for multi-player, or enter for single-player:"))
decided2 = False
decidedS =False
while not decided2:
    if pos == "":
        while not decidedS:
            playerType = input("Do you want to be X or O?")
            if playerType == 'X' or playerType == 'x':
                sO = False
                decidedS = True
                decided2 = True
            elif playerType == 'O' or playerType == 'o':
                sX = False
                decidedS = True
                decided2 = True
            else:
                playerType = input("Invalid entry, try again:")
    elif pos == "M" or pos == 'm':
        decided2 = True
    else:
        pos = input("Invalid entry, try again:")
    
gover = False
while not gover:
    omoved = False    
    xmoved = False
    empty = []
        
    #X's move
    while not xmoved:
        if sX == True:
            print()
            pos = str(input("X, where do you want to move? (enter a number 1-9):"))
           
            if pos in moves:
                xmove(pos)
                moves.remove(pos)
                print()
                print(b1[0],b1[1],b1[2])
                print(b2[0],b2[1],b2[2])
                print(b3[0],b3[1],b3[2])
                xmoved = True
                
            
            else:
                print("invalid entry. Either someone already moved there or")
                print("you didn't enter a number 1-9")

            if moves == empty:
                xmoved = True
                omoved = True
                gover = True

            if xwin() == True:
                print("X wins!")
                omoved = True
                xmoved = True
                gover = True
        else:
            xmove(bot(moves))
            print()
            print("X's move!")
            print()
            print(b1[0],b1[1],b1[2])
            print(b2[0],b2[1],b2[2])
            print(b3[0],b3[1],b3[2])
            xmoved = True
            
            if moves == empty:
                xmoved = True
                omoved = True
                gover = True

            if xwin() == True:
                print("X wins!")
                omoved = True
                xmoved = True
                gover = True
                
    #O's move
    while not omoved:
        if sO == True:
            print()
            pos = str(input("O, where do you want to move? (enter a number 1-9):"))

            if pos in moves:
                omove(pos)
                moves.remove(pos)
                print()
                print(b1[0],b1[1],b1[2])
                print(b2[0],b2[1],b2[2])
                print(b3[0],b3[1],b3[2])
                omoved = True
                
            else:
                print("invalid entry. Either someone already moved there or")
                print("you didn't enter a number 1-9")

            if moves == empty:
                omoved = True
                xmoved = True
                gover = True
                
            if owin():
                print("O wins!")
                omoved = True
                xmoved = True
                gover = True
        else:
            omove(bot(moves))
            print()
            print("O's move!")
            print()
            print(b1[0],b1[1],b1[2])
            print(b2[0],b2[1],b2[2])
            print(b3[0],b3[1],b3[2])
            omoved = True
            
            if moves == empty:
                xmoved = True
                omoved = True
                gover = True

            if owin() == True:
                print("O wins!")
                omoved = True
                xmoved = True
                gover = True
            
if (len(moves) == 0) and (owin() == False) and (xwin() == False):
    print("It's a tie!")
    gover = True
                
print("Thanks for playing, come again!")
