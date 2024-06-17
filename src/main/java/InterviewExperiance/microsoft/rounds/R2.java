package InterviewExperiance.microsoft.rounds;

import java.util.*;

//WAp that checks if an object array is a rotation of another.
public class R2 {
    public static void main(String [] args) {
        // you can write to stdout for debugging purposes, e.g.
        Character[] arr1 = {'a', 'b', 'c', 'd'};
        Character[] arr2 = {'b', 'c', 'd', 'a'};

        boolean isRotated = checkRotation(arr1, arr2);

        System.out.println(isRotated);


        Character[] arr3 = {'a', 'b', 'c', 'd'};
        Character[] arr4 = {'c', 'd', 'a', 'b'};

        isRotated = checkRotation(arr3, arr4);

        System.out.println(isRotated);


        Character[] arr5 = {'a', 'b', 'c', 'd'};
        Character[] arr6 = {'b', 'd', 'c'};

        isRotated = checkRotation(arr5, arr6);

        System.out.println(isRotated);

//abbcdaa, aabbcda

        Character[] arr7 = {'a', 'b', 'b', 'c', 'd', 'a', 'a'};
        Character[] arr8 = {'a', 'a', 'b', 'b', 'c', 'd', 'a'};

        isRotated = checkRotation(arr7, arr8);

        System.out.println(isRotated);
    }

    private static boolean checkRotation(Object[] arr1, Object[] arr2){
        int n1 = arr1.length;
        int n2 = arr2.length;

        //Length check
        if(n1 != n2 || n1 == 0){
            return false;
        }

        //Freq check

        //Rotation check
        List<Integer> indexes = findObjectIndex(arr1[0], arr2);

        if(indexes.size() == 0){
            return false;
        }

        for(int idx : indexes){
            if(compareArray(arr1, arr2, idx)){
                return true;
            }
        }

        return false;

    }

    private static boolean compareArray(Object[] arr1, Object[] arr2, int idx){
        int n1 = arr1.length;
        int n2 = arr2.length;
        int i = 0;
        while(i<n1){
            if(!arr1[i].equals(arr2[idx])){
                return false;
            }
            ++i;
            ++idx;
            if(idx >= n2){
                idx = 0;
            }
        }

        return true;
    }

    private static List<Integer> findObjectIndex(Object o, Object[] arr2){
        List<Integer> indexes = new ArrayList<>();
        for(int i=0;i<arr2.length; ++i){
            if(arr2[i].equals(o)){
                indexes.add(i);
            }
        }

        return indexes;
    }
}
