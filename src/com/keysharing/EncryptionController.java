/*
 * This is the Servlet that controls encryption operation
 * It gets data from the user interface i.e. html form and passes the data to Encryption class
 * It also presents the result obtained to the user
 */
package com.keysharing;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EncryptionController
 */
public class EncryptionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EncryptionController() {
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
		String key = request.getParameter("key");
		String plaintext = request.getParameter("plaintext");
		PrintWriter out = response.getWriter();
		//Handling the error case i.e. when there is no  input given
		if ((key == null)|| (plaintext==null))
		{
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Enter some data!!!');");
		    out.println("</script>");
		    response.sendRedirect("index.jsp");
		}
		Encryption obj = new Encryption();
		//Assigning the values to the Encryption class instance
		obj.setPassword(key);
		obj.setPlaintext(plaintext);
		//Invoking encrypt function
		try {
			obj.encrypt();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Presenting the output to the user
		out.print("<center><h1>Cipher text : <br>"+obj.getCiphertext()+"</h1><br><br><br>"); 
		out.print("<h3>	<a href=index.jsp>RETURN HOME</a><br>	</h3><br></center>");
		
	}

}
