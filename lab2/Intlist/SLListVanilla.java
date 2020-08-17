public class SLListVanilla {
        private class IntNode {
            public int item;
            public IntNode next;

            public IntNode(int i, IntNode n) {
                item = i;
                next = n;
            }
        }

        private IntNode first;

        public SLListVanilla(int x){
            first = new IntNode(x,null);
        }

        public void addFirst(int x){
            first = new IntNode(x, first);
        }

        //iteratively reverse a SLL
        /**
        public void reverse() {
            IntNode active = first.next;
            first.next = null;
            IntNode hold = active;
            while (active != null) {
                hold = hold.next;
                active.next = first;
                first = active;
                active = hold;
            }
        }*/

        /** recursively reverse a SLL*/
        public void reverse(){
             first = reverse(first);
        }

        public IntNode reverse(IntNode first){

            if (first.next == null)
                return first;
            IntNode hold = first.next;
            IntNode newHead = reverse(first.next);
            hold.next = first;
            first.next = null;
            return newHead;
        }

        public static void main(String[] args) {
            SLListVanilla L = new SLListVanilla(7);
            L.addFirst(5);
            L.addFirst(10);
            L.addFirst(25);
            L.reverse();



        }








    }
