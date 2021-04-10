package com.example.demo.Labs.PranavInheritence.Technicals;

public class LinkedList {
    private Object curr;
    private LinkedList prev;
    private LinkedList next;

    public LinkedList(Object curr, LinkedList node){
        setObject(curr);
        setprev(prev);
        setnext(null);
    }

    public LinkedList(LinkedList node){
        curr = node.curr;
        prev = node.prev;
        next = node.next;
    }

    public void setObject(Object curr){
        this.curr=curr;
    }

    public void setprev(LinkedList node){
        this.prev = node;
    }

    public void setnext(LinkedList node){
        this.next=node;
    }

    public Object getObject(){
        return curr;
    }

    public LinkedList getprev(){
        return prev;
    }

    public LinkedList getnext(){
        return next;
    }
}
