package controllers;

import java.io.IOException;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Account;
import utils.DBUtil;
import utils.EncryptUtil;

/**
 * Servlet implementation class CreateServlet
 */
@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();
            em.getTransaction().begin();

            Account a = new Account();

            String email_address = request.getParameter("email_address");
            a.setEmail_address(email_address);

            String username = request.getParameter("username");
            a.setUsername(username);

            String plain_pass =request.getParameter("password");
            String password = EncryptUtil.getPasswordEncrypt(
                    plain_pass,
                    (String)this.getServletContext().getAttribute("pepper")
                    );
            a.setPassword(password);

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            a.setCreated_at(currentTime);
            a.setUpdated_at(currentTime);

            em.persist(a);
            em.getTransaction().commit();
            em.close();

            response.sendRedirect(request.getContextPath() + "/index");
        }


    }

}
