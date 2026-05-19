package LC684;

class DSU {
    int n; // the number of nodes from 0 to n - 1
    int[] ancestor;
    int[] familySize;

    public DSU(int n) {
        this.n = n;
        ancestor = new int[n];
        familySize = new int[n];

        for (int i = 0; i < n; i++) {
            // each node is a family set and the ancestor is itself
            ancestor[i] = i;
            familySize[i] = 1;
        }
    }

    // find the final ancestor of the node
    public int find(int node) {
        while (node != ancestor[node]) {
            node = ancestor[node];
        }

        return node;
    }

    public boolean isUnion(int node1, int node2) {
        int anc1 = find(node1);
        int anc2 = find(node2);

        if (anc1 == anc2) {
            // node 1 and node 2 are under the same ancestor node (same family)
            return false; // no union action need
        }

        if (familySize[anc1] >= familySize[anc2]) {
            // we merge anc2 family into anc1 family
            ancestor[anc2] = anc1;
            familySize[anc1] += familySize[anc2];
        } else {
            // merge anc1 family into anc2 family
            ancestor[anc1] = anc2;
            familySize[anc2] += familySize[anc1];
        }

        return true;
    }
}

public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU dsu = new DSU(n);

        for (int[] edge : edges) {
            if (!dsu.isUnion(edge[0] - 1, edge[1] - 1)) {
                return edge;
            }
        }

        return new int[] {-1, -1};
    }
}
