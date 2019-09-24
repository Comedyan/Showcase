#===============================================================================
# PROGRAM PURPOSE:... Ch 4 M7
# AUTHOR:............ Rini, Nicholas
# COURSE:............ CSC 131-006
# TERM:.............. Spring 2018
# COLLABORATION:..... Going over the test review helped me with this program
# WORK TIME(hh:mm):.. 5:00
#===============================================================================

# Program 4: The Baboon

print("Enter a list of words, and I will give you back the words whose first")
print("letter repeats within that word.\n")
print("Enter your words one at a time, then press enter when you\'re done\n")


#defining variables
empty = ''
entry_store = []
stop = False

if stop == False:
    entry = input("Enter a word:")
    entry_store.append(entry)
    
#storing the list of words
while entry != empty and stop == False:
    entry = input("Enter another word (press enter when finished):")
    entry_store.append(entry)

#if the user wants to be funny
if entry == empty:
    stop == True

entry_store.remove('')
real_store = []

#main loop thing starts, editing list (sorry for non-readability)
if stop == False:
    for word in entry_store:
        if word[0] in word[1:len(word)]:
            real_store.append(word)
    #caps for loops starts
    for caps in entry_store:
        for letter in range(0,len(caps)):
                if chr((ord(caps[0]))) in chr((ord(caps[letter]))-32):
                    real_store.append(caps)

stop = True

#the stopper
if stop == True:
    print(real_store)
    print("Goodbye.")

#I DID IT

