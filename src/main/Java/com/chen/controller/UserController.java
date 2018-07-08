package com.chen.controller;
import javax.servlet.http.HttpServletRequest;

import com.chen.model.User;
import com.chen.service.IUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private IUserService userService;


    /**
     * 分页查询
     * @param pageNum
     * @param pageSize
     * @param request
     * @param response
     * @return
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping("/showUser.do")
    public Map<String, Object> selectUser(Integer pageNum ,Integer pageSize,HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
//        long userId = Long.parseLong(request.getParameter("id"));
        PageInfo<User> user = this.userService.selectUser(pageNum  , pageSize);
        Map<String, Object> map = new HashMap<String, Object>();
        List<Object> data = new ArrayList<Object>();
        for(User admin : user.getList()){
            Map<String, Object> obj = new HashMap<String, Object>();
            obj.put("id", admin.getId());
            obj.put("account", admin.getEmail());
            obj.put("locked", admin.getId());
            obj.put("roleIds", admin.getPassword());
            data.add(obj);
        }
        //pageInfo.getList()就可以得到 分页后的数据。 pageInfo.getTotal()可以得到总记录数。
        map.put("recordsTotal", user.getTotal());

        map.put("recordsFiltered", user.getList());
//        map.put("data", data);
        return map;


//        ObjectMapper mapper = new ObjectMapper();
//        response.getWriter().write(mapper.writeValueAsString(user));
//        response.getWriter().close();
    }

    @ResponseBody
    @RequestMapping("/findUser.do")
    public User selectFind(String id){

        return userService.selectFindUser(id);

    }

}
