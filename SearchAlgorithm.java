import java.util.LinkedList;

public class SearchAlgorithm implements ISearchAlgorithm{
    private LinkedList<INode> expandedNodes;
    private LinkedList<INode> unExpandedNodes;

    public SearchAlgorithm(){
        expandedNodes = new LinkedList<>();
        unExpandedNodes = new LinkedList<>();
    }

    private boolean isValid(INode node){
        boolean[] state = node.getState();
        if (state[0] != state[1]  &&  state[1] == state[2]) return false;
        if (node.getFatherNode() != null){
            if (node.getFatherNode().getState()[1] == state[1]  &&  node.getFatherNode().getState()[2] == state[2])
                return false;

            for (int i = 1; i < state.length; i++)
                if (node.getFatherNode().getState()[i] != state[i]){
                    if (node.getFatherNode().getState()[0] == state[i]) return false;
                }
        }

      //  for (int i = 0; i < state.length; i++)


        if (state[1] != state[2] &&( state[2] == state[3] || state[2] == state[4]))
            return false;
        if (state[1] != state[2] &&( state[1] == state[5] || state[1] == state[6]))
            return false;

        return true;
    }

    private boolean isGoal(INode node){
        boolean[] state = node.getState();
        for (int i = 0; i < state.length; i++)
            if (!state[i]) return false;
        return true;
    }

    public LinkedList<INode> generateChildren(INode node){

        LinkedList<INode> listOfGeneratedNodes = new LinkedList<>();

//        INode nd = INode.create(node, node.getState())  it wont work???? unless getState() returns a new array

        INode nd = null ;


      //  int var = ;
        for (int i = 1; i < node.getState().length; i++)
            for (int j = i + 1; j < node.getState().length; j ++){
                nd = node.clone();
                nd.getState()[i] = !node.getState()[i];
                nd.getState()[j] = !node.getState()[j];
                listOfGeneratedNodes.add(nd);

            }
        for (int i = 1; i < node.getState().length; i++){
            nd = node.clone();
            nd.getState()[i] = !node.getState()[i];
            listOfGeneratedNodes.add(nd);
        }

    //    assert nd != null;
        boolean b = !nd.getState()[0];
        for (int i = 0; i < listOfGeneratedNodes.size(); i++){
            listOfGeneratedNodes.get(i).setFatherNode(node);
            listOfGeneratedNodes.get(i).getState()[0] = b;
        }




     //   nd = null;



        return listOfGeneratedNodes;
    }

    @Override
    public INode search(INode starterNode) {

        unExpandedNodes.add(starterNode);
        while (true){
            while (true){
                if (unExpandedNodes.size() == 0) return null;



                INode target = unExpandedNodes.getLast();

//                for (int i = 0; i< target.getState().length; i++)
//                    System.out.print(" " +target.getState()[i]);
//                System.out.println();
//
//                for (int j =0;j< unExpandedNodes.size();j++) {
//                    for (int i = 0; i < 3; i++)
//                        System.out.print(unExpandedNodes.get(j).getState()[i]);
//                    System.out.println();
//                }


                unExpandedNodes.remove(unExpandedNodes.size() - 1);
            //    System.out.println(unExpandedNodes.size());
                if (! isValid(target)) break;
                if (isGoal(target))
                    return target;

                boolean flag = false;
                for (int i = 0; i < expandedNodes.size(); i++)
                    if (target.equals(expandedNodes.get(i))){
//                        System.out.println("here2");
//                        target = null;
                        flag = true;
                        break;
                    }
                if (flag) break;
                //System.out.println("here");
                LinkedList<INode> newList = generateChildren(target);
                unExpandedNodes.addAll(newList);
                expandedNodes.add(target);

            }
        }


       // return null;
    }

}
