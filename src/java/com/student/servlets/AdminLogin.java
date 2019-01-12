package com.student.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Admin Panel</title>");
        out.println("<link rel='stylesheet' href='resources/bootstrap.min.css'/>");
        out.println("<link rel='stylesheet' href='style.css'/>");
        out.println("</head>");
        out.println("<body>");
        request.getRequestDispatcher("navadmin.xhtml").include(request, response);

        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if (email.equals("hrcombination@gmail.com") && password.equals("1240966")) {
            HttpSession session = request.getSession();
            session.setAttribute("admin", "true");
            request.getRequestDispatcher("adminhome.xhtml").include(request, response);
        } else {
            out.println("<p>Sorry, username or password error!</p>");
            request.getRequestDispatcher("AdminLoginForm.xhtml").include(request, response);
        }

        request.getRequestDispatcher("footer.xhtml").include(request, response);
        out.println("</body>");
        out.println("</html>");

        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

}
