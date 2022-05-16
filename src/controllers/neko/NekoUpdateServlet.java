package controllers.neko;

import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.NekoAccount;
import utils.DBUtil;

/**
 * Servlet implementation class NekoUpdateServlet
 */
@WebServlet("/nekoupdate")
public class NekoUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NekoUpdateServlet() {
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

            //IDの取得、該当のIDのみをデータベースから取得
            NekoAccount n =em.find(NekoAccount.class,(Integer)(request.getSession().getAttribute("nekoaccount_id")));

            //フォームの内容を各フィールドに上書き
            String nekoname = request.getParameter("nekoname");
            n.setNekoname(nekoname);

            String image = request.getParameter("image");
            n.setImage(image);

            Date birthday = Date.valueOf(request.getParameter("birthday"));
            n.setBirthday(birthday);

            String other = request.getParameter("other");
            n.setOther(other);

            Timestamp currentTime = new Timestamp(System.currentTimeMillis());
            n.setUpdated_at(currentTime);

            //更新
            em.getTransaction().begin();
            em.getTransaction().commit();
            em.close();

            //セッションスコープ上の不要になったデータを削除
            request.getSession().removeAttribute("nekoaccount_id");

            //猫一覧に
            response.sendRedirect(request.getContextPath()+ "/top");

        }

    }
}