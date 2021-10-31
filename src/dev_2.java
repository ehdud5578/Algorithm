public class dev_2 {
    public static void main(String[] args) {
        int result = new Solution().solution(4,"FRI", new int[]{6, 21, 23, 27, 28});
        int result2 = new Solution().solution(3,"SUN", new int[]{2, 6, 17, 29});
        System.out.println("result2 = " + result2);
        System.out.println("result = " + result);
        int result3 = new Solution().solution(30,"SUN",new int[]{1});
        System.out.println("result3 = " + result3);
    }
    static class Solution {
        static int[][] month;
        public int solution(int leave, String day, int[] holidays) {
            month = new int[6][7];
            int startPoint = 0;
            switch (day) {
                case "SUN" -> startPoint = -1;
                case "MON" -> startPoint = 0;
                case "TUE" -> startPoint = 1;
                case "WEN" -> startPoint = 2;
                case "TUR" -> startPoint = 3;
                case "FRI" -> startPoint = 4;
                case "SAT" -> startPoint = 5;
            }
            for(int i = 1; i <= 30; i++){
                int dd = startPoint + i;
                if(dd%7==0||dd%7==6)
                    month[dd/7][dd%7] = -1;
                else
                    month[dd/7][dd%7] = i;
            }
            for(int i = 0;i<holidays.length;i++){
                int d = startPoint + holidays[i];
                month[d/7][d%7] = -1;
            }
            int answer = 0;
            for(int i = 1;i<=31-leave;i++){
                answer = Math.max(vacationcnt(leave,i+ startPoint), answer);
            }
            return answer;
        }
        static int vacationcnt(int leave,int startpoint){
            int result = 0;
            for(int i = startpoint;i<30+startpoint;i++){
                if (month[i/7][i%7]==-1){
                    result++;
                }
                else{
                    if(leave==0)
                        break;
                    if(leave>=1){
                        leave--;
                        result++;
                    }
                }
            }
            return result;
        }
    }

}
