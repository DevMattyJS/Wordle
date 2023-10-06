# **Simple Wordle Game**

The goal of this game is to guess the secret word sooner, 
than you run out of attempts. 
Secret word is randomly chosen from a file (all words are 5 characters long).

Conditions for a valid input:

- input have to be exactly 5 characters long
- input can contain just a letters (numbers and special characters are not allowed)

An input, that don't meet these conditions is evaluated as invalid,
it is not even considered as an attempt to guess.

A program gives feedback to player after each round.\
This feedback consists of:

- remaining attempts
- number of correct positions (player guessed correct character and correct position)
- number of correct characters (player guessed correct character, but not correct position)

Game ends if:

- player guessed the secret word correctly
- player run out of attempts

Have fun :)

