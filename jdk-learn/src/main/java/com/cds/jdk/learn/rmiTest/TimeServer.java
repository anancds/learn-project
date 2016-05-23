package com.cds.jdk.learn.rmiTest;

import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

public class TimeServer extends UnicastRemoteObject implements ITimeServer {

    public TimeServer(int port) throws RemoteException {
        super(port);
    }

    public TimeServer() throws RemoteException {
        super();
    }

    public TimeServer(int port, RMIClientSocketFactory csf, RMIServerSocketFactory ssf)
        throws RemoteException {
        super(port, csf, ssf);
    }

    @Override public long getServerTime() throws RemoteException {
        return System.currentTimeMillis();
    }

    @Override public int add(int a, int b) throws RemoteException {
        return a + b;
    }
}
