package controller;

import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.servlet.http.Part;

import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;

import java.util.List;
import java.util.ArrayList;

import javax.xml.bind.DatatypeConverter;
import java.security.SecureRandom;
import java.security.NoSuchAlgorithmException;

import beans.CategoryTopicBeans;
import beans.CategoryUniqueNameBeans;
import beans.StudentNewInfoBeans;
import helper.NameExtractor;

import model.TeacherRegisterModel;

/**
 * Servlet implementation class TeacherRegisterServlet
 */
@WebServlet("/TeacherRegisterNewServlet")
public class TeacherRegisterNewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TeacherRegisterNewServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	private void forwardJSP(String url, HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(url);
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession(false);

		String jspname = null;
		jspname = "teacher_register.jsp";

		forwardJSP(jspname, request, response);
	}
}
