package testWeb.servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;

import testWeb.dao.HistoryRecordDAO;
import testWeb.dao.impl.HistoryRecordDAOImpl;
import testWeb.vo.HistoryRecord;
public class RecordAddServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
		HistoryRecord record = new HistoryRecord();
		record.setRobotname(req.getParameter("robotname"));
		record.setExploration_time(req.getParameter("exploration_time"));
		record.setTreasure(req.getParameter("treasure"));
		record.setPicture(req.getParameter("picture"));
		HistoryRecordDAO dao = new HistoryRecordDAOImpl();
		
		if(dao.addRecord(record) >= 1) {
			//req.setAttribute("addtemessage", "Success Add");
			res.sendRedirect("./AddSuccess.jsp");
		}else {
			//req.setAttribute("noaddmessage", "Failure Add");
			res.sendRedirect("./AddFailure.jsp");
		}
		//RequestDispatcher dispatcher = req.getRequestDispatcher("explorationRecord.jsp");
	    //dispatcher.forward(req, res);
		}
}
