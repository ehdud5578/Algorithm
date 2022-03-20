package Programmers;

import java.util.*;

public class 신고_결과_받기 {
    public static void main(String[] args) {
        int[] answer = new Solution().solution(new String[]{"con", "ryan"}, new String[]{"ryan con", "ryan con", "ryan con", "ryan con"}, 2);
        System.out.println("answer = " + Arrays.toString(answer));
        int[] answer1 = new Solution().solution(new String[]{"muzi", "frodo", "apeach", "neo"}, new String[]{"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"}, 2);
        System.out.println("answer1 = " + Arrays.toString(answer1));
    }
    static class Solution {
        public int[] solution(String[] id_list, String[] report, int k) {
            int[] answer = new int[id_list.length];
            int[] countReport = new int[id_list.length];
            HashMap<String,Integer> getId = new HashMap<>();
            for (int i = 0;i<id_list.length;i++){
                getId.put(id_list[i], i);
            }
            HashSet<String> removedReport = new HashSet<>(Arrays.asList(report));
            ArrayList<String>[] member = new ArrayList[id_list.length];
            for (int i = 0;i<id_list.length;i++){
                member[i] = new ArrayList<>();
            }
            for (String removed : removedReport){
                String[] removedId = removed.split(" ");
                member[getId.get(removedId[0])].add(removedId[1]);
                countReport[getId.get(removedId[1])]++;
            }
            for (int i = 0;i< member.length;i++){
                if (countReport[i]>=k){
                    for (int j = 0;j<id_list.length;j++){
                        if (member[j].contains(id_list[i])){
                            answer[getId.get(id_list[j])]++;
                        }
                    }

                }
            }
            return answer;
        }
    }
}
