package com.example.demo.Labs.AryanInheritance;

public class LinkedLists {
    private Object opaqueObject;
    private LinkedLists prevNode;
    private LinkedLists nextNode;

    public LinkedLists(Object opaqueObject, LinkedLists node)
    {
        setObject(opaqueObject);
        setPrevNode(node);
        setNextNode(null);
    }

    public LinkedLists(LinkedLists node)
    {
        opaqueObject = node.opaqueObject;
        prevNode = node.prevNode;
        nextNode = node.nextNode;
    }

    public void setObject(Object opaqueObject)
    {
        this.opaqueObject = opaqueObject;
    }

    public void setPrevNode(LinkedLists node)
    {
        this.prevNode = node;
    }

    public void setNextNode(LinkedLists node)
    {
        this.nextNode = node;
    }

    public Object getObject()
    {
        return opaqueObject;
    }

    public LinkedLists getPrevious()
    {
        return prevNode;
    }

    public LinkedLists getNext()
    {
        return nextNode;
    }

}
