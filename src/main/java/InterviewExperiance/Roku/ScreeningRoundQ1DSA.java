package InterviewExperiance.Roku;

import java.util.HashMap;
import java.util.Map;

/*

Given a stream of character, implement 2 methods where
1) First method will accept a character as an input which is to be stored in a data structure
2) Second Method will return the first non-repeating character at any time.

It should be a constant - O(1) time operation.


accept(a);
accept(b);
getFirstNonRepeatingCharacter() // should return 'a'
getFirstNonRepeatingCharacter() // should return 'a'
accept(a)
getFirstNonRepeatingCharacter() // should return 'b'


Note: Characters can appear in any sequence.


*/

public class ScreeningRoundQ1DSA {
        private static class Node{
            int freq;
            DLL address;

            public Node(int freq, DLL address){
                this.freq = freq;
                this.address = address;
            }
        }

        private static class DLL{
            DLL prev;
            DLL next;
            char c;

            public DLL(char c){
                this.c = c;
            }
        }

        private static Map<Character, Node> acceptedChars;
        private static DLL head;
        private static DLL tail;

        public static void main(String[] args) {

            //Main main = new Main();

            acceptedChars = new HashMap<>();
            head = new DLL(' ');
            tail = new DLL(' ');
            head.next = tail;
            tail.prev = head;


            accept('a');
            accept('b');
            Character ans = getFirstNonRepeatingCharacter(); // should return 'a'
            System.out.println(ans);
            Character ans1 = getFirstNonRepeatingCharacter();// should return 'a'
            System.out.println(ans1);
            accept('a');
            Character ans2 = getFirstNonRepeatingCharacter(); // should return 'b'
            System.out.println(ans2);

            accept('a');
            System.out.println(getFirstNonRepeatingCharacter());

            accept('b');
            System.out.println(getFirstNonRepeatingCharacter());

            System.out.println(getFirstNonRepeatingCharacter());

        }

        public static void accept(char c){
            if(!acceptedChars.containsKey(c)){
                DLL address = new DLL(c);
                acceptedChars.put(c, new Node(1, address));

                //Update the LL
                addNodeToDLL(address);

            }else{
                Node cur = acceptedChars.get(c);
                //Increase freq
                cur.freq += 1;
                //Remove from DLL
                removeNodeToDLL(cur.address);
            }
        }

        public static Character getFirstNonRepeatingCharacter(){
            if(head.next != tail){
                return head.next.c;
            }

            return null;
        }

        private static void addNodeToDLL(DLL node){
            DLL lastNode = tail.prev;
            tail.prev = node;
            lastNode.next = node;
            node.next = tail;
            node.prev = lastNode;
        }

        private static void removeNodeToDLL(DLL node){
            DLL prev = node.prev;
            DLL next = node.next;
            prev.next = next;
            next.prev = prev;
        }

}
