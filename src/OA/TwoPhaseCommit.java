package OA;

import java.util.List;

enum DECISION {
    ABORT,
    COMMIT
}

enum VOTE {
    YES,
    NO
}

class Coordinator {
    private int id;

    public Coordinator(int id) {
        this.id = id;
    }

    public DECISION runTransaction(List<Participant> participants) {
        for (Participant p : participants) {
            VOTE vote = p.prepare();
            if (vote == VOTE.NO) {
                // one of the participants is not ready
                abortAll(participants);
                return DECISION.ABORT;
            }
        }

        commitAll(participants);
        return DECISION.COMMIT;
    }

    public void commitAll(List<Participant> participants) {
        for (Participant p : participants) {
            p.commit();
        }
    }

    public void abortAll(List<Participant> participants) {
        for (Participant p : participants) {
            p.abort();
        }
    }
}

class Participant {
    private int id;
    private boolean isPrepared;

    public Participant(int id) {
        this.id = id;
    }

    public VOTE prepare() {
        return isPrepared ? VOTE.YES : VOTE.NO;
    }

    public void commit() {
        System.out.println("Committing the transaction ... ");
    }

    public void abort() {
        System.out.println("Aborting the transaction ... ");
    }
}

public class TwoPhaseCommit {
    public static void main(String[] args) {

    }
}
