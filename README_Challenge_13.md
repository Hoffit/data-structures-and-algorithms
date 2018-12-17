# CF Code Challenge 13
## Multi-bracket Validation.
Check for balanced brackets in a String.

## Challenge
### Feature Tasks
On your main file, create…
    C#: a function called bool MultiBracketValidation(string input)
    JavaScript: a function called multiBracketValidation(input)
    Python: a function called multi_bracket_validation(input)
    Java: a method public static boolean multiBracketValidation(String input)

Your function should take a string as its only argument, and should return a boolean representing whether or not the brackets in the string are balanced. There are 3 types of brackets:

    Round Brackets : ()
    Square Brackets : []
    Curly Brackets : {}

## Approach & Efficiency
I used a stack data structure. Key observation; you only need to check for balance on a close beacket.
For open brackets, push onto the stack.
For non-bracket characters, just ignore them.
When you do encounter a close bracket, compare it to the last bracket pushed to the top of the stack,
with peek. If they are balanced, pop and move on. If not, return false.
- time:   O(n)
- space:  O(n)

## Solution
[White board write up](assets/multi-bracket-validation.jpg)