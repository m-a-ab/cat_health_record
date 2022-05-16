package controllers.condition;

import java.io.IOException;
import java.sql.Date;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Condition;
import utils.DBUtil;

/**
 * Servlet implementation class ConditionUpdateServlet
 */
@WebServlet("/condition_update")
public class ConditionUpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConditionUpdateServlet() {
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

            //セッションスコープから取得、メッセージ１件をデータベースから取得
            Condition c =em.find(Condition.class, (Integer)(request.getSession().getAttribute("conditions_id")));

            //各項目に上書き
         /* Integer neko_id= Integer.valueOf(request.getParameter("neko_id"));
          c.setNeko_id(neko_id);*/

          Date date = Date.valueOf(request.getParameter("date"));
          c.setDate(date);

          String food=request.getParameter("food");
          c.setFood(food);

          String food_other=request.getParameter("food_other");
          c.setFood_other(food_other);

          String water=request.getParameter("water");
          c.setWater(water);

          String water_other=request.getParameter("water_other");
          c.setWater_other(water_other);


          String pee=request.getParameter("pee");
          c.setPee(pee);

          String pee_other=request.getParameter("pee_other");
          c.setPee_other(pee_other);

          String poop=request.getParameter("poop");
          c.setPoop(poop);

          String poop_other=request.getParameter("poop_other");
          c.setPoop_other(poop_other);

          String vomit=request.getParameter("vomit");
          c.setVomit(vomit);

          String vomit_other=request.getParameter("vomit_other");
          c.setVomit_other(vomit_other);

          String exercise=request.getParameter("exercise");
          c.setExercise(exercise);

          String exercise_other=request.getParameter("exercise_other");
          c.setExercise_other(exercise_other);

          String etc=request.getParameter("etc");
          c.setEtc(etc);

          //データベース更新
          em.getTransaction().begin();
          em.getTransaction().commit();
          em.close();

          //不要になったデータ削除
          request.getSession().removeAttribute("conditions_id");

          //リダイレクト
          response.sendRedirect(request.getContextPath()+"/top");



    }
    }
}

