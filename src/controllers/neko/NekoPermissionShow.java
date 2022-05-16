package controllers.neko;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.AccessPermission;
import utils.DBUtil;

/**
 * Servlet implementation class AccessPermission
 */
@WebServlet("/neko_permission_show")
public class NekoPermissionShow extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NekoPermissionShow() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idStr = request.getParameter("id");
        int id = 0;
        try {
            id = Integer.parseInt(idStr);
        } catch (Exception e) {
        }

        EntityManager em = DBUtil.createEntityManager();

        AccessPermission permission = em.find(AccessPermission.class, id);


        em.close();

        request.setAttribute("permission", permission);



        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/cat_info/neko_permission_show.jsp");
        rd.forward(request, response);
    }

}
