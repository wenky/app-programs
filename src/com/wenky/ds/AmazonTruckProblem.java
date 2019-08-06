package com.wenky.ds;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A truck is there having some device capacity reserving 30 units of it capacity for safety purposes.
 * We have a list of packages to be transferred on the truck each having some weight.
 * Below conditions:
 * At anypoint only 2 packages can be transfered across the truc;
 * when there is more than 1 pair found,pick the one having larget weight
 * the total pair shouldn't weight more than it device capacity.
 */
public class AmazonTruckProblem {

    static final int RESERVED_SPACE=30;
    List<Integer> getThePair(int deviceCapacity,List<Integer> packagesList){
        List<Integer> result=new ArrayList<>();
        int start=0;
        result.add(packagesList.get(start));
        for(int i=start+1;i<packagesList.size();i++){
            System.out.println("comparing "+packagesList.get(start)+","+packagesList.get(i)+",current Packages"+result);

            int currentSum=packagesList.get(start)+packagesList.get(i);

//            boolean canBePackage=result.size()==1 || currentSum>=(result.get(0)+result.get(1));
//            boolean canAlsoBeThePackage=result.size()==1 || Math.max(packagesList.get(start),packagesList.get(i))>Math.max(result.get(0),result.get(1));

            boolean isThePackage= result.size()==1 ||( currentSum>=(result.get(0)+result.get(1)) &&
                    Math.max(packagesList.get(start),packagesList.get(i))>Math.max(result.get(0),result.get(1))
            );
            if(currentSum<=deviceCapacity-RESERVED_SPACE && isThePackage){
                result.clear();
                result.add(packagesList.get(i));
                result.add(packagesList.get(start));
            }

            if(i==packagesList.size()-1){
                start=start+1;
                if(start>=packagesList.size()-1)
                    break;
                i=start;
            }
        }

        if(result.size()!=2)
            result.clear();

        return result;
    }
    public static void main(String[] args) {

        System.out.println(new AmazonTruckProblem().getThePair(80, Arrays.asList(50,20,30,50,10,5)));

    }
}
