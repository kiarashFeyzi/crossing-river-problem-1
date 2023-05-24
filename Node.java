public class Node implements INode{
    private Node fatherNode;
    private boolean[] state;

//deafault constructor
    public Node(INode father, boolean[] state) {
        this.state = state;
        fatherNode = (Node) father;
    }

    @Override
    public boolean equals(INode targetNode) {
        for (int i = 0; i < state.length; i++)
            if (state[i] != targetNode.getState()[i])
                return false;
        return true;
    }


//    public boolean equals(Object ob){
//
//    }

    @Override
    public String toString(){
        String reg1 ="\nRegion1 :\n    ",
                reg2 = "\nRegion2 :\n    ",
                result = "";
        for (int i = 1; i < state.length; i++){
            if (!state[i]) {
                if (i == state.length - 1)reg1 += gps(i) ;
                else reg1 += gps(i) + "\n    ";
            }
            else reg2 += gps(i) + "\n    ";
        }
        result += reg1 + reg2;
        return result;
    }

    private String gps (int i){
        if (i == 1) return "Father";
        else if (i == 2) return "Mother";
        else if (i == 3) return "Boy1";
        else if (i == 4) return "Boy2";
        else if (i == 5) return "Girl1";
        else if (i == 6) return "Girl2";

        return "";
    }



    //when it returns Node, no error, why?
    //error to call super
    //INode nd = new INode() {
    @Override
    public INode clone() {
        INode nd = null;

             nd = INode.create(fatherNode, state.clone());
        return nd;
      //return null;
    }




    @Override
    public INode getFatherNode() {
        return fatherNode;
    }

    @Override
    public void setFatherNode(INode fatherNode) {
        this.fatherNode = (Node) fatherNode;
    }

    @Override
    public boolean[] getState() {
        return state;
    }
}
