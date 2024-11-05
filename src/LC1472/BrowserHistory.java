package LC1472;

import java.util.Stack;

public class BrowserHistory {
    private Stack<String> history;
    private Stack<String> future;
    String cur;

    public BrowserHistory(String homepage) {
        this.history = new Stack<>();
        this.future = new Stack<>();
        this.cur = homepage;
    }
    
    public void visit(String url) {
        this.history.push(this.cur);
        this.cur = url;
        this.future.clear();
    }
    
    public String back(int steps) {
        while (steps > 0 && !this.history.isEmpty()) {
            this.future.push(this.cur);
            this.cur = this.history.pop();
            steps--;
        }

        return cur;
    }
    
    public String forward(int steps) {
        while (steps > 0 && !this.future.isEmpty()) {
            this.history.push(cur);
            this.cur = this.future.pop();
            steps--;
        }

        return cur;
    }
}
