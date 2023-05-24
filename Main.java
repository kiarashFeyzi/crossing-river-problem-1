
public class Main {
    public static int transferIndex;
    public static INode initialState(){
       // return (INode) new Node(null, new boolean[]{false , false, false,  false, false, false, false});
        return INode.create(null, new boolean[]{false , false, false,  false, false, false, false});
    };
    public static void show (INode node){
        String result = "\n------------------------------------\n";

        result += "Transfer index : " + transferIndex + "\nBoat's Latest Transfer:\n";
        if (node.getFatherNode() != null)
            for (int i = 1; i < node.getState().length; i ++)
                if (node.getFatherNode().getState()[i] != node.getState()[i])
                    result += gps(i) + "\n";
        result += "  --- Boat location: ";
        if (node.getState()[0]) result += "region 2\n";
        else result += "region 1\n";
        result += node.toString();
        System.out.print(result + "\n------------------------------------\n");
    }
    private static String gps (int i){
        if (i == 1) return "Father";
        else if (i == 2) return "Mother";
        else if (i == 3) return "Boy1";
        else if (i == 4) return "Boy2";
        else if (i == 5) return "Girl1";
        else if (i == 6) return "Girl2";

        return "";
    }
    public static void showPath(INode node){
        if (node.getFatherNode() != null)
            showPath(node.getFatherNode());
        show(node);
        transferIndex++;
    }
    public static void main(String[] args) {

        INode node = initialState();

        SearchAlgorithm searchAlgorithm = new SearchAlgorithm();

        INode finalNode = searchAlgorithm.search(node);
        if (finalNode == null) System.out.println("there is no answer for this problem");
        else

       // show(finalNode);
             showPath(finalNode);




    }


}