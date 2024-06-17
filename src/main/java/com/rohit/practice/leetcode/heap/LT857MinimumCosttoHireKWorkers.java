package com.rohit.practice.leetcode.heap;

import java.util.*;

public class LT857MinimumCosttoHireKWorkers {

    private class Worker{
        double ratio;
        int quality;

        public Worker(double ratio, int quality){
            this.quality = quality;
            this.ratio = ratio;
        }

        public double getRatio(){
            return this.ratio;
        }

        public int getQuality(){
            return this.quality;
        }
    }
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;
        int totalQuality = 0;
        double totalWage = Double.MAX_VALUE;

        List<Worker> wageToQualityRatio = new ArrayList<>();
        PriorityQueue<Integer> qualityHeap = new PriorityQueue<>((q1, q2) -> q2-q1);

        for(int i=0;i<n;++i){
            wageToQualityRatio.add(
                    new Worker((double)wage[i]/quality[i], quality[i])
            );
        }

        Collections.sort(wageToQualityRatio, Comparator.comparingDouble(Worker::getRatio));

        for(Worker ratio : wageToQualityRatio){
            double rate = ratio.getRatio();
            int qty = ratio.getQuality();

            qualityHeap.offer(qty);
            totalQuality += qty;

            if(qualityHeap.size() > k){
                totalQuality -= qualityHeap.remove();
            }

            if(qualityHeap.size() == k){
                totalWage = Math.min(
                        totalWage,
                        totalQuality * rate
                );
            }
        }

        return totalWage;
    }
}
