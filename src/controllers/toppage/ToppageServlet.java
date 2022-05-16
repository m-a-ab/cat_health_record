package controllers.toppage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.AccessPermission;
import models.Account;
import models.NekoAccount;
import utils.DBUtil;

/**
 * Servlet implementation class ToppageServlet
 */
@WebServlet("/top")
public class ToppageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ToppageServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        /** 猫の承認依頼を取得 */
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("account_user");
        String address = a.getEmail_address();

        List<NekoAccount> nekos = em.createNamedQuery("getNekoAccountByEmailAddress"
                , NekoAccount.class)
                .setParameter("email_address", address)
                .getResultList();

        List<AccessPermission> accessPermissions = new ArrayList<AccessPermission>();
        for ( NekoAccount neko :nekos ) {

            List<AccessPermission> tmpAccessPermissions = em.createNamedQuery("getUnApprovePermissions"
                    , AccessPermission.class)
                    .setParameter("neko", neko)
                    .getResultList();
            accessPermissions.addAll(tmpAccessPermissions);
        }

        em.close();

        if (accessPermissions.size() == 0) {
            request.setAttribute("accessPermissions", null);
        } else {
            request.setAttribute("accessPermissions", accessPermissions);
        }


        // フラッシュメッセージがセッションスコープにセットされていたら
        // リクエストスコープに保存する（セッションスコープからは削除）
        if (request.getSession().getAttribute("flush") != null) {
            request.setAttribute("flush", request.getSession().getAttribute("flush"));
            request.getSession().removeAttribute("flush");
            request.setAttribute("error", request.getSession().getAttribute("error"));
            request.getSession().removeAttribute("error");
        }



        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/cat_info/nekolist.jsp");
        request.setAttribute("nekolist", nekos);/*追記*/
        rd.forward(request, response);
    }

}
