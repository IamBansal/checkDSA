//package java_lab_5th_sem.week13;
//
//import java.io.*;
//import javax.servlet.*;
//import javax.servlet.http.*;
//
//public class Program29 {
//
//    public class count extends HttpServlet
//    {
//        static int count=0,c2=0;
//        public void doGet(HttpServletRequest request, HttpServletResponse response) throws
//                ServletException, IOException
//        {
//            response.setContentType("text/html");
//            PrintWriter out = response.getWriter();
//            String name=request.getParameter("t1");
//
//            Cookie c1=new Cookie("count",String.valueOf(count));
//            c2=Integer.parseInt(c1.getValue());
//
//            if(c2==0)
//            {
//                out.println("Welcome="+name);
//                count++;
//            }
//            else
//            {
//
//                c1=new Cookie("count",String.valueOf(count));
//                count++;
//                out.println("Welcome="+name+"\t"+count);
//            }
//        }
//    }
//
//}
