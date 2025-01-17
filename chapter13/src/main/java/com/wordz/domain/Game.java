package com.wordz.domain;

public class Game {
    private static final int MAXIMUM_NUMBER_ALLOWED_GUESSES = 5;
    private final Player player;
    private final String targetWord;
    private int attemptNumber;
    private boolean isGameOver;

    public Game(Player player, String targetWord, int attemptNumber, boolean isGameOver) {
        this.player = player;
        this.targetWord = targetWord;
        this.attemptNumber = attemptNumber;
        this.isGameOver = isGameOver;
    }
    public Player getPlayer() {
        return player;
    }

    public int getAttemptNumber() {
        return attemptNumber;
    }

    public String getWord() {
        return targetWord;
    }

    public Score attempt(String guess) {
        trackNumberOfAttempts();

        var word = new Word(targetWord);
        Score score = word.guess(guess);

        if (score.allCorrect()) {
            end();
        }

        return score;
    }

    private void trackNumberOfAttempts() {
        attemptNumber++;

        if (attemptNumber == MAXIMUM_NUMBER_ALLOWED_GUESSES ) {
            end();
        }
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    private void end() {
        isGameOver = true;
    }
}
