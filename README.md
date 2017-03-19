# BirthdayParadox

Simulating, running and graphing a series of experiments on the [Birthday Paradox](https://en.wikipedia.org/wiki/Birthday_problem).

In probability theory, the birthday problem or birthday paradox concerns the probability that, in a set of n, n randomly chosen people, some pair of them will have the same birthday. By the pigeonhole principle, the probability reaches 100% when the number of people reaches 367 (since there are only 366 possible birthdays, including February 29). However, 99.9% probability is reached with just 70 people, and 50% probability with 23 people. These conclusions are based on the assumption that each day of the year (except February 29) is equally probable for a birthday.

## How to?

Compiling (from the directory "Q2")

**On windows:**

```
javac -cp lib/jfreechart-1.0.19.jar;lib/jcommon-1.0.23.jar;lib/ITI1121.jar -d classes src/*.java
```

**On MacOS/Unix etc.**

```
javac -cp lib/jfreechart-1.0.19.jar:lib/jcommon-1.0.23.jar:lib/ITI1121.jar -d classes src/*.java 
```

Running

**On windows:**

```
java -cp classes;lib/* BirthdayParadox
```

**On MacOS/Unix :**

```
java -cp classes:lib/* BirthdayParadox
```
