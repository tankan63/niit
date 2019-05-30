''' create a database in your script folder create a table called words having columns: word, count
read a sentence, get all words and count, put it in the table, query and display all the words in the table'''

import sqlite3
import re
con=sqlite3.connect('worddb.db')

con.execute('''CREATE TABLE WORDS
            (WORDS TEXT NOT NULL,
             COUNT INT NOT NULL);''')
count=1
sent=input("Enter a sentence: ")
wordList=re.sub("[^\w]"," ",sent).split()
for x in wordList:
    con.execute('''ENTER INTO WORDS(WORDS, COUNT)
                    VALUES(?, ?)''', (x, count);)
    count+=1
    con.commit()
    
cursor=con.execute("SELECT WORDS, COUNT FROM STUDENT") #syntax error wtf??
for row in cursor:
    print("Word: ", row[0])
    print("Count: ", row[1])
    
