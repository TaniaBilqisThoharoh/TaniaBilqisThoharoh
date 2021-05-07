package Modul4;

public class Linkedlist implements list {
    Node head;
    Node tail;

    @Override
    public boolean isEmpty() {
        return head == null;
    }




    @Override
    public void addFirst(Node input) {
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            input.next = head;
            head = input;
        }

    }

    @Override
    public void addLast(Node input) {
        if (isEmpty()) {
            head = input;
            tail = input;
        } else {
            tail.next = input;
            tail = input;
        }
    }

    @Override
    public void insertAfter(int key, Node input) {
        Node temp = head;
        boolean found = false;
        do {
            if (temp.data == key) {
                input.next = temp.next;
                temp.next = input;
                found = true;
                System.out.println("Memasukan data " + input.data + " Setelah data " + key + " Sukses ");
                break;
            }
            temp = temp.next;
        }
        while (temp != null);
        if (!found)
            System.out.println("Data " + key + " Tidak ditemukan!!! ");
    }


    @Override
    public void insertBefore(int key, Node input) {
        try {
            Node temp = head;
            while (temp != null) {
                if (temp.data == key && temp == head) {
                    this.addFirst(input);
                    System.out.println("memasukan data" + input.data + "sebelum data" + key + "Sukses!!");
                } else if (temp.next.data == key) {
                    input.next = temp.next;
                    temp.next = input;
                    System.out.println(" memasukan data " + input.data + " Setelah data " + key + " Sukses ");

                }
                temp = temp.next;

            }
        } catch (Exception e) {
            System.out.println(" Data " + key + " ");
        }
    }


    @Override
    public void insert(int index, Node input) {
        Node temp = head;
        boolean found = false;
        int i = 0;
        while (temp != null) {
            if (index == 0) {
                this.addFirst(input);
                found = true;
                System.out.println("Data " + input.data + " Berhasil " + "Dimasukkan pada indeks " + index);
                break;
            } else if (i == index - 1) {
                input.next = temp.next;
                temp.next = input;
                found = true;
                System.out.println("Data " + input.data + " Berhasil" + "Dimasukkan pada indeks " + index);
                break;
            } else {
                temp = temp.next;
                i++;
            }
        }
        if (!found) {
            System.out.println(" Index " + index + " Out Of Bound ");
        }
    }


    @Override
    public void replace(int data1, int data2) {
        Node temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.data == data1) {
                temp.data = data2;
                found = true;
                System.out.println("Data " + data1 + " berhasil diganti dengan data " + data2);
                break;
            } else temp = temp.next;
        }
        if (!found) {
            System.out.println("Data" + data1 + "tidak ditemukan dalam Node ");
        }
    }


    @Override
    public void remove(int data) {
        try{
            Node temp = head;
            while (temp != null){
                if(temp.next.data == data){
                    temp.next = temp.next.next;
                    System.out.println("Data "+data+" berhasil dihapus !");
                    break;
                }
                else if((temp.data == data) && (temp == head)){
                    this.removeFirst();
                    System.out.println("Data "+data+" berhasil dihapus !");
                    break;
                }
                temp = temp.next;
            }
        } catch(Exception e){
            System.out.println("Data "+data+" tidak ditemukan dalam Node !");
        }
    }

    @Override
    public void removeFirst() {
        Node temp = head;
        if (!isEmpty()) {
            if (head == tail) {
                head = tail = null;
            } else {
                head = temp.next;
                temp.next = null;
                temp = null;
            }
        } else System.out.println("Data Kosong!");
    }


    @Override
    public void removeLast() {
        Node temp = head;
        if (!isEmpty()) {
            if (tail == head) {
                head = tail = null;
            } else {
                while (temp.next != tail) {
                    temp = temp.next;
                }
                temp.next = null;
                tail = temp;
                temp = null;
            }
        } else System.out.println("Data Kosong!");
    }

    @Override
    public void find(int data) {
        int i = 0;
        boolean found = false;
        Node temp = head;
        while (temp != null) {
            if (temp.data == data) {
                found = true;
                System.out.println(data + " ditemukan pada indeks ke-" + i);
            }
            i++;
            temp = temp.next;
        }
        if (!found) {
            System.out.println("Data tidak ditemukan!");
        }
    }

    @Override
    public void printNode() {
        Node temp;
        temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    @Override
    public int length() {
        Node temp = head;
        int i = 0;
        if (isEmpty()) {
            System.out.println("Data kosong !");
        } else
            while (temp != null) {
                temp = temp.next;
                i++;
            }
        System.out.println("Panjang data : " + i);
        return i;
    }


    //Tugas
    @Override
    public void removeAt(int index) {
        Node temp = head;
        try {
            int i =0;
            while ( temp != null){
                if (index == 0){
                    this.removeFirst();
                    System.out.println("Data pada index " + index + " Berhasil dihapus");
                    break;
                } else if (i == index -1){
                    temp.next = temp.next.next;
                    System.out.println("Data " + index + " Berhasil Dihapus");
                    break;
                } else {
                    temp = temp.next;
                    i++;
                }
            }
        }catch (Exception e){
            System.out.println("Data " + index + "Tidak ditemukan");
        }
    }

    @Override
    public void clear() {
        if (isEmpty()){
            System.out.println(" Data saat ini Kosong !!");
        } else {
            head = null;
            tail= null;
            System.out.println("Data sudah dihapus");
        }
    }
}

