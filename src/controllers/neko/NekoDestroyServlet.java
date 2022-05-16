package controllers.neko;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.NekoAccount;
import utils.DBUtil;

/**
 * Servlet implementation class NekoDestroyServlet
 */
@WebServlet("/nekodestroy")
public class NekoDestroyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NekoDestroyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String _token = request.getParameter("_token");
        if(_token != null && _token.equals(request.getSession().getId())) {
            EntityManager em = DBUtil.createEntityManager();

            NekoAccount n = em.find(NekoAccount.class,(request.getSession().getAttribute("nekoaccount_id")));

            em.getTransaction().begin();
            em.remove(n);
            em.getTransaction().commit();
            em.close();

            //データの削除
            request.getSession().removeAttribute("nekoaccount_id");

            //猫リスト
            response.sendRedirect(request.getContextPath()+"/top");



        }

    }
}
