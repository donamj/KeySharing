/*
 * ShareGenerateControlelr is the servlet that handles the share generation operation
 * It get the data from form and invokes the appropriate function
 */

package com.keysharing;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShareGenerateController
 */
public class ShareGenerateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShareGenerateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Getting the data from the form
		int level = Integer.parseInt(request.getParameter("level"));
		int share = Integer.parseInt(request.getParameter("share"));
		String key = request.getParameter("key");
		ShareGenerate obj = new ShareGenerate();
		//Assigning the values to the ShareGenerate class instance
		obj.setPassword(key);
		obj.level = level;
		obj.n = share;
		//Invoking the function to generate shares
		obj.generateShares();
		Share arr[] = obj.shares;
		PrintWriter out = response.getWriter();
		//Presenting the generated shares to the user
		out.print("<center><h1>Shares are : </h1>"); 
		for (int i=0;i<arr.length;i++)
		{
			out.print(arr[i].id + " - " + arr[i].share + "<br>");
		}
		
		out.print("Prime number : "+ obj.getPrimeNo());
		out.print("<h3><br><br><br>	<a href=index.jsp>RETURN HOME</a><br>	</h3><br></center>");
		
	}

}
