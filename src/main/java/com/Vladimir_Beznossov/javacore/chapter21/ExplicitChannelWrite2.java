package main.java.com.Vladimir_Beznossov.javacore.chapter21;

// Записать данные в файл средствами системы ввода-вывода NIO

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class ExplicitChannelWrite2 {
    public static void main(String[] args) {
        try (FileChannel fChan = (FileChannel) Files.newByteChannel(Paths.get("test2.txt"),
                StandardOpenOption.WRITE,
                StandardOpenOption.CREATE);)
        {
            ByteBuffer mBuf = ByteBuffer.allocate(26);
            for (int h = 0; h < 3; h++) {
                for (int i = 0; i < 26; i++) {
                    mBuf.put((byte) ('A' + i));
                    mBuf.rewind();
                    fChan.write(mBuf);
                    mBuf.rewind();
                }
            }
        } catch (InvalidPathException e) {
            System.out.println("Ошибка указания пути " + e);
        } catch (IOException e) {
            System.out.println("Ошибка ввода-вывода " + e);
            System.exit(1);
        }
    }
}
