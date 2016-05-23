package com.cds.jdk.learn.rmiTest;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class RmiClient {
    public static void main(String[] args)
        throws RemoteException, NotBoundException, MalformedURLException, NamingException {
        //        ITimeServer timeServer = (ITimeServer) Naming.lookup("rmi://localhost:6600/TimeServer");
        Context namingContext = new InitialContext();

        ITimeServer timeServer =
            (ITimeServer) namingContext.lookup("rmi://localhost:6600/TimeServer");
        System.out.println(timeServer.add(3, 5));
        System.out.println(timeServer.getServerTime());
    }
}
