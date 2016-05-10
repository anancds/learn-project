package com.cds.jdk.learn.niolearn;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelTest {
    public static void main(String[] args) throws IOException {
        RandomAccessFile accessFile = new RandomAccessFile("D:\\IdeaProjects\\learn-project\\" +
                "build.gradle", "rw");

        FileChannel inChannel = accessFile.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);
        int byteRead = inChannel.read(buf);
        while (byteRead != -1) {

            System.out.println("Read " + byteRead);
            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }
            System.out.println(" ");

            buf.clear();
            byteRead = inChannel.read(buf);
        }
        accessFile.close();
    }
}
