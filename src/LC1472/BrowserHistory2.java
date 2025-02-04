package LC1472;

import java.util.List;
import java.util.ArrayList;

public class BrowserHistory2 {
    List<String> history;
    int curIndex;
    int lastIndex;
    public BrowserHistory2(String homepage) {
        this.history = new ArrayList<>();
        this.history.add(homepage);
        this.curIndex = 0;
        this.lastIndex = 0;
    }
    
    public void visit(String url) {
        this.curIndex++;
        if (this.curIndex == this.history.size()) {
            this.history.add(url);
        } else {
            // the curIndex is before the last element of history
            this.history.set(curIndex, url);
        }
        this.lastIndex = this.curIndex; // clear all data in future
    }
    
    public String back(int steps) {
        this.curIndex = Math.max(0, this.curIndex - steps);
        return this.history.get(this.curIndex);
    }
    
    public String forward(int steps) {  
        this.curIndex = Math.min(this.lastIndex, this.curIndex + steps);
        return this.history.get(this.curIndex);
    }
}
