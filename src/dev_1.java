import java.util.Arrays;

public class dev_1 {

    public static void main(String[] args) {
        String result = new Solution().solution(new String[]{"card", "ace13", "ace16", "banker", "ace17", "ace14"}, "ace14");
        String result1 = new Solution().solution(new String[]{"cow", "cow1", "cow2", "cow3", "cow4", "cow9", "cow8", "cow7", "cow6", "cow5"}, "cow");
        System.out.println(result);
        System.out.println(result1);
    }

    static class Solution {
        public String solution(String[] registered_list, String new_id) {
            Arrays.sort(registered_list);
            int checknum = isContainId(registered_list,new_id);
            if(checknum == -1){ // newid 없을 경우 그대로 return
                return new_id;
            }
            for(int i = checknum;i< registered_list.length;i++) {
                if (!new_id.equals(registered_list[i])){ // new id 가 리스트에 없으면 브레이크
                    break;
                }
                String thisid = registered_list[i];
                int numindex = 0;
                for(int k = 0;k<thisid.length();k++){
                    if(thisid.toCharArray()[k] >= 97) {
                    }
                    else {
                        numindex = k;
                        break;
                    }
                }
                if (numindex != 0){ // 숫자가 원래있을 경우
                    String front = thisid.substring(0,numindex);
                    String back = thisid.substring(numindex,thisid.length());
                    int backnum = Integer.parseInt(back)+1;
                    new_id = front + backnum;
                }else{ // 숫자가 있을 경우
                    new_id = thisid + "1";
                }
            }
            return new_id;
        }
        static int isContainId(String[] registered_list, String new_id){
            int checknum = -1;
            for(int i = 0;i< registered_list.length;i++){
                if(registered_list[i].equals(new_id)){
                    checknum = i;
                    break;
                }
            }
            return checknum;
        }
    }

}