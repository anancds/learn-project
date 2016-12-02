package com.cds.jna;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

import java.util.Arrays;
import java.util.List;

public class MyStruct extends Structure implements Structure.ByReference {
    public int a;
    public int b;

    public MyStruct() {
    }

    public MyStruct(Pointer p) {
        super(p);
        read();
    }

    protected List getFieldOrder() {
        return Arrays.asList(new String[]{"a", "b"});
    }
}
