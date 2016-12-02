package com.cds.jna;

import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.Pointer;
import com.sun.jna.ptr.PointerByReference;

interface DLibrary extends Library {
    DLibrary INSTANCE = (DLibrary) Native.loadLibrary("/home/cds/libtest.so", DLibrary.class);

    int fun_alloc(PointerByReference p);

    int fun_free(PointerByReference p);

    int setstring(StringByReference str);

    int setvals(MyStruct[] mstructs, int sizeofarray);
}

public class jnatest2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        try {
            int x;
            PointerByReference pref = new PointerByReference();
            x = DLibrary.INSTANCE.fun_alloc(pref);
            Pointer ptr = pref.getValue();
            MyStruct mys = new MyStruct(ptr);
            System.out.println("Java got from  native "
                    + Pointer.nativeValue(ptr) + "  " + mys.a + " " + mys.b);
            DLibrary.INSTANCE.fun_free(pref);
            StringByReference mystring = new StringByReference("ZZZZZ");
            DLibrary.INSTANCE.setstring(mystring);
            System.out.println(mystring.getValue());

            MyStruct[] mystructs = new MyStruct[10];
            x = 0;
            while (x < 10) {
                mystructs[x] = new MyStruct();
                x++;
            }

            DLibrary.INSTANCE.setvals(mystructs, 10);

            x = 0;
            while (x < 10) {
                System.out.println("Struct no " + x + " values " + mystructs[x].a
                        + " " + mystructs[x].b);
                x++;
            }

        } catch (UnsatisfiedLinkError e) {
            System.out.println("Exception" + e);
        }
    }
}
