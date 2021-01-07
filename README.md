# Huge Integer Class 🔢

## How it works
I implemented the HugeInteger class using an array, with the instance variables of
hugeint (array), size (int), and negative (boolean). Each element of the array, hugeint, included a
single digit number, with the indexing of the array being in the order of the number. In the
constructor, from the inputted string, I converted it to an array of characters so I could index each
element and make sure that all of the arguments were legal and check if the array started with a
negative symbol. If the string started with a negative symbol, I assigned the instance variable,
negative, to be true. I also saved the size of the string under the instance variable size. Then in a
for loop, I converted the characters to integers and assigned them into the instance variable array,
hugeint. 

### Add
I first initialized an empty string, output, that will be used to initialize the HugeInteger,
and an empty array that is the size of the largest number, sum. I then checked to see if one
number is negative and one number is positive, and if it was true I returned the subtract method.
If both numbers were negative I would add a negative symbol to output. Then I used two for
loops to add the numbers. The first for loop was indexed from the end to the start of the smaller
integer (if the number of digit were different). Inside the for loop I added the digits bit by bit
with an if statement that creates a carry when the sum is greater than nine. The second for loop is
the same as the first one, but indexed from the end of the smaller number to the end of the larger
number. Then in a third for loop, converted each integer in sum to a string and saved it to
output. I then returned a new HugeInteger using the string output.

### Subtract
I first initialized an empty string, output, that will be used to initialize HugeInteger, and
an empty array, sub, that the difference will be stored to. I then checked for special cases. If one
integer was negative and one was positive then I returned the add method because when you
subtract a negative number you are actually adding. I also checked if both number were negative,
then I added a negative symbol to the output. Then through a series of if statements I determined
which way to subtract the numbers depending on which integer was bigger, or if they were the
same size. I then put them through similar for loops as the add method where I subtracted the
numbers bit by bit then converted the array to a string and saved it to output. I then returned a
new HugeInteger using the string output. 

### Multiply
In order to multiply two numbers, I first initialized the array of integers product, to be the
sum of the two sizes of the numbers. I then checked if one of the numbers was negative, and if it
was true I added a negative symbol to the output string. Then, using a double nested for loop I
multiplied every number bit by bit by looping through each possible combination of each digit. If
the product of two digits was more than nine, the carry would be added to the previous index
number. I then used a for loop to save the array into the string output and returned a new
HugeInteger using the string output. 

### Compare
In order to compare the two integers, I used a series of if statements. I first checked if one
number is negative and one is positive because then the positive integer is larger. I then checked
to see if one integer has a larger size then the other, but if both the numbers are negative then I
returned the opposite. If the sizes were the same, I used a while loop to determine the digits
where the numbers differ and then I checked which number was bigger. If the numbers were the
exact same I returned 0. 


