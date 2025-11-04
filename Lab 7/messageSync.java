 
class MessageSender {
    // Synchronized method to ensure one thread sends its full message before the other
    synchronized void sendMessage(String threadName, String msg) {
        System.out.println(threadName + " is sending message:");
        for (int i = 0; i < msg.length(); i++) {
            System.out.print(msg.charAt(i));
            try {
                Thread.sleep(100); // simulate delay for each character
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(); // move to next line after message
        System.out.println(threadName + " finished sending.\n");
    }
}

class MyThread extends Thread {
    MessageSender sender;
    String threadName;
    String message;

    MyThread(MessageSender s, String name, String msg) {
        sender = s;
        threadName = name;
        message = msg;
    }

    public void run() {
        sender.sendMessage(threadName, message);
    }
}

public class MessageSync {
    public static void main(String[] args) {
        MessageSender sender = new MessageSender();

        MyThread t1 = new MyThread(sender, "Thread-1", "Hello from Thread-1!");
        MyThread t2 = new MyThread(sender, "Thread-2", "Greetings from Thread-2!");

        t1.start();
        t2.start();
    }
}
