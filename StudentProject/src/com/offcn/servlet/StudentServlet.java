package com.offcn.servlet;


import com.offcn.bean.Student;
import com.offcn.service.Impl.StudentServiceImpl;
import com.offcn.service.StudentService;
import com.offcn.utils.PageUtils;
import com.offcn.utils.String2DateUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@WebServlet("*.do")
@MultipartConfig
public class StudentServlet extends BaseServlet{

    private StudentService studentService = new StudentServiceImpl();

    public void updateStudentMessage(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        //2.接收请求数据
        String sid = req.getParameter("sid");
        String sname = req.getParameter("sname");
        String gender = req.getParameter("gender");
        String sbri = req.getParameter("sbir");
        String[] hobbies = req.getParameterValues("hobby");
        //获取老图片
        String fileName = req.getParameter("oldPhoto");//表示传上来的图片


        Part partNew = req.getPart("file");
        String newFileName = partNew.getSubmittedFileName();

        //partNew如果有数据，则图片被修改了
        if (newFileName != null && !("".equals(newFileName))) {
            //考虑到不同的的用户可能会提交同名的文件，我们需要对文件名称做出处理
            fileName = "" + UUID.randomUUID() + System.currentTimeMillis() + newFileName;

            //判断路径是否存在
            String savePath = "E://upload/";
            File file = new File(savePath);
            //如果路径不存在，则创建路径中的文件夹
            if (!file.exists()){
                file.mkdir();
            }
            //将图片保存到磁盘
            partNew.write(savePath+ fileName );

        }

        //创建student对象封装数据,写回数据库
        Student student = new Student(Integer.parseInt(sid), sname, gender, String2DateUtils.getDate(sbri), Arrays.toString(hobbies), fileName);

        //调用service层，保存数据
        //如果数据保存成功，则重新查询展示全新的数据
        if (studentService.updateStudent(student)) {
            resp.sendRedirect("http://localhost:8080/StudentProject/queryStudent.do");
        }else
        {
            //如果修改失败，就打印修改失败的字样
            resp.getWriter().println("添加失败！");
        }
    }


    /**
     * 修改数据第一阶段，查询数据并且回显
     * @param req
     * @param resp
     */
    public void updateBack(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收请求数据
        String sid = req.getParameter("sid");

        //2.根据ID查出学生信息
        Student student = studentService.selectById(sid);

        //绑定到域对象
        req.setAttribute("student",student);

        //3.转发到修改页面，进行数据回显
        req.getRequestDispatcher("UpdateStudent.jsp").forward(req,resp);

    }

    /**
     *删除学生对象
     */

    public void deleteStudent(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //1.接收请求参数
        String ids = req.getParameter("ids");

        //2.进行删除操作
        //3.如果删除成功就重新查询删除之后的操作呈现在页面
        if (studentService.deleteStudent(ids)) {
            resp.sendRedirect("http://localhost:8080/StudentProject/queryStudent.do");
        }else {
            //如果删除失败，就返回删除失败字样
            resp.getWriter().println("删除失败！");
        }
    }

    public void queryStudent(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.接收请求数据
        String curPage = req.getParameter("curPage");
        String sname = req.getParameter("sname");
        String gender = req.getParameter("gender");

        //2.查询总记录数
        int count = studentService.selectCount(sname, gender);

        //3.查询符合条件的数据
        PageUtils pageUtils = new PageUtils(count, curPage);
        List<Student> list = studentService.selectByPage(pageUtils, sname, gender);

        //4.域对象绑定数据
        req.setAttribute("list",list);
        req.setAttribute("pageUtils",pageUtils);
        req.setAttribute("sname",sname);
        req.setAttribute("gender",gender);

        //5.转发到前端页面
        req.getRequestDispatcher("StudentMessage.jsp").forward(req,resp);
    }


    public void addStudentServlet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //2.接收请求数据
        String sname = req.getParameter("sname");
        String gender = req.getParameter("gender");
        String sbri = req.getParameter("sbir");
        String[] hobbies = req.getParameterValues("hobby");
        Part file = req.getPart("file");
        String FileName = file.getSubmittedFileName();

        //考虑到不同的的用户可能会提交同名的文件，我们需要对文件名称做出处理
        FileName = "" + UUID.randomUUID() + System.currentTimeMillis() + FileName;

        //3.创建student对象封装数据
        Student student = new Student(null, sname, gender, String2DateUtils.getDate(sbri), Arrays.toString(hobbies), FileName);

        //4.如果数据保存成功，则进一步保存上传的图片
        if (studentService.addStudent(student)) {
            //判断路径是否存在
            String savePath = "E://upload/";
            File file1 = new File(savePath);
            //如果路径不存在，则创建路径中的文件夹
            if (!file1.exists()){
                file1.mkdir();
            }

            //将图片保存到磁盘
            file.write(savePath+FileName);

            resp.getWriter().println("添加成功！");
        }else
        {
            resp.getWriter().println("添加失败！");
        }
    }
}
