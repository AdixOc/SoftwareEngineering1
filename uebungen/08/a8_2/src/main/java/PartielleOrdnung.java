import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PartielleOrdnung implements Iterable<String> {
    final String[][] liste;

    public PartielleOrdnung(String[][] liste) {
        this.liste = liste;
    }

    public static PartielleOrdnung studentLife(){
        return new PartielleOrdnung(new String[][]{
            {"Aufstehen", "Frühstücken"},
            {"Aufstehen", "Kaffeetrinken"},
            {"Frühstücken", "Lernen"},
            {"Kaffeetrinken", "Lernen"}
        });
    }

    class TopSortIterator implements Iterator<String>{

        Nodes nodes = new Nodes();
        Nodes.Node cursor = null;

        TopSortIterator(String[][] liste){
            for (String[] pair : liste) {
                nodes.addNode(pair[0], pair[1]);
            }

        }

        class Nodes {
            LinkedList<Node> allNodes;
            class Node {
                public String value;
                public LinkedList<Node> next;
                public LinkedList<Node> rev;
                public Node(String value){
                    this.value = value;
                    next = new LinkedList<>();
                    rev = new LinkedList<>();
                }
            }

            public Nodes() {
                allNodes = new LinkedList<Node>();
            }

            public Node addNode(String valueVal, String nextVal) {
                Node next = findNode(nextVal);
                Node curr = findNode(valueVal);
                if (curr == null){
                    curr = new Node(valueVal);
                    allNodes.add(curr);
                }
                if (next == null){
                    next = new Node(nextVal);
                    allNodes.add(next);
                }

                next.rev.add(curr);
                curr.next.add(next);
                List<Node> nodesWhichContainCurr = findAllNodesWhereNodeIsNext(curr);
                next.rev.addAll(nodesWhichContainCurr);

                return curr;
            }

            void removeNode(Node node){
                allNodes.remove(node);
                for (Node node1 : allNodes) {
                    node1.next.remove(node);
                    node1.rev.remove(node);
                }
            }

            Node findNode(String valueVal) {
                for (Node n : allNodes) {
                    if (n.value.equals(valueVal)) {
                        return n;
                    }
                }
                return null;
            }

            List<Node> findAllNodesWhereNodeIsNext(Node node){
                List<Node> result = new LinkedList<>();
                for (Node n : allNodes) {
                    for (Node n2 : node.next) {
                        if (n2.value.equals(node.value)) {
                            result.add(n2);
                        }
                    }
                }
                return result;
            }

            Node findFirstNodeWhereThereIsNoPrevious(){
                for (Node n : allNodes) {
                    if (n.rev.size() == 0) {
                        return n;
                    }
                }
                return null;
            }
        }

        @Override
        public boolean hasNext() {
            if (cursor == null) {
                cursor = nodes.findFirstNodeWhereThereIsNoPrevious();
            }
            return cursor != null;
        }

        @Override
        public String next() {
            if (cursor == null) {
                cursor = nodes.findFirstNodeWhereThereIsNoPrevious();
                if (cursor == null) {
                    throw new IllegalStateException();
                }
            }
            var result = cursor.value;
            nodes.removeNode(cursor);
            cursor = null;
            return result;
        }
    }

    @Override
    public Iterator<String> iterator() {
        return new TopSortIterator(this.liste);
    }
}

