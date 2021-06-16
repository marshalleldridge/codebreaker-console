package edu.cnm.deepdive;

import edu.cnm.deepdive.service.GameRepository;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Scanner;


/**
 * Implements a simple client for a Codebreaker (similar to MasterMind, Bulls &amp; Cows) game that
 * runs as a web service. This client uses console interaction (standard input &amp; output) to
 * obtain guesses from the user and display the result of each guess.
 *
 * @author Nicholas Bennett and DDC Java + Android Bootcamp cohort 13.
 */
public class Main {

  /**
   * Entry point for game. connects tto codebreaker service to start each game, and query the user
   * for guesses and new games until the user declines to play again.
   *
   * @param args Command line arguments (currently ignored.)
   * @throws IOException If a network of network resource (such as a web service) fails in sending a
   *                     request and receiving a response.
   */
  public static void main(String[] args) throws IOException {
    Scanner scanner = new Scanner(System.in);
    ResourceBundle bundle = ResourceBundle.getBundle("strings");
    GameRepository repository = new GameRepository();
    // TODO create proxy class for service.
    do {
      // TODO play a single game.
      repository.newGame("0123456789", 3);
    } while (queryReplay(scanner, bundle));
  }

  /**
   * Prompts the user to play again. If a resource bundle exists for the current or set local a
   * string from this resource bundle will be used for the prompt text.
   *
   * @param scanner Instance of {@link Scanner} used to obtain user input.
   * @param bundle {@link ResourceBundle} holding UI string content.
   * @return {@code}
   */
  private static boolean queryReplay(Scanner scanner, ResourceBundle bundle) {
    System.out.println(bundle.getString("replay_prompt"));
    String input = scanner.nextLine().trim().toLowerCase();
    return (input.isEmpty() || input.charAt(0) != 'n');
  }
}
