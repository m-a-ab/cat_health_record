package controllers.neko;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.NekoAccount;

/**
 * Servlet implementation class NekoNewServlet
 */
@WebServlet("/nekonew")
public class NekoNewServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NekoNewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    request.setAttribute("_token",request.getSession().getId());

    //おまじない
    request.setAttribute("nekoaccount", new NekoAccount());


    RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/accounts/nekonew.jsp");
    rd.forward(request, response);
    }
}
