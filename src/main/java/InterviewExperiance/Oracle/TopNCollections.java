package InterviewExperiance.Oracle;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/*
file1, size: 100, collections = {col1, col2}
file2, size: 200, collections = {col1}
file3, size: 400, collections = {col3}

large number of files (1 million or so)
large number of collections (1 million or so)

Give me top N collections by size. (N is small) N = 10

 */
public class TopNCollections {
    private class Collection{
        String name;
        long size;

        public Collection(String name){
            this.name = name;
            this.size = 0;
        }
    }

    private class File{
        String name;
        int size;
        List<String> collections;
    }

    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<String>();
        strings.add("Hello, World!");
        strings.add("Welcome to CoderPad.");
        strings.add("This pad is running Java " + Runtime.version().feature());

        for (String string : strings) {
            System.out.println(string);
        }
    }

    private List<String> findTopNCollectionsBySize(List<File> files, int n){
        int s = files.size();
        List<String> topCol = new ArrayList<>();

        PriorityQueue<Collection> pq = new PriorityQueue<>(n, (c1, c2) -> (int)(c1.size - c2.size));

        HashMap<String, Collection> colSize = new HashMap<>();

        for(File file : files){
            for(String col : file.collections){
                Collection c1 = colSize.getOrDefault(col, new Collection(col));
                c1.size += file.size;
                colSize.put(col, c1);
            }
        }

        for(String col : colSize.keySet()){
            pq.offer(colSize.get(col));
        }

        while(!pq.isEmpty()){
            topCol.add(pq.remove().name);
        }

        return topCol;
    }
}
