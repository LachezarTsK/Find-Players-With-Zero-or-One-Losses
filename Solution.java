
import java.util.List;
import java.util.ArrayList;

public class Solution {

    private static final int MAX_NUMBER_OF_PLAYERS = (int) Math.pow(10, 5);

    public List<List<Integer>> findWinners(int[][] matches) {
        int[] wins = new int[MAX_NUMBER_OF_PLAYERS + 1];
        int[] losses = new int[MAX_NUMBER_OF_PLAYERS + 1];
        for (int[] match : matches) {
            ++wins[match[0]];
            ++losses[match[1]];
        }

        List<Integer> playersWithoutLosses = new ArrayList<>();
        List<Integer> playersWithOneLoss = new ArrayList<>();
        for (int i = 1; i <= MAX_NUMBER_OF_PLAYERS; ++i) {
            if (wins[i] > 0 && losses[i] == 0) {
                playersWithoutLosses.add(i);
            } else if (losses[i] == 1) {
                playersWithOneLoss.add(i);
            }
        }

        return List.of(playersWithoutLosses, playersWithOneLoss);
    }
}
