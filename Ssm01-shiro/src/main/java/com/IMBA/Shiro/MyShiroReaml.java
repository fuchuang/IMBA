package com.IMBA.Shiro;
import com.IMBA.entity.clock_in;
import com.IMBA.entity.student;
import com.IMBA.redis.RedisUtil;
import com.IMBA.service.clock_inService;
import com.IMBA.service.impl.studentServiceImpl;
import com.IMBA.service.studentService;
import com.IMBA.utils.JsonUtil;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


public class MyShiroReaml extends AuthorizingRealm {
    @Autowired
    private RedisUtil redisUtil;
//    @Autowired
//    private  studentService studentservice;
    public static final String STU_ID = "stu_Id";

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("ddd");
        //授权
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        Object principal = principalCollection.getPrimaryPrincipal();//获取登录的用户名
        String key=STU_ID+principal;
        String studentjson=(String) redisUtil.get(key);
        student s=JsonUtil.toBean(student.class,studentjson);
        System.out.println("isamin:"+s.getIsadmin());

        if (!s.getIsadmin()){
            //学生
            System.out.println("false");
            info.addRole("student");

        }
        if (s.getIsadmin()){
            //老师
            System.out.println("老师");
            info.addRole("teacher");
        }

        return info;
    }

    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        Object principal = authenticationToken.getPrincipal();
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpSession session=request.getSession();


        String pass=null;
        System.out.println("namexxxx: "+principal);
        String name= String.valueOf(principal);
        System.out.println("namexxxx111: "+name);
        String key=STU_ID+principal;
       // 在redis中查找
        if (redisUtil.hasKey(key)){
            //存在
            //获取密码
            System.out.println("redis: "+principal);
            String studentjson=(String) redisUtil.get(key);
            student s=JsonUtil.toBean(student.class,studentjson);
            pass=s.getPassword();

            session.setAttribute("username",s.getStuName());
            session.setAttribute("stu_id",s.getStuId());
            session.setAttribute("id",s.getId());
            System.out.println("pass: "+pass);

        }else {
            //不存在在数据库中查找
            student stu= shiroService.findstudentBystuid(name);
            System.out.println("null: "+principal);

            if (stu==null){
                System.out.println("null: "+principal);
                //不存在
                return null;
            }else {
                //添加入redis中
                List<student>studentList=shiroService.selectall();
                for (student stus : studentList){
                    System.out.println("id :"+stus.getStuId());
                    System.out.println("password:"+stus.getPassword());
                    //将信息放入redis

                    redisUtil.put(STU_ID+stus.getStuId(), JsonUtil.toJson(stus));
                }
                session.setAttribute("username",stu.getStuName());
                session.setAttribute("id",stu.getId());
                session.setAttribute("stu_id",stu.getStuId());

                pass= stu.getPassword();
                System.out.println("pass: "+pass);
                //存在
            }

        }
//        String credentials = pass;
//        //3.设置盐值 ，（加密的调料，让加密出来的东西更具安全性，一般是通过数据库查询出来的。 简单的说，就是把密码根据特定的东西而进行动态加密，如果别人不知道你的盐值，就解不出你的密码）
//        String source = "abcdefg";
//        ByteSource credentialsSalt = new Md5Hash(source);
//
//
//        //当前 Realm 的name
//        String realmName = getName();
//        //返回值实例化
//        SimpleAuthenticationInfo info =
//                new SimpleAuthenticationInfo(principal, credentials,
//                        credentialsSalt, realmName);



       SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(name, pass, getName());

        return info;
    }
//    public void setCredentialMatcher(){
//        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
//        credentialsMatcher.setHashAlgorithmName("MD5");//MD5算法加密
//        credentialsMatcher.setHashIterations(1024);//1024次循环加密
//        setCredentialsMatcher(credentialsMatcher);
//    }
//    public static void main(String[] args) {
//        String saltSource = "abcdef";
//        String hashAlgorithmName = "MD5";
//        String credentials = "passwor";
//        Object salt = new Md5Hash(saltSource);
//        int hashIterations = 1024;
//        Object result = new SimpleHash(hashAlgorithmName, credentials, salt, hashIterations);
//        System.out.println(result);
//    }

    private studentService shiroService;

    public void setShiroService(studentServiceImpl shiroService) {
        this.shiroService = shiroService;
    }

    public studentService getShiroService() {
        return shiroService;
    }
}
