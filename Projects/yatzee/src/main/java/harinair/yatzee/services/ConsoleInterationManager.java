package harinair.yatzee.services;

import harinair.yatzee.model.Die;
import harinair.yatzee.model.GameType;
import harinair.yatzee.model.PlayType;
import harinair.yatzee.model.Player;
import harinair.yatzee.model.ScoreBoard;
import java.io.PrintStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * A concrete class for the InteractionManager. This interacts with user using
 * the computer console.
 * 
 * @author ugangha
 */
public class ConsoleInterationManager implements InteractionManager {

    private final Scanner scanner = new Scanner(System.in);
    private final PrintStream printer = System.out;

    @Override
    public void chooseGame(Player player) {
        printer.println(player.toString() + ", Please choose the Game. Enter: ");
        for (GameType game : GameType.values()) {
            printer.println(String.format("%d for %s", game.ordinal() + 1, game.toString()));
        }
        boolean isValid = false;
        do {
            int gameId;
            try {
                gameId = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception ex) {
                printer.print("Invalid Entry - try again: ");
                scanner.nextLine();
                continue;
            }
            if (gameId > 0 && gameId <= GameType.values().length) {
                isValid = true;
                player.setCurrentGame(GameType.values()[gameId -1]);
            }
            if (!isValid) {
                printer.print("Invalid Entry - try again: ");
            }
        } while (!isValid);
    }

    @Override
    public PlayType choosePlay(Player player) {
        printer.println(player.toString() + ", Please choose the Play. Enter: ");
        for (PlayType play : PlayType.values()) {
            printer.println(String.format("%d for %s", play.ordinal() + 1, play.toString()));
        }
        PlayType play = null;
        boolean isValid = false;
        do {
            int playId;
            try {
                playId = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception ex) {
                printer.print("Invalid Entry - try again: ");
                scanner.nextLine();
                continue;
            }
            if (playId > 0 && playId <= PlayType.values().length) {
                isValid = true;
                play = PlayType.values()[playId -1];
            }
            if (!isValid) {
                printer.print("Invalid Entry - try again: ");
            }
        } while (!isValid);
        return play;
    }

    @Override
    public String choosePlayerName(int playerNum) {
        String playerName;
        boolean playerNameInvalid;
        do {
            printer.print(String.format("Enter Player %d Name: ", playerNum + 1));
            playerName = scanner.nextLine();
            playerNameInvalid = playerName == null || playerName.trim().equals("");
            if (playerNameInvalid) {
                printer.println("Entry - invalid. Try again.");
            } else {
                break;
            }
        } while (playerNameInvalid);
        return playerName;
    }

    @Override
    public void handleNoGameStrategy() {
        printer.println("*** Do Not Know how to play this Game - Possibly not implemented? ****");
    }

    @Override
    public void showDie(Die die) {
        int val = die.getVal();
        switch (val) {
            case 1:
                printer.println(" ________");
                printer.println("|        |");
                printer.println("|        |");
                printer.println("|   *    |");
                printer.println("|        |");
                printer.println("|________|");
                break;
            case 2:
                printer.println(" ________");
                printer.println("|        |");
                printer.println("|   *    |");
                printer.println("|        |");
                printer.println("|    *   |");
                printer.println("|________|");
                break;
            case 3:
                printer.println(" ________");
                printer.println("|        |");
                printer.println("|   *    |");
                printer.println("|    *   |");
                printer.println("|     *  |");
                printer.println("|________|");
                break;
            case 4:
                printer.println(" ________");
                printer.println("|        |");
                printer.println("|  *  *  |");
                printer.println("|        |");
                printer.println("|  *  *  |");
                printer.println("|________|");
                break;
            case 5:
                printer.println(" ________");
                printer.println("|        |");
                printer.println("|  *  *  |");
                printer.println("|   *    |");
                printer.println("|  *  *  |");
                printer.println("|________|");
                break;
            case 6:
                printer.println(" ________");
                printer.println("|        |");
                printer.println("|  *  *  |");
                printer.println("|  *  *  |");
                printer.println("|  *  *  |");
                printer.println("|________|");
                break;
       }
    }

    @Override
    public Set<Integer> chooseDice(int tryCount, int count) {
        Set<Integer> dice = new HashSet<>();
        boolean isInvalid = false;
        do {
            dice.clear();
            printer.println(String.format("*** Roll the Dice - Try# %d ***", tryCount));
            printer.print("Choose the dice to roll - 6 to stay (Example: 1,4,5): ");
            String entry = scanner.nextLine();
            if ("6".equals(entry.trim())) {
                // stay
                break;
            }
            String[] parts = entry.split(",");
            for (String part: parts) {
                try {
                    Integer die = Integer.parseInt(part.trim());
                    if (die > 0 && die <= count) {
                        dice.add(die -1);
                    } else {
                        printer.println("Invalid number: " + part);
                        isInvalid = true;
                        break;
                    }
                } catch(NumberFormatException ex) {
                    printer.println("Invalid number: " + part);
                    isInvalid = true;
                    break;
                }
            }
        } while(isInvalid);
        return dice;
    }

    @Override
    public void startPlay(Player player) {
        printer.println("***************************************************");
        printer.println(String.format("Hello %s, it your turn now!!!", player));
        printer.println("***************************************************");
        showScoreBoard(player);
    }

    @Override
    public void showScoreBoard(Player player) {
        printer.println("================== Score Board ======================");
        ScoreBoard scores = player.getScoreboard();
        printer.print("Roll        ");
        for (GameType game : GameType.values()) {
            printer.print("\t" + game.toString());
        }
        printer.println();
        for (PlayType play : PlayType.values()) {
            printer.print(play.toString());
            for (GameType game : GameType.values()) {
                int playScore = scores.getScore(game, play);
                if (playScore >= 0) {
                    printer.print("\t" + playScore);
                } else {
                    printer.print("\t***");
                }
            }
            printer.println();
        }
        printer.println("=====================================================");
    }
}
