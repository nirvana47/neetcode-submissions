class BrowserHistory {

    private static class Page {
        String url;
        Page back;
        Page forward;

        Page(String url) {
            this.url = url;
        }
    }

    Page home;
    Page cur;

    public BrowserHistory(String homepage) {
        Page newPage = new Page(homepage);
        home = newPage;
        cur = newPage;
    }
    
    public void visit(String url) {
        Page newPage = new Page(url);
        cur.forward = newPage;
        newPage.back = cur;
        newPage.forward = null;
        cur = newPage;
    }
    
    public String back(int steps) {
        int index = 0;
        while(cur.back != null && index < steps) {
            cur = cur.back;
            index++;
        }
        return cur.url;
    }
    
    public String forward(int steps) {
        int index = 0;
        while (cur.forward != null && index < steps){
            cur = cur.forward;
            index++;
        }
        return cur.url;
    }
}

/**
 * Your BrowserHistory object will be instantiated and called as such:
 * BrowserHistory obj = new BrowserHistory(homepage);
 * obj.visit(url);
 * String param_2 = obj.back(steps);
 * String param_3 = obj.forward(steps);
 */