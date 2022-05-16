package controllers.neko;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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
 * Servlet implementation class AccessPermission
 */
@WebServlet("/neko_permission_apply")
public class NekoPermissionApply extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NekoPermissionApply() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/cat_info/neko_permission_apply.jsp");

        String nekoIdStr = request.getParameter("neko_id");
        int nekoId = 0;
        try {
            nekoId = Integer.parseInt(nekoIdStr);
        } catch (Exception e) {
            request.setAttribute("errorMessage", "不正なURLです。正しいURLを入力してください。");
            rd.forward(request, response);
            return;
        }

        EntityManager em = DBUtil.createEntityManager();

        NekoAccount neko = new NekoAccount();

        try {
            // 猫を取得
            neko = em.find(NekoAccount.class, nekoId);
        } catch (NoResultException ne) {
            request.setAttribute("errorMessage", "不正なURLです。正しいURLを入力してください。");
            rd.forward(request, response);
            return;
        }

        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("account_user");

        long count = em.createNamedQuery("getUnApprovePermissionCount", Long.class)
                .setParameter("neko", neko)
                .setParameter("requestUser", a)
                .getSingleResult();

        if (count == 0) {
            em.getTransaction().begin();
            AccessPermission permission = new AccessPermission();
            permission.setNeko(neko);

            permission.setRequestUser(a);
            permission.setPermission(false);
            em.persist(permission);

            em.getTransaction().commit();
        }
        em.close();

        request.setAttribute("successMessage", "許可申請が完了しました。承認されるまでお待ちください。");
        rd.forward(request, response);
    }

}
