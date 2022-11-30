
#include <array>
#include <vector>
using namespace std;

class Solution {
    
    inline static const int MAX_NUMBER_OF_PLAYERS = 1E5;
    
public:
    vector<vector<int>> findWinners(const vector<vector<int>>& matches) const {
        array<int, MAX_NUMBER_OF_PLAYERS + 1 > wins{};
        array<int, MAX_NUMBER_OF_PLAYERS + 1 > losses{};
        for (const auto& match : matches) {
            ++wins[match[0]];
            ++losses[match[1]];
        }

        vector<int> playersWithoutLosses;
        vector<int> playersWithOneLoss;
        for (int i = 1; i <= MAX_NUMBER_OF_PLAYERS; ++i) {
            if (wins[i] > 0 && losses[i] == 0) {
                playersWithoutLosses.push_back(i);
            } else if (losses[i] == 1) {
                playersWithOneLoss.push_back(i);
            }
        }
        
        return vector<vector<int>> { playersWithoutLosses, playersWithOneLoss };
    }
};
