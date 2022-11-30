
/**
 * @param {number[][]} matches
 * @return {number[][]}
 */
var findWinners = function (matches) {

    const MAX_NUMBER_OF_PLAYERS = Math.pow(10, 5);
    const wins = new Array(MAX_NUMBER_OF_PLAYERS + 1).fill(0);
    const losses = new Array(MAX_NUMBER_OF_PLAYERS + 1).fill(0);
    for (let match of matches) {
        ++wins[match[0]];
        ++losses[match[1]];
    }

    const playersWithoutLosses = [];
    const playersWithOneLoss = [];
    for (let i = 1; i <= MAX_NUMBER_OF_PLAYERS; ++i) {
        if (wins[i] > 0 && losses[i] === 0) {
            playersWithoutLosses.push(i);
        } else if (losses[i] === 1) {
            playersWithOneLoss.push(i);
        }
    }
    return [playersWithoutLosses, playersWithOneLoss];
};
