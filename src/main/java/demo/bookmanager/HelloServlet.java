package demo.bookmanager;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", value = "/hello")
public class HelloServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Get Request");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Post Request");
    }

    public void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Put Request");
    }

    public void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Delete Request");
    }

}
