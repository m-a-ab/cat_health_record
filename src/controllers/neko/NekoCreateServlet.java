package controllers.neko;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Account;
import models.NekoAccount;
import utils.DBUtil;

/**
 * Servlet implementation class NekoCreateServlet
 */
@WebServlet("/nekocreate")
public class NekoCreateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NekoCreateServlet() {
        super();
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String _token = request.getParameter("_token");
        if (_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();
            em.getTransaction().begin();

            NekoAccount n = new NekoAccount();

            String nekoname = request.getParameter("nekoname");
            n.setNekoname(nekoname);

            String image = request.getParameter("image");
            n.setImage(image);

            Date birthday = Date.valueOf(request.getParameter("birthday"));
            n.setBirthday(birthday);

            String other = request.getParameter("other");
            n.setOther(other);

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            n.setCreated_at(currentTime);
            n.setUpdated_at(currentTime);

            HttpSession session = request.getSession();
            Account a = (Account)session.getAttribute("account_user");

            String email_address = a.getEmail_address();
            n.setEmail_address(email_address);




            em.persist(n);
            em.getTransaction().commit();
            em.close();

            response.sendRedirect(request.getContextPath() + "/top");
        }
    }

}
