package com.cds.jdk.learn.rmiTest;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ITimeServer extends Remote {
    long getServerTime() throws RemoteException;

    int add(int a, int b) throws RemoteException;
}
