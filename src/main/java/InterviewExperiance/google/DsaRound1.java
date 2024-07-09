package InterviewExperiance.google;

// We have a bit array  A  of size  N,  accessible through some database system
// providing an API  query(L, R)  that returns
// - true  if at least one of the bits in  A[L] .. A[R]  is set to 1,
// - false  otherwise.
//
// Assuming that the array is sparse (i.e., few of its bits are set to 1),
// we want to find the positions of all bits set to 1,
// using a reasonable number of queries.
//
// Example:
//
//    N = 11
//    A = { 0, 1, 1, 0, 0,   0, 0, 0, 0, 0,   1 }
//
//  The expected outcome is:
//
//    { 1, 2, 10 }


//0 to N-1
//        0 to N-1/2 and N-1/2 + 1 to N-1


// W - "weight": number of bits that are set to 1

//  W < N

// O(W log N)

//O(W) + O(log N)

import java.util.ArrayList;
import java.util.List;

// L=0 R = N-1
// Mid
public class DsaRound1 {


    public List<Integer> setBitPositions(int N){
        List<Integer> setBits = new ArrayList<>();

        setBitPositionsHelper(0, N-1, setBits);

        return setBits;
    }

    private void setBitPositionsHelper(int L, int R, List<Integer> setBits){
        boolean isSetBitPresent = query(L, R);

        if(!isSetBitPresent){
            return;
        }

        if(L == R){
            setBits.add(L);
            return;
        }

        int mid = L + (R - L)/2;

        setBitPositionsHelper(L, mid, setBits);

        setBitPositionsHelper(mid + 1, R, setBits);

    }

    private boolean query(int L, int R){
        return true;
    }

}
