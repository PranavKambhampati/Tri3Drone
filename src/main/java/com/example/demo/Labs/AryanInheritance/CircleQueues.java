package com.example.demo.Labs.AryanInheritance;

public class CircleQueues {
        private LinkedLists headNode;
        private LinkedLists tailNode;
        private LinkedLists currentNode;

        public CircleQueues()
        {
            headNode = null;
            tailNode = null;
            currentNode = null;
        }

        public Object getFirstObject()
        {
            currentNode = headNode;

            if (headNode == null)
                return null;
            else
                return headNode.getObject();
        }

        public Object getLastObject()
        {
            currentNode = tailNode;

            if (tailNode == null)
                return null;
            else
                return tailNode.getObject();
        }

        public Object getObject()
        {
            if (currentNode == null)
                return null;
            else
                return currentNode.getObject();
        }

        public Object setNext()
        {
            currentNode = currentNode.getNext();

            if (currentNode == null)
                currentNode = headNode;

            return currentNode.getObject();
        }

        public void setPrevious()
        {
            currentNode = currentNode.getPrevious();

            if (currentNode == null)
                currentNode = tailNode;
        }

        public void add(Object opaqueObject)
        {
            tailNode = new LinkedLists(opaqueObject, currentNode);

            if (currentNode != null)
                currentNode.setNextNode(tailNode);

            currentNode = tailNode;

            if (headNode == null) {
                headNode = tailNode;
            }
        }

        public Object delete()
        {
            Object opaqueObject = null;

            if (headNode != null) {
                opaqueObject = headNode.getObject();
                headNode = headNode.getNext();
                if (headNode == null)
                    tailNode = headNode;
                else
                    headNode.setPrevNode(null);
            }

            return opaqueObject;
        }

        public String toString()
        {
            StringBuilder queueToString = new StringBuilder("[");

            LinkedLists node = headNode;
            while (node != null)
            {
                queueToString.append("(").append(node.getObject()).append(")");
                node = node.getNext();
                if (node != null)
                    queueToString.append(", ");
            }
            queueToString.append("]");
            return queueToString.toString();
        }

        public void insertionSort() {
            LinkedLists node1 = headNode;
            LinkedLists node2 = (node1 == null) ? null : node1.getNext();

            while (node2 != null) {

                LinkedLists slot1 = node1;
                LinkedLists slot2 = node2;

                LinkedLists key = new LinkedLists(node2);
                String keyText = node2.getObject().toString();

                while (slot1.getObject().toString().compareTo(keyText) > 0 ) {
                    slot2.setObject(slot1.getObject());

                    slot1 = slot1.getPrevious();
                    slot2 = slot2.getPrevious();

                    //stop at the front of list
                    if (slot1 == null)
                        break;

                }
                slot2.setObject(key.getObject());

                node1 = node1.getNext();
                node2 = node2.getNext();
            }
        }
    }

