package com.wenky.ds;

import sun.plugin2.gluegen.runtime.CPU;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A System has some capacity
 * Input :capacity,list of forground process with processId & cpu capcity need to run the process,List of background process
 * Find a pair of foreground process & background process,so that maximum utilization of cpu is utilized
 */
public class AmazonProcessorProblem {

    static final int RESERVED_SPACE=30;
    static final int CPU_POWER_IND=1;
    static final int PROCESS_ID_IND=0;
    List<List<Integer>> getThePairofForgroundBackgroundProcess(int cpuCapacity,List<List<Integer>> foregroundProcessList,List<List<Integer>> backgroundProcessList){
        List<List<Integer>> result=new ArrayList<>();
        int start=0;
        result.add(foregroundProcessList.get(start));
        for(int i=start+1;i<backgroundProcessList.size();i++){
            System.out.println("comparing "+foregroundProcessList.get(start)+","+backgroundProcessList.get(i)+",current Packages"+result);

            int currentCpuUsage=foregroundProcessList.get(start).get(CPU_POWER_IND)+backgroundProcessList.get(i).get(CPU_POWER_IND);

            boolean isThePair=result.size()==1;


            if(currentCpuUsage<=cpuCapacity && isThePair){

                result.add(Arrays.asList(foregroundProcessList.get(start).get(PROCESS_ID_IND),backgroundProcessList.get(i).get(PROCESS_ID_IND)));
            }

            if(i==backgroundProcessList.size()-1){
                start=start+1;
                if(start>=backgroundProcessList.size()-1)
                    break;
                i=start;
            }
        }

        if(result.size()!=2)
            result.clear();

        return result;
    }
    public static void main(String[] args) {

        List<List<Integer>> foregroundProcessList=new ArrayList<>();
        foregroundProcessList.add(Arrays.asList(10,20));

        List<List<Integer>> backgroundProcessList=new ArrayList<>();
        backgroundProcessList.add(Arrays.asList(20,30));

        System.out.println(new AmazonProcessorProblem().getThePairofForgroundBackgroundProcess(80, foregroundProcessList,backgroundProcessList));

    }
}
