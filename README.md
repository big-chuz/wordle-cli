# Wordle CLI

A console implementation of the classic Wordle word-guessing game. A five-letter secret word is picked at random from a word list, then the player gets six rounds to guess it; each guess is scored by uppercasing correctly-placed letters, lowercasing letters that exist elsewhere in the word, and dashing out letters that don't appear at all.

## What's in here

- `src/main/java/ConsoleWordle.java` — entry point handling file loading, the guess loop, and per-round feedback
- `src/main/resources/Examples.pdf` — reference examples of game output

## Requirements

- JDK 17
- Gradle (the bundled `gradlew` wrapper handles this)

## How to build & run

```bash
./gradlew build
./gradlew run
```

On Windows:
```powershell
.\gradlew.bat build
.\gradlew.bat run
```

In IntelliJ: open the folder, let Gradle sync, then run the `main` method in `ConsoleWordle`.

## How to use

Run the program with a `words.txt` file available in the working directory (formatted with a leading integer count followed by one word per line). At each round prompt, type a five-letter guess and press enter; the program prints the scored result and either congratulates you on a win or reveals that the round count has been exhausted.

## Origin

Originally a coursework assignment; pulled out as a standalone repo.
