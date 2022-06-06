import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

@WebServlet("/downloadservlet")
public class DownloadfileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置请求字符集
        req.setCharacterEncoding("utf-8");
//        resp.setContentType("text/html;charset=utf-8");

        //接收请求：要知道下载的是哪一个文件
        String filename = req.getParameter("filename");//a.txt
        //设置响应头，告知流量器我传的是什么，你该咋处理
        resp.setHeader("content-Disposition","attachment;filename="+ URLEncoder.encode(filename,"utf-8"));
        //通过域对象可以获取到项目中具体指定的资源
        ServletContext servletContext = req.getServletContext();
        //创建字节输入流，将工程中的资源读取进服务器
        InputStream is = servletContext.getResourceAsStream("files/" + filename);
        ServletOutputStream os = resp.getOutputStream();

        byte[] bytes = new byte[8192];
        int len;

        while ((len = is.read(bytes)) != -1){
            os.write(bytes,0,len);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
