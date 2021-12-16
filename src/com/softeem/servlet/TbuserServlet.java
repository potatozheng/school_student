package com.softeem.servlet;

import com.softeem.dto.ServiceModel;
import com.softeem.dto.Tbstudent;
import com.softeem.dto.Tbteacher;
import com.softeem.dto.Tbuser;
import com.softeem.service.TbstudentService;
import com.softeem.service.TbteacherService;
import com.softeem.service.TbuserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user")
public class TbuserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码格式
        request.setCharacterEncoding("utf-8");
        //获取到前端页面隐藏域中请求的name属性后面的值试什么
        String method = request.getParameter("method");
        System.out.println("信息传过来了!!!");
        switch (method){
            case "login":
                login(request,response);
                break;
            /*用来处理用户退出之后将信息删除*/
            case "logout":
                logout(request,response);
                break;
        }
    }

    /**
     * 安全退出(注销)
     * 防止退出之后信息还在,返回上一步还能获取到之前的信息
     * @param request
     * @param response
     */
    private void logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //负责将session中的信息消除
        request.getSession().invalidate();
        response.sendRedirect("login.jsp");
    }

    /**
     * 登录的方法
     * 登录的逻辑:
     * 1、从前台传过来两个值,一个是账号一个是密码
     * 2、将账号信息拿到之后到数据库中寻找这个信息
     * 3、将找到的对象的密码和输入的密码进行对比
     * 4、如果密码正确,说明能够正常登录
     * 5、进行值得回传和页面的跳转
     * @param request
     * @param response
     */
    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //用户id
        String id = request.getParameter("id");
        System.out.printf("账号:" + id);
        //用户密码
        String pwd = request.getParameter("pwd");
        System.out.println("密码:" + pwd);
        //用于处理用户状态的状态码
        //0、管理员 1、学生 2、老师
        String state = request.getParameter("state");
        System.out.println("权限:" + state);
        //将状态码从字符串类型转换成整数类型
        int uid = Integer.parseInt(id);
        int mark = Integer.parseInt(state);

        Tbuser user = new Tbuser();;
        user.setUid(uid);
        user.setPassword(pwd);
        //对象模块化处理
        ServiceModel model = new ServiceModel();
        //对象的逻辑处理
        TbuserService service = new TbuserService();
        model = service.login(user);
        if(model.getCode() == 1){
            //request.getSession().setAttribute("stu",model.getData());
            //response.sendRedirect("daily?method=findMyDaily");
        }else{
            //request.setAttribute("msg",model.getMessage());
            //request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}