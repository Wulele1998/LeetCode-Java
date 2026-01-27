package OA;

import java.util.ArrayList;
import java.util.List;

class SystemNode {
    private final int nodeId;
    private boolean isCoordinate;
    private int currentCoordinator;
    private final List<SystemNode> higherPriorityNodes;

    public SystemNode(int nodeId, boolean isCoordinate, int currentCoordinator) {
        this.nodeId = nodeId;
        this.isCoordinate = isCoordinate;
        this.currentCoordinator = currentCoordinator;
        this.higherPriorityNodes = new ArrayList<>();
    }

    public int getNodeId() {
        return nodeId;
    }

    public void setCoordinate(boolean isCoordinate) {
        this.isCoordinate = isCoordinate;
    }

    public void setCurrentCoordinator(int currentCoordinator) {
        this.currentCoordinator = currentCoordinator;
    }

    public List<SystemNode> getHigherPriorityNodes() {
        return higherPriorityNodes;
    }

    public int getCurrentCoordinator() {
        return currentCoordinator;
    }

    public boolean getIsCoordinate() {
        return isCoordinate;
    }

    public void startElection(List<SystemNode> systemNodes) {
        System.out.println("Node " + nodeId + ": Starting the election ... ");
        higherPriorityNodes.clear();

        for (SystemNode node : systemNodes) {
            if (node.getNodeId() > nodeId) {
                if (sendElectionMessage(node)) {
                    // send election message to the node with higher priority
                    higherPriorityNodes.add(node);
                }
            }
        }

        if (higherPriorityNodes.isEmpty()) {
            becomeCoordinator(systemNodes);
        } else {
            System.out.println("Node " + nodeId + ": Existing nodes in higher priority. Passing the election right to them");
        }
    }

    public boolean sendElectionMessage(SystemNode receiver) {
        System.out.println("Node " + nodeId + ": Sending election message from " + nodeId + " to " + receiver.getNodeId());
        return receiver.sendElectionResponseMessage(this);
    }

    public boolean sendElectionResponseMessage(SystemNode receiver) {
        if (receiver.getNodeId() < nodeId) {
            System.out.println("Node " + nodeId + ": Election message received from " + receiver.getNodeId());
            return true;
        }

        return false;
    }

    public void becomeCoordinator(List<SystemNode> systemNodes) {
        System.out.println("Node " + nodeId + ": Node " + nodeId + " becoming coordinator");
        for (SystemNode node : systemNodes) {
            node.setCurrentCoordinator(nodeId);
        }
        isCoordinate = true;
    }

    @Override
    public String toString() {
        return "Node " + nodeId + ": Current coordinator is " + currentCoordinator +
                ", I am" + (isCoordinate ? "" : " not") + " the coordinator.";
    }
}

public class BullyAlgorithm {
    public static void main(String[] args) {
        SystemNode node0 = new SystemNode(0, false, 4);
        SystemNode node1 = new SystemNode(1, false, 4);
        SystemNode node2 = new SystemNode(2, false, 4);
        SystemNode node3 = new SystemNode(3, false, 4);
        SystemNode node4 = new SystemNode(4, true, 4);

        List<SystemNode> systemNodeList = new ArrayList<>();
        systemNodeList.add(node0);
        systemNodeList.add(node1);
        systemNodeList.add(node2);
        systemNodeList.add(node3);
        systemNodeList.add(node4);

        // node 4 is down and node 2 detects it
        systemNodeList.remove(4);

        SystemNode curNode = node0;
        curNode.startElection(systemNodeList);
        while (!curNode.getHigherPriorityNodes().isEmpty()) {
            curNode = curNode.getHigherPriorityNodes().get(0);
            curNode.startElection(systemNodeList);
        }

        for (SystemNode node : systemNodeList) {
            System.out.println(node);
        }
    }
}
