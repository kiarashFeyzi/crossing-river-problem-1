public interface INode{

    public static INode create(INode father, boolean[] state){
        return new Node(father, state);
    }
    public boolean equals(INode targetNode);
    @Override
    public String toString();
//    @Override ????????????????????????
    public INode clone();

    public INode getFatherNode();
    public void setFatherNode(INode fatherNode);
    public boolean[] getState();
}
