# BirthdayParadox

Simulating, running and graphing a series of experiments on the [Birthday Paradox](https://en.wikipedia.org/wiki/Birthday_problem).

The birthday paradox is strange, counter-intuitive, and completely true. It's a paradox because it yields results that we, as humans, wouldn't anticipate in exponential calculation.

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
