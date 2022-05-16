package controllers.neko;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.NekoAccount;
import utils.DBUtil;

/**
 * Servlet implementation class NekoEditServlet
 */
@WebServlet("/nekoedit")
public class NekoEditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NekoEditServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        // 該当のIDの1件のみをデータベースから取得
        NekoAccount n = em.find(NekoAccount.class, Integer.parseInt(request.getParameter("id")));

        em.close();

        // 情報とセッションIDをリクエストスコープに登録
        request.setAttribute("nekoaccount", n);
        request.setAttribute("_token", request.getSession().getId());

        // メッセージIDをセッションスコープに登録
        request.getSession().setAttribute("nekoaccount_id", n.getId());

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/accounts/nekoedit.jsp");
        rd.forward(request, response);
    }

}
