package com.vechain.mobile;

interface worker {

    void doWork();
    void clean();
    void finish();
}

class NormalWorker implements worker {
    public void doWork() {
        System.out.println("NormalWork Begin Work");
    }

    public void clean() {
        System.out.println("NormalWork clean");
    }

    public void finish() {
        System.out.println("NormalWork Finish");
    }
}

public class NormalProxy implements worker {

    private NormalWorker worker = new NormalWorker();

    public void doWork() {
        System.out.println("Proxy do anything before proxy doWork");
        worker.doWork();
        System.out.println("Proxy do anything after proxy doWork");
    }

    public void clean() {
        System.out.println("Proxy do anything before proxy clean");
        worker.clean();
        System.out.println("Proxy do anything after proxy clean");
    }

    public void finish() {
        System.out.println("Proxy do anything before proxy finish");
        worker.finish();
        System.out.println("Proxy do anything after proxy finish");
    }

    public static void main(String[] args) {
        NormalProxy proxy = new NormalProxy();
        proxy.doWork();
        proxy.clean();
        proxy.finish();
    }
}
