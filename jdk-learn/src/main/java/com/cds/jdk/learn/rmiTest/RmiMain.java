package com.cds.jdk.learn.rmiTest;

import java.net.MalformedURLException;
import java.rmi.AlreadyBoundException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RmiMain {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.createRegistry(6600);
            TimeServer timeServer = new TimeServer();
            //            Naming.bind("t1", timeServer);
            //            Naming.rebind("t1", timeServer);
            registry.rebind("TimeServer", timeServer);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
