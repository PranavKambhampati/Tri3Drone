package com.example.demo.Labs.PranavInheritence.Technicals;
import com.example.demo.Labs.PranavInheritence.Technicals.LinkedList;



public class CircleQueue {

    private LinkedList head;
    private LinkedList tail;
    private LinkedList current;

    public CircleQueue(){
        head = null;
        tail = null;
        current = null;
    }

    public Object getFirst(){
        current = head;

        if(head == null){
            return null;
        } else{
            return head.getObject();
        }
    }

    public Object getLast(){
        current = tail;

        if(tail == null){
            return null;
        } else {
            return tail.getObject();
        }
    }

    public Object getObject(){
        if(current == null){
            return null;
        } else{
            return current.getObject();
        }
    }

    public Object setnext(){
        current = current.getnext();

        if(current == null){
            current = head;
        }

        return current.getObject();
    }

    public void setprev(){
        current = current.getprev();

        if(current == null){
            current = tail;
        }
    }

    public void addobj(Object obj){
        tail = new LinkedList(obj, current);

        if(current != null){
            current.setnext(tail);
        }

        current = tail;

        if(head == null){
            head = tail;
        }
    }

    public Object deleteobj(){
        Object obj = null;

        if(head != null) {
            obj = head.getObject();
            head = head.getnext();
            if(head == null){
                tail = head;
            } else {
                head.setprev(null);
            }
        }

        return obj;
    }

    public String toString(){
        StringBuilder queuetostring = new StringBuilder("[");

        LinkedList node = head;

        while(node!=null){
            queuetostring.append("(").append(node.getObject()).append(")");
            node = node.getnext();
            if(node != null){
                queuetostring.append(", ");
            }
        }

        queuetostring.append("]");
        return queuetostring.toString();
    }

    public void InsertionSort(){
        LinkedList node1 = head;
        LinkedList node2 = (node1 == null) ? null : node1.getnext();

        while (node2 != null){
            LinkedList slot1 = node1;
            LinkedList slot2 = node2;

            LinkedList key = new LinkedList(node2);
            String keyText = node2.getObject().toString();

            while(slot1.getObject().toString().compareTo(keyText) > 0){
                slot2.setObject(slot1.getObject());

                slot1 = slot1.getprev();
                slot2 = slot2.getprev();

                if(slot1 == null){
                    break;
                }
            }

            slot2.setObject(key.getObject());

            //advance insertion sort indexes
            node1 = node1.getnext();
            node2 = node2.getnext();
        }
    }

}
