package ebay;

import java.util.Arrays;

public class sol2 {
    public static void main(String[] args) {
        String result = new Solution().solution(new int[]{5, 7, 2, 4, 9}, 3);
        String result1 = new Solution().solution(new int[]{4, 2, 2, 1, 4}, 1);
        System.out.println("result = " + result);
        System.out.println("result1 = " + result1);
    }

    static class Solution {
        private static int answer;
        private static int maxlen;
        public String solution(int[] stones, int k) {
            answer = Integer.MIN_VALUE;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < stones.length; i++) {
                max = Math.max(max, stones[i]);
                min = Math.min(min, stones[i]);
            }
            maxlen = max + min;
            if (max + min < k)
                return "-1";
            else {
                dfs(stones, k, 0, new StringBuilder(), max, 0);
                if (answer == Integer.MIN_VALUE)
                    return "-1";
                else
                    return String.valueOf(answer);
            }
        }

        public void dfs(int[] stones, int k, int cnt, StringBuilder result, int max, int deep) {
            if (cnt >= 2) {
                boolean check = false;
                for (int i = 0; i < stones.length; i++) {
                    if (check && stones[i] != 0)
                        return;
                    if (stones[i] != 0) {
                        check = true;
                    }
                }
                for (int i = 0; i < stones.length; i++) {
                    if (stones[i] != 0) {
                        if (stones[i] == k) {
                            String aa = String.valueOf(answer);
                            if (aa.length() >= result.toString().length())
                                answer = Math.max(answer, Integer.parseInt(String.valueOf(result)));
                        }
                    }
                }
            }
            if (deep < maxlen)
                for (int i = stones.length - 1; i >= 0; i--) {
                    if (stones[i] == max)
                        continue;
                    int thismin = Integer.MAX_VALUE;
                    for (int j = 0; j < stones.length; j++) {
                        if (j == i)
                            continue;
                        thismin = Math.min(thismin, stones[j]);
                    }
                    if (thismin == 0)
                        continue;
                    int[] nextstone = new int[stones.length];
                    StringBuilder nextresult = new StringBuilder(result);
                    System.arraycopy(stones, 0, nextstone, 0, stones.length);
                    int nextcnt = 0;
                    for (int i1 = 0; i1 < stones.length; i1++) {
                        if (nextstone[i1] == 1) {
                            nextcnt += 1;
                        }
                        nextstone[i1] -= 1;

                    }
                    if (nextstone[i] == 0)
                        nextcnt -= 1;
                    nextstone[i] += 2;
                    dfs(nextstone, k, nextcnt, nextresult.append(i), max - 1, deep + 1);
                }
        }
    }
}


//    문제 설명
//    돌무더기 게임은 여러 돌무더기에서 돌을 하나씩 추가하거나 제거하여, 하나의 돌무더기만 남기는 게임입니다. 게임에서 승리하기 위해서는 마지막에 남은 하나의 돌무더기의 돌 수가 정확히 k개가 되어야 합니다.
//
//        처음 주어지는 돌무더기들은 각각 1개 이상의 돌을 갖고 있습니다. 당신은 한 돌무더기를 골라 다음과 같은 행동을 할 수 있습니다.
//
//        선택한 돌무더기에 돌을 1개 추가합니다. 동시에, 선택되지 않은 나머지 돌무더기에서 각각 1개씩 돌을 제거합니다.
//        돌을 제거해야 할 나머지 돌무더기 중에서 제거할 돌이 없는 경우(=돌 수가 0인 경우), 위 행동은 실행할 수 없습니다.
//        예를 들어 3개의 돌무더기에 돌이 각각 [1, 3, 2]개 있고 k가 3인 경우, 게임에서 승리하는 가장 빠른 방법은 아래와 같이 2가지가 있습니다.
//
//        첫 번째 - 세 번째 - 세 번째 돌무더기를 차례대로 선택합니다. 각 선택 시에 돌무더기의 돌 수는 [2, 2, 1] - [1, 1, 2] - [0, 0, 3]과 같이 변합니다.
//        세 번째 - 첫 번째 - 세 번째 돌무더기를 차례대로 선택합니다. 각 선택 시에 돌무더기의 돌 수는 [0, 2, 3] - [1, 1, 2] - [0, 0, 3]과 같이 변합니다.
//        선택하는 돌무더기의 인덱스를 순서대로 나열하여 문자열로 변환하면 1번 방법은 "022", 2번 방법은 "202"입니다. 이를 사전 순으로 정렬했을 때, 가장 뒤에 오는 방법은 "202"입니다.
//
//        각 돌무더기의 돌 수를 나타내는 정수 배열 stones, 남겨야 하는 한 돌무더기의 돌 수를 나타내는 정수 k가 매개변수로 주어집니다. 게임에서 승리하기 위한 가장 빠른 방법 중에서, 선택하는 돌무더기의 인덱스를 문자열로 변환했을 때 사전 순으로 가장 뒤에 오는 방법을 return 하도록 solution 함수를 완성해주세요. 만약 어떤 방법으로도 목표를 달성할 수 없다면 "-1"을 return 해주세요.
//
//        제한사항
//        2 ≤ stones의 길이 ≤ 8
//        1 ≤ stones의 원소 ≤ 12
//        1 ≤ k ≤ 24
//        돌 수가 0인 돌무더기도 선택할 수 있는 돌무더기입니다.
//        입출력 예
//        stones	k	result
//        [1, 3, 2]	3	"202"
//        [4, 2, 2, 1, 4]	1	"3213"
//        [5, 7, 2, 4, 9]	20	"-1"
//        입출력 예 설명
//        입출력 예 #1
//
//        문제 예시와 같습니다.
//
//        입출력 예 #2
//
//        네 번째 - 세 번째 - 두 번째 - 네 번째 순으로 돌무더기를 선택하면 아래 표와 같이 돌 수가 변합니다.
//
//        선택한 돌무더기의 인덱스	stones
//        -	[4, 2, 2, 1, 4]
//        3	[3, 1, 1, 2, 3]
//        2	[2, 0, 2, 1, 2]
//        1	[1, 1, 1, 0, 1]
//        3	[0, 0, 0, 1, 0]
//        따라서 "3213"을 return 합니다.
//
//        입출력 예 #3
//
//        어떤 방법으로도 마지막에 남길 한 돌무더기를 20으로 만들 수 없습니다. 따라서 "-1"을 return 합니다.