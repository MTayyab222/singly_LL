    public class demoo {
        class node{
            int data;
            node next;
            node(int data){
                this.data=data;
            }

        }
        node head;
        int size=0;
        public boolean isEmpty(){
            if (head==null){
                return true;
            }
            else {
                return false;
            }
        }
        public void add_first(int data){
            node n=new node(data);
            if (head==null){
                head=n;
                size++;
                return;
            }
            else {
                node temp=head;
                n.next=head;
                head=n;
                size++;
            }
        }
        public void add_last(int data){
            node n=new node(data);
            if (head==null){
                head=n;
                size++;
                return;
            }
            else {
                node temp=head;
                while (temp.next!=null){
                    temp=temp.next;
                }temp.next=n;
                size++;
            }

        }
//        public void add_specific(int data,int p){
//            node n=new node(data);
//            if (head==null){
//                head=n;
//                size++;
//                return;
//
//            }
//            if (p == 1) {
//                n.next = head;
//                head = n;
//                size++;
//
//            }
//
//
//            else {
//                node current=head;
//                for (int i=1;i<p-1;i++){
//                    current=current.next;
//                }n.next=current.next;
//                current.next=n;
//                size++;
//            }
//        }

//        public void add_specific(int data, int p) {
//            node n = new node(data);
//            if (head == null) {
//                if (p == 1) {
//                    head = n;
//                    size++;
//                } else {
//                    System.out.println("Position " + p + " is invalid. List is empty.");
//                }
//                return;
//            }
//
//            if (p == 1) {
//                n.next = head;
//                head = n;
//                size++;
//                return;
//            }
//
//            node current = head;
//            for (int i = 1; i < p - 1; i++) {
//                if (current == null) {
//                    System.out.println("Position " + p + " is invalid. List size is " + size);
//                    return;
//                }
//                current = current.next;
//            }
//            n.next = current.next;
//            current.next = n;
//            size++;
//        }

        public void add_specific(int data, int p) {
            node n = new node(data);
            if (p < 1 || p > size) {
                System.out.println("Invalid position: " + p);
                return;
            }

            if (p == 1) {
                n.next = head;
                head = n;
            } else {
                node current = head;
                for (int i = 1; i < p - 1; i++) {
                    current = current.next;
                }
                n.next = current.next;
                current.next = n;
            }
            size++;
        }


        public void delete_first(){
            node temp=head;
            if (head==null){
                System.out.println("List is empty: ");
            }
            else {
                temp=temp.next;
                head=temp;
                size--;
            }
        }
        public void delete_last(){
            if (head==null){
                System.out.println("List is empty: ");
            }
            else if (head.next == null){ // Special case: Only one element in the list
                head = null;
                size--;
            }
            else {
                node temp=head;
                node ptr=temp.next;
                while (ptr.next!=null){
                    temp=ptr.next;
                }temp.next=null;
                size--;
            }
        }
        public void delete_specific(int p){
            if (head==null){
                System.out.println("List is empty: ");
            }
            else {
                node temp=head;
                for (int i=1;i<p-1;i++){
                    temp=temp.next;
                }temp.next=temp.next.next;
                size--;
            }

        }
        public int getSize(){
            return size;
        }
        public void print(){
            node temp=head;
            while (temp.next!=null){
                System.out.print(" "+temp.data);
                temp=temp.next;
            }
            System.out.print(" "+temp.data);
        }

        public static void main(String[] args) {
            demoo d=new demoo();
            System.out.println("Before anything is done: ");
            System.out.println("List is empty: "+d.isEmpty());
            d.add_first(90);
            d.add_first(85);
            d.add_first(80);
            d.add_first(75);
            d.add_first(70);
            d.add_last(95);
            d.add_last(100);
            d.add_last(105);
            System.out.println("Addition in first and at last: ");
            d.print();
            System.out.println("\nThe size is:"+d.getSize());
            d.add_specific(2,7);
            d.print();
            System.out.println("\nThe size is: "+d.getSize());
        }
    }
