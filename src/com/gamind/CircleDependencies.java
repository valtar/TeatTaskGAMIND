package com.gamind;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Valery
 * Date: 27.11.15
 * Time: 17:41
 * To change this template use File | Settings | File Templates.
 */
public class CircleDependencies{

    private static class Pair{
        public Integer id;
        public Integer dependsOnID;

        public Pair(Integer id, Integer depends){
            this.id = id;
            this.dependsOnID = depends;
        }
    }

    public static void printDependency(Pair[] pairs){
        String s = "";
        for (int i = 0; i < pairs.length; i++) {
            for (int j = 0; j < pairs.length && pairs[i].id < pairs[i].dependsOnID; j++) {
                if(pairs[i].dependsOnID == pairs[j].id){
                    s = pairs[i].id + " " + pairs[j].id + " " + pairs[j].dependsOnID;
                    System.out.println(s);
                }

            }
        }
    }

    public static void getStringDependency(Pair[] pairs, Integer first, Integer prevDependacy, String s){
        for(Pair pair : pairs){
            Boolean isCircled = false;
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(pair.id);
            list.add(pair.dependsOnID);

            Boolean flag = true;
            while(flag){
                for(Pair pair2 : pairs){
                    if(pair2.id == pair.dependsOnID){

                    }
                }
            }


        }
        String ss = "";
        for(Pair pair : pairs){
            s += pair.id;
        }


    }

    public static String searchDependecy(Pair previoisPair, String answer, int firstID, Pair[] pairs){
        answer += previoisPair.id + " ";

        if(previoisPair.id == previoisPair.dependsOnID){
            return null;
        }
        

        if(previoisPair.dependsOnID == firstID){
            return answer + previoisPair.dependsOnID;
        }
        for(Pair pair : pairs){
            
            //to avoid circle dependycies like 1 4 5 6 5 6 ...
            if(pair.dependsOnID == previoisPair.id && pair.id == previoisPair.dependsOnID && pair.dependsOnID != firstID){
                continue;
            }
            if(pair.id == previoisPair.dependsOnID){
                Pair[] pairs2 = createNewPairExceptThis(pairs,pair);
                String temp =  searchDependecy(pair, answer, firstID, pairs2);
                if(temp != null){
                    return temp;
                }
            }
        }

        return null;

    }

    private static Pair[] createNewPairExceptThis(Pair[] pairs, Pair pair) {
        Pair[] pairs2 = new Pair[pairs.length -1];
        int count = 0;
        for(Pair p : pairs){
            if(pair.id == p.id && pair.dependsOnID == p.dependsOnID){
                continue;
            }
            pairs2[count] = p;
            count++;
        }
        return pairs2;
    }

    public static void main(String[] args) {
        Pair[] pairs = new Pair[] {
        new Pair(1,2),
        new Pair(2,1),
        new Pair(3,4),
        new Pair(5,6),
        new Pair(6,5),
        new Pair(1,4),
        new Pair(4,5),
        new Pair(5,1)
        };

//        CircleDependencies.printDependency(pairs);
//        int ind = 2;
//        String s = searchDependecy(pairs[ind], "", pairs[ind].id, pairs);
//        System.out.println(s);
        for(Pair p : pairs){
            System.out.println(searchDependecy(p, "", p.id, pairs));
        }

    }



}
