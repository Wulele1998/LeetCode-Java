package OA;

import java.util.List;

enum State {
    LEADER,
    FOLLOWER,
    CANDIDATE
}


public class RaftNode {
    private int term = 0; // global
    private int id;
    private State state;
    private Integer voteFor;

    public RaftNode(int id) {
        this.id = id;
        this.state = State.FOLLOWER;
        voteFor = null;
    }

    public void startElection(List<RaftNode> peers) {
        term++; // start a new term
        state = State.CANDIDATE; // change the state to candidate
        voteFor = id; // vote the node itself
        int votes = 1;

        for (RaftNode peer : peers) {
            if (peer.requestVote(id, term)) {
                votes++;
            }
        }

        int majority = (1 + peers.size()) / 2 + 1;
        if (votes >= majority) {
            // become the leader
            state = State.LEADER;
            for (RaftNode peer : peers) {
                peer.becomeLeader(term, id);
            }
        }

    }

    public boolean requestVote(int candidateId, int candidateTerm) {
        if (term > candidateTerm) { // denied the vote request
            return false;
        }

        if (term < candidateTerm) {
            term = candidateTerm;
            state = State.FOLLOWER;
            voteFor = candidateId;
            return true;
        }

        return false;
    }

    public void becomeLeader(int leaderTerm, int leaderId) {
        if (leaderTerm >= term) {
            term = leaderTerm;
            state = State.FOLLOWER;
            voteFor = null;
        }
    }
}
