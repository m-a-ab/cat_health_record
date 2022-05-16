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
import models.NekoAccount;
import utils.DBUtil;

/**
 * Servlet implementation class ConditionNewServlet
 */
@WebServlet("/condition_new")
public class ConditionNewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConditionNewServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("_token", request.getSession().getId());

    request.setAttribute("condition", new Condition());

    EntityManager em = DBUtil.createEntityManager();

    // 該当のIDの1件のみをデータベースから取得
    NekoAccount n = em.find(NekoAccount.class, Integer.parseInt(request.getParameter("neko_id")));

    em.close();

    // 情報とセッションIDをリクエストスコープに登録
    request.setAttribute("nekoaccount", n);
    request.setAttribute("_token", request.getSession().getId());

    // メッセージIDをセッションスコープに登録
    request.getSession().setAttribute("nekoaccount_id", n.getId());


    RequestDispatcher rd =request.getRequestDispatcher("/WEB-INF/views/condition/condition_new.jsp");

    rd.forward(request, response);

    }
}