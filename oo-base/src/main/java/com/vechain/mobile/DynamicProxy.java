package com.vechain.mobile;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface dynamicWorker {

    void doWork();
    void clean();
    void finish();
}

class DynamicWorkerImpl implements dynamicWorker {

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

public class DynamicProxy implements InvocationHandler {


    Object obj = null;

    /**
     * 要代理的对象
     *
     * @param obj
     */
    public DynamicProxy(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before Invoke");
        Object invoke = method.invoke(this.obj, args);
        System.out.println("After Invoke");
        return invoke;
    }

    public static void main(String[] args){

        dynamicWorker worker = new DynamicWorkerImpl();
        ClassLoader classLoader = worker.getClass().getClassLoader();

        dynamicWorker pxy = (dynamicWorker)Proxy.newProxyInstance(
                classLoader, new Class[]{dynamicWorker.class}, new DynamicProxy(worker));

        pxy.doWork();
        pxy.clean();
        pxy.finish();
    }

}
