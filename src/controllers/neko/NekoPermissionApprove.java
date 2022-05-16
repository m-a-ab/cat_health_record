package controllers.neko;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.AccessPermission;
import models.Account;
import utils.DBUtil;

/**
 * Servlet implementation class AccessPermission
 */
@WebServlet("/neko_permission_approve")
public class NekoPermissionApprove extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NekoPermissionApprove() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("id");
        int id = 0;
        try {
            id = Integer.parseInt(idStr);
        } catch (Exception e) {
            request.getSession().setAttribute("error", "不正なアクセスです。");
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }

        EntityManager em = DBUtil.createEntityManager();
        em.getTransaction().begin();
        AccessPermission permission = em.find(AccessPermission.class, id);
        HttpSession session = request.getSession();
        Account a = (Account) session.getAttribute("account_user");
        String loginAddress = a.getEmail_address();
        String permissionAddress = permission.getNeko().getEmail_address();

        if (!loginAddress.equals(permissionAddress)) {
            request.getSession().setAttribute("error", "許可する権限がありません。");
            response.sendRedirect(request.getContextPath() + "/");
            return;
        }

        permission.setPermission(true);
        em.persist(permission);
        em.getTransaction().commit();
        em.close();

        request.getSession().setAttribute("flush", "アクセスを許可しました。");
        response.sendRedirect(request.getContextPath() + "/");

    }

}
