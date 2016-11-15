package com.cds.jni;

public class test {

    public static void main(String[] args) throws DllException {


        boolean isSuccess = JniMethod.InitDllInstance("/home/cds/libStAssistant.so");
        if (isSuccess) {

            System.out.println("the score is : " + args[0] + " the result is:  " + getScore(Float.valueOf(args[0])));

        }

    }

    public static float getScore(float score) throws DllException {

        return JniMethod.getDllInstance().st_score_standard(score);

    }
}
