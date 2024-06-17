package InterviewExperiance.Roku;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Round2HM {
    static class Node{
        Character c;
        Node prev;
        Node next;
        public Node(Character c){
            this.c = c;
        }
    }

    private static void addNode(Node tail, Node node){
        Node prev = tail.prev;

        tail.prev = node;
        node.next = tail;

        node.prev = prev;
        prev.next = node;
    }

    private static void removeNode(Node node){
        Node prev = node.prev;
        Node next = node.next;

        prev.next = next;
        next.prev = prev;

        node.prev = null;
        node.next = null;
    }

    static String dedup(String input) {
        Node head = new Node(' ');
        Node tail = new Node(' ');

        head.next = tail;
        tail.prev = head;

        Map<Character, Node> visited = new HashMap<>();

        for(char c : input.toCharArray()){
            if(visited.containsKey(c)){
                Node cur = visited.get(c);
                removeNode(cur);
            }

            Node newNode = new Node(c);
            visited.put(c, newNode);
            addNode(tail, newNode);
        }

        return buildString(head, tail);

    }

    private static String buildString(Node head, Node tail){
        StringBuilder sb = new StringBuilder();

        Node cur = head.next;

        while(cur != tail){
            sb.append(cur.c);
            cur = cur.next;
        }

        return sb.toString();
    }

    static String dedup1(String input) {
        Set<Character> unique = new HashSet<>();

        for(char c : input.toCharArray()){
            unique.add(c);
        }

        int n = unique.size();
        char[] c_arr = new char[n];
        int idx = n-1;
        int i=input.length()-1;
        for(;i>=0;--i){
            char cur = input.charAt(i);
            if(unique.contains(cur)){
                c_arr[idx] = cur;
                --idx;
                unique.remove(cur);
            }
        }

        return new String(c_arr);
    }

    public static void main(String[] args) {
        System.out.println(dedup1("ABBDCBA"));
        System.out.println(dedup1("ADBACCBAC"));
        System.out.println(dedup1("ABA"));
    }
}
