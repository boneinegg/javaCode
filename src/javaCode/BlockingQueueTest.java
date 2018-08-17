package javaCode;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


/**
 * Recursively enumerates all files in a given directory and its subdirectories,
 * and searches all files for a keyword and prints all matching lines.
 */
public class BlockingQueueTest {
    private static final int QUEUE_SIZE = 10;
    private static final int SEARCH_THREADS = 100;
    private static final File DUMMY = new File("");
    private static BlockingQueue<File> queue = new ArrayBlockingQueue<>(QUEUE_SIZE);

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println("Enter base directory: ");
            String directory = in.nextLine();
            System.out.println("Enter keyword: ");
            String keyword = in.nextLine();

//            Runnable enumerator2 = new Runnable() {
//                @Override
//                public void run() {
//                    try {
//                        enumerate(new File(directory));
//                        queue.put(Dummy);
//                    } catch (InterruptedException e) {
//
//                    }
//                }
//            };

            Runnable enumerator = () -> {
                try {
                    enumerate(new File(directory));
                    queue.put(DUMMY);
                } catch (InterruptedException e) {
                }
            };

            new Thread(enumerator).start();
            for (int i = 0; i <= SEARCH_THREADS; i++) {
                Runnable serarcher = () -> {
                    try {
                        boolean done = false;
                        while (!done) {
                            File file = queue.take();
                            if (file == DUMMY) {
                                done = true;
                                queue.put(file);
                            } else
                                search(file, keyword);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (InterruptedException e) {
                    }
                };
                new Thread(serarcher).start();
            }
        }
    }

    public static void enumerate(File directory) throws InterruptedException {
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isDirectory())
                enumerate(file);
            else
                queue.put(file);
        }
    }

    public static void search(File file, String keyword) throws IOException{
        try (Scanner in = new Scanner(file, "UTF-8")) {
            int lineNum = 0;
            while (in.hasNextLine()) {
                lineNum++;
                String line = in.nextLine();
                if (line.contains(keyword))
                    System.out.printf("%s:%d:%s%n", file.getPath(), lineNum, line);
            }
        }
    }

}
