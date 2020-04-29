package netty;

import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

@Slf4j
public class BIODemo {
    public void bio() throws IOException {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(9090);
            log.info("the time server is start in port : 9090");
            Socket socket = null;
            while (true) {
                socket = serverSocket.accept();
                new Thread(new TimeServerHandler(socket)).start();
            }
        } catch (IOException e) {
            log.error(e.getMessage());
        } finally {
            if (serverSocket != null) {
                log.info("the time server close");
                serverSocket.close();
            }
        }
    }
}

@Slf4j
class TimeServerHandler implements Runnable {

    private Socket socket;

    public TimeServerHandler(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            out = new PrintWriter(this.socket.getOutputStream(), true);
            String body;
            while ((body = in.readLine()) != null && body.length() != 0) {
                log.info("the time server receive msg :" + body);
                out.println(new Date().toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (out != null) {
                try {
                    out.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (this.socket != null) {
                try {
                    this.socket.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
