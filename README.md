# Lab2
This is my second Assignment for CISC3130. This Repository contains the following:
-CSV File of Spotify's Regional Global Daily Top 200 List
-Main Lab2.java program that reports which artists and how many of their songs are listed
-OutputText file Artist-WeekOf08302020.txt which is the output file of the report

I debated using an object oriented approach in this program. However, I wasn't quite sure how to implement 2D arrays
with it, so I decided against it for this assignment. In creating the program, I first made sure to declare variables and 
the 2D Array. The first problem I encounted in the program was printing out the data from the file without the extra commas.
I attempted to use charAt() method to try and separate the data, but it was too messy for me, so I decided to use a temporary 
array where I could split the data by its commas (idea was brought up in class discussion board) in order to locate the artist's 
name without storing other irrelevant information. I also debated whether to use a boolean or int method for searching through 
the array for repetitions. I decided to use an int method, so that I could use the returned value to count how many times 
an Artist's song appeared on the list. I created a compare method that will compare the current artist being sorted to previous 
information already stored in the array. If Artist's name is listed, then it will count how many times their name appeared on the list,
otherwise the Artist will simply be added into the array. When printing the data, I decided to go for a list rather than a table. 
