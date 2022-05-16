package controllers.condition;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class ConditionIndexServlet
 */
@WebServlet("/condition_index")
public class ConditionIndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConditionIndexServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EntityManager em = DBUtil.createEntityManager();

        List<Condition> conditions = em.createNamedQuery("getAllConditions", Condition.class).getResultList();
        response.getWriter().append(Integer.valueOf(conditions.size()).toString());

        em.close();

        request.setAttribute("conditions",conditions);

        RequestDispatcher rd =request.getRequestDispatcher("WEB-INF/views/condition/condition_index.jsp");
          rd.forward(request, response);


    }
}
