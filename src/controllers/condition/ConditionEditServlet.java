package controllers.condition;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Condition;
import utils.DBUtil;

/**
 * Servlet implementation class ConditionEditServlet
 */
@WebServlet("/condition_edit")
public class ConditionEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConditionEditServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        //1件をデータベースから取得
        Condition c =em.find(Condition.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        //情報とセッションIDを登録リクエストスコープ
        request.setAttribute("conditions", c);
        request.setAttribute("_token",request.getSession().getId());


        //セッションスコープに登録
        request.getSession().setAttribute("conditions_id", c.getId());

        RequestDispatcher rd =request.getRequestDispatcher("/WEB-INF/views/condition/condition_edit.jsp");
        rd.forward(request, response);
    }

}
