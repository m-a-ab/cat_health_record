package controllers.condition;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Condition;
import utils.DBUtil;

/**
 * Servlet implementation class ConditionDestroyServlet
 */
@WebServlet("/condition_destroy")
public class ConditionDestroyServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConditionDestroyServlet() {
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

      //セッションスコープからIDを取得
      //該当のIDをデータベースから取得

    Condition c =em.find(Condition.class, (Integer)(request.getSession().getAttribute("conditions_id")));

    em.getTransaction().begin();
    em.remove(c);
    em.getTransaction().commit();
    em.close();

    //セッションスコープ上の不要なデータ削除
    request.getSession().removeAttribute("conditions_id");

    //indexページ
    response.sendRedirect(request.getContextPath()+"/top");
    }
    }
}
