package LC8;

enum State {Q0, Q1, Q2, Qd};

class StateMachine {
    private State currentState;
    private int result;
    private int sign;

    public StateMachine() {
        currentState = State.Q0;
        result = 0;
        sign = 1;
    }

    private void toStateQ0() {
        currentState = State.Q0;
    }

    private void toStateQ1(char c) {
        sign = (c == '+') ? 1 : -1;
        currentState = State.Q1;
    }

    private void toStateQ2(int digit) {
        currentState = State.Q2;
        appendDigit(digit);
    }

    private void toStateQd() {
        currentState = State.Qd;
    }

    private void appendDigit(int digit) {
        if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
            result = (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            sign = 1;
            toStateQd();
        } else {
            result = result * 10 + digit;
        }
    }

    public void transition(char c) {
        if (currentState == State.Q0) {
            if (c == ' ') {
                toStateQ0();
            } else if (c == '-' || c == '+') {
                toStateQ1(c);
            } else if (Character.isDigit(c)) {
                toStateQ2(c - '0');
            } else {
                toStateQd();
            }
        } else if (currentState == State.Q1 || currentState == State.Q2) {
            if (Character.isDigit(c)) {
                toStateQ2(c - '0');
            } else {
                toStateQd();
            }
        }
    }

    public int getResult() {
        return sign * result;
    }

    public State getCurrentState() {
        return currentState;
    }
}
public class Solution2 {
    public int myAtoi(String s) {
        // DFA (Deterministic Finite Automation)
        // N: the length of `s`
        // time: O(N)
        // space: O(1)
        StateMachine machine = new StateMachine();
        for (int i = 0; i < s.length() && machine.getCurrentState() != State.Qd; i++) {
            machine.transition(s.charAt(i));
        }

        return machine.getResult();
    }

}
