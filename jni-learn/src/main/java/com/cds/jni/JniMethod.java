package com.cds.jni;

import com.sun.jna.Native;

public class JniMethod {

    private static JniFunction dllInstance = null;

    public static JniFunction getDllInstance() throws DllException
    {
        if (null == JniMethod.dllInstance)
        {
            throw new DllException();
        }
        else
        {
            return JniMethod.dllInstance;
        }
    }

    public static boolean InitDllInstance(String dllPath) {
        try
        {
            if (null != dllPath && !(dllPath.equals("")) &&  JniMethod.dllInstance  == null)
            {
                JniMethod.dllInstance = (JniFunction) Native.loadLibrary(dllPath,
                        JniFunction.class);
            }
        }catch (Exception e){
            e.printStackTrace();
//            return false;
        }
        return true;
    }
}
