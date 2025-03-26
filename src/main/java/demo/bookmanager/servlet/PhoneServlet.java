package demo.bookmanager.servlet;


import demo.bookmanager.dao.PhoneDao;
import demo.bookmanager.dto.PhoneDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/phone/*")
public class PhoneServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String job = request.getRequestURI().substring(request.getContextPath().length());
        switch (job) {
            case "/phone/list":
                list(request, response);
                break;
            case "/phone/detail":
                detail(request, response);
                break;
            case "/phone/insert":
                insert(request, response);
                break;
            case "/phone/update":
                update(request, response);
                break;
            case "/phone/delete":
                delete(request, response);
                break;
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

    protected void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PhoneDao phoneDao = new PhoneDao();
        List<PhoneDto> phoneList = phoneDao.listPhone();
        System.out.println(phoneList);
        request.setAttribute("phoneList", phoneList);
        request.getRequestDispatcher("/list.jsp").forward(request, response);
    }

    protected void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PhoneDao phoneDao = new PhoneDao();
        int phoneId = Integer.parseInt(request.getParameter("phoneId"));
        PhoneDto phoneDto = phoneDao.detailPhone(phoneId);
        System.out.println(phoneDto);
        request.setAttribute("phoneDto", phoneDto);
        request.getRequestDispatcher("/detailForm.jsp").forward(request, response);
    }

    protected void insert(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PhoneDao phoneDao = new PhoneDao();

        request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");
        String brand = request.getParameter("brand");
        String color = request.getParameter("color");
        String capacity = request.getParameter("capacity");
        int price = Integer.parseInt(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));

        PhoneDto phoneDto = new PhoneDto(name, brand, color, capacity, price, stock);
        int ret = phoneDao.insertPhone(phoneDto);
        System.out.println(ret);

        request.setAttribute("phoneDto", phoneDto);
        request.getRequestDispatcher("/insertResult.jsp").forward(request, response);
    }

    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PhoneDao phoneDao = new PhoneDao();

        request.setCharacterEncoding("UTF-8");

        int phoneId = Integer.parseInt(request.getParameter("phoneId"));
        String name = request.getParameter("name");
        String brand = request.getParameter("brand");
        String color = request.getParameter("color");
        String capacity = request.getParameter("capacity");
        int price = Integer.parseInt(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));

        PhoneDto phoneDto = new PhoneDto(phoneId, name, brand, color, capacity, price, stock);
        int ret = phoneDao.updatePhone(phoneDto);
        System.out.println(ret);

        request.setAttribute("phoneDto", phoneDto);
        request.getRequestDispatcher("/updateResult.jsp").forward(request, response);
    }

    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PhoneDao phoneDao = new PhoneDao();

        request.setCharacterEncoding("UTF-8");

        int phoneId = Integer.parseInt(request.getParameter("phoneId"));
        int ret = phoneDao.deletePhone(phoneId);
        System.out.println(ret);

        request.setAttribute("phoneId", phoneId);
        request.getRequestDispatcher("/deleteResult.jsp").forward(request, response);
    }

}
