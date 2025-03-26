package demo.bookmanager.servlet;


import demo.bookmanager.dao.BookDao;
import demo.bookmanager.dto.BookDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/books/*")
public class BookServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String job = request.getRequestURI().substring(request.getContextPath().length());
        switch (job) {
            case "/books/list":
                list(request, response);
                break;
            case "/books/detail":
                detail(request, response);
                break;
            case "/books/insert":
                insert(request, response);
                break;
            case "/books/update":
                update(request, response);
                break;
            case "/books/delete":
                delete(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bookDao = new BookDao();
        List<BookDto> bookList = bookDao.listBook();
        System.out.println(bookList);
        request.setAttribute("bookList", bookList);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bookDao = new BookDao();
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        BookDto bookDto = bookDao.detailBook(bookId);
        System.out.println(bookDto);
        request.setAttribute("bookDto", bookDto);
        request.getRequestDispatcher("/detailForm.jsp").forward(request, response);
    }

    protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bookDao = new BookDao();

        request.setCharacterEncoding("UTF-8");

        int bookId = Integer.parseInt(request.getParameter("bookId"));
        String bookName = request.getParameter("bookName");
        String publisher = request.getParameter("publisher");
        int price = Integer.parseInt(request.getParameter("price"));

        BookDto bookDto = new BookDto(bookId, bookName, publisher, price);
        int ret = bookDao.insertBook(bookDto);
        System.out.println(ret);

        request.setAttribute("bookDto", bookDto);
        request.getRequestDispatcher("/insertResult.jsp").forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bookDao = new BookDao();

        request.setCharacterEncoding("UTF-8");

        int bookId = Integer.parseInt(request.getParameter("bookId"));
        String bookName = request.getParameter("bookName");
        String publisher = request.getParameter("publisher");
        int price = Integer.parseInt(request.getParameter("price"));

        BookDto bookDto = new BookDto(bookId, bookName, publisher, price);
        int ret = bookDao.updateBook(bookDto);
        System.out.println(ret);

        request.setAttribute("bookDto", bookDto);
        request.getRequestDispatcher("/updateResult.jsp").forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        BookDao bookDao = new BookDao();

        request.setCharacterEncoding("UTF-8");

        int bookId = Integer.parseInt(request.getParameter("bookId"));
        int ret = bookDao.deleteBook(bookId);
        System.out.println(ret);

        request.setAttribute("bookId", bookId);
        request.getRequestDispatcher("/deleteResult.jsp").forward(request, response);
    }


}
