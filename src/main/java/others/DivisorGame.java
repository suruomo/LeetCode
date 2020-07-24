package others;

/**
 * @author suruomo
 * @date 2020/7/24 15:55
 * @description: 1025
 * 爱丽丝和鲍勃一起玩游戏，他们轮流行动。爱丽丝先手开局。
 *
 * 最初，黑板上有一个数字 N 。在每个玩家的回合，玩家需要执行以下操作：
 *
 * 选出任一 x，满足 0 < x < N 且 N % x == 0 。
 * 用 N - x 替换黑板上的数字 N 。
 * 如果玩家无法执行这些操作，就会输掉游戏。
 *
 * 只有在爱丽丝在游戏中取得胜利时才返回 True，否则返回 false。假设两个玩家都以最佳状态参与游戏。
 */
public class DivisorGame {
    /**
     * N=1 的时候，区间 (0,1) 中没有整数是 n的因数，所以此时 Alice 败。
     * N = 2N的时候，Alice 只能拿 1，N 变成 1，Bob 无法继续操作，故 Alice 胜。
     * N = 3 的时候，Alice 只能拿 1，N 变成 2，根据 N=2 的结论，我们知道此时 Bob 会获胜，Alice 败。
     * N = 4 的时候，Alice 能拿 1 或 2，如果 Alice 拿 1，根据 N=3 的结论，Bob 会失败，Alice 会获胜。
     * N = 5的时候，Alice 只能拿 1，根据 N = 4 的结论，Alice 会失败。
     *
     * N 为奇数的时候 Alice（先手）必败，N 为偶数的时候 Alice 必胜
     * @param N
     * @return
     */
    public boolean divisorGame(int N) {
        return N%2==0;
    }
}
