#==========================================================================
# PROGRAM PURPOSE:... Ch 3 M7
# AUTHOR:............ Rini, Nicholas
# COURSE:............ CSC 131-006
# TERM:.............. Spring 2018
# COLLABORATION:..... We went over this assignment in class, I got a push
# in the right direction
# WORK TIME(hh:mm):.. 1:15
#==========================================================================


# Coin Change Exercise Program

import random

# program greeting
print('Enter a number of coin values that add up to the amount shown')
print('Enter coins values as 1-penny, 5-nickel, 10-dime and 25-quarter')
print('(if you don\'t, I\'ll get mad at you)')
print('Press enter when you think you:')
print('    a. Have the right amount of coins and;')
print('    b. Have used the least amount of coins possible')
print('----------------')

# init
endit = False
empty_str = ''

# start game
while not endit:
    amount = random.randint(1,99)
    print('Enter coins that add up to', amount, 'cents, one per line.\n')
    game_over = False
    total = 0
    a = amount

    q = a // 25
    a = a - (q*25)
    
    d = a // 10
    a = a - (d*10)
    
    n = a // 5
    a = a - (n*5)

    p = a // 1
    a = a - (p*1)
    
    mc = q + d + n + p
    uc = -1
   
    while not game_over:
        valid_entry = False
        
        while not valid_entry:
           
            if total == 0:
                uc = uc + 1
                #print('uc= ',uc,'mc= ', mc)
                entry = input('Enter first coin: ')
            else:
                uc = uc + 1
                entry = input('Enter next coin: ')
                
            if entry in (empty_str,'1','5','10','25'):
                valid_entry = True
            else:
                uc = uc - 1
                #print('uc= ',uc,'mc= ', mc)
                print('Invalid entry >:(')
        
        if entry == empty_str:
            if total == amount and mc == uc:
                #print('uc= ',uc,'mc= ', mc)
                print('Correct! :)')
                
            if total < amount:
                #print('uc= ',uc,'mc= ', mc)
                print('Sorry - you only entered', total, 'cents. :(')
                
            if uc > mc and total == amount:
                print('Sorry - you used',uc,
                      'coins, you should have used',mc,'coins :(')
            game_over = True
        
        else:
            total = total + int(entry)
            if total > amount:
                #print('uc= ',uc,'mc= ', mc)
                uc = uc + 1
                print('Sorry - total amount exceeds', amount, 'cents. :(')
                game_over = True
            
                
        if game_over:
            entry = input('\nKeep trying! (y/n): ')
            
            if entry == 'n':
                endit = True

print('Thanks for playing, please come again!')
    


