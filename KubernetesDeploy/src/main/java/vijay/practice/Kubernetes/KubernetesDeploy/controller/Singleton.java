package vijay.practice.Kubernetes.KubernetesDeploy.controller;

public class Singleton {

    private Singleton() {}

    private  static Singleton singleton;


    public static Singleton getSingleton() {
        
        synchronized (singleton) {
            if(singleton == null) {
                singleton = new Singleton();
            }
        }

        return singleton;
    }




}
