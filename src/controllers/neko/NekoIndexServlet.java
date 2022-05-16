package controllers.neko;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.NekoAccount;
import utils.DBUtil;

/**
 * Servlet implementation class NekoIndexServlet
 */
@WebServlet("/nekoindex")
public class NekoIndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NekoIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        List<NekoAccount> nekoaccount = em.createNamedQuery("getAllNekoAccount", NekoAccount.class).getResultList();
        response.getWriter().append(Integer.valueOf(nekoaccount.size()).toString());

        em.close();
    }
}
