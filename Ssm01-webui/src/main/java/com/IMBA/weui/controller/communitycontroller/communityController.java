package com.IMBA.weui.controller.communitycontroller;

import com.IMBA.entity.*;
import com.IMBA.model.*;
import com.IMBA.redis.RedisUtil;
import com.IMBA.service.*;
import com.IMBA.solr.postSolr;
import com.IMBA.utils.SensitivewordFilter;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.sf.json.JSONObject;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

//社区
@Controller
public class communityController {
    @Autowired
    postsService postsservice;
    @Autowired
    posts_commentsService postsCommentsService;

    @Autowired
    private studentService studentservice;
    @Autowired
    private posts_collectionService postsCollectionService;
    @Autowired
    private recently_readService recentlyReadService;
    @Autowired
    RedisUtil redisUtil;

    public static  final String POSTS_RANK= "posts_rank";


    //发帖
    @RequestMapping(value = "/commnity/postadd")
    @ResponseBody
    JSONObject postadd(@RequestParam(name = "isAnonymity",defaultValue = "true")boolean isAnonymity, @RequestParam(name = "title",defaultValue = "学车的技巧")String tile,
                        @RequestParam(name = "content",defaultValue = "法轮功学习技巧")String content, @RequestParam(name = "tags",defaultValue = "标签")String tags, HttpServletRequest request){
        HttpSession session=request.getSession();
        int student_id= (int) session.getAttribute("id");//账号
        SensitivewordFilter filter = new SensitivewordFilter();
        Set<String> set = filter.getSensitiveWord(content, 1);
        if (set.size()>0){
            Map<String,Object> msg=new HashMap<>();
            msg.put("msg","存在敏感词");
            return  JSONObject.fromObject(msg);
        }
        set.clear();
        set=filter.getSensitiveWord(tags, 1);
        if (set.size()>0){
            Map<String,Object> msg=new HashMap<>();
            msg.put("msg","存在敏感词");
            return  JSONObject.fromObject(msg);
        }
        set.clear();
        set=filter.getSensitiveWord(tile, 1);
        if (set.size()>0){
            Map<String,Object> msg=new HashMap<>();
            msg.put("msg","存在敏感词");
            return  JSONObject.fromObject(msg);
        }


        posts record=new posts();
        record.setIsanonymity(isAnonymity);
        record.setPostsContent(content);
        record.setPostsTime(new Date());
        record.setStudentId(student_id);
        record.setPostsTags(tags);
        record.setPostsTitle(tile);
        postsservice.insert(record);
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg","success");
        return  JSONObject.fromObject(msg);


    }
    //帖子列表
    @RequestMapping(value = "/commnity/postlist")
    @ResponseBody
    JSONObject postlist(@RequestParam(name = "start",defaultValue = "0")int start,@RequestParam(name = "rows",defaultValue = "10")int rows) throws IOException, SolrServerException {

        postSolr postsolr=new postSolr();
        List<posts>postsList=postsolr.Searchpostlist(start,rows);
        List<postdetailmodel> postdetailmodelList =new ArrayList<>();

        for(posts post:postsList){
            postdetailmodel postmodels=new postdetailmodel();
            postmodel pmodel=new postmodel();
            pmodel.setIsanonymity(post.getIsanonymity());
            if (!post.getIsanonymity()){
                student s= studentservice.findstudentByid(post.getStudentId());
                pmodel.setName(s.getStuName());
            }
            pmodel.setPostsContent(post.getPostsContent());
            pmodel.setPostsTags(post.getPostsTags());
            Date date=post.getPostsTime();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = formatter.format(date);
            pmodel.setPostsTime(dateString);
            pmodel.setPostsTitle(post.getPostsTitle());
            int count=postsCommentsService.findrowsbypostid(post.getId());
            postmodels.setComments(count);
            postmodels.setPost(pmodel);
            postdetailmodelList.add(postmodels);
        }
        SearchResult searchResult=new SearchResult();
        searchResult.setObjectList(postdetailmodelList);
        searchResult.setTotalnums(postdetailmodelList.size());
        int totalpages= postdetailmodelList.size()%rows==0?(postdetailmodelList.size()/rows):(postdetailmodelList.size()/rows+1);
        searchResult.setTotalpage(totalpages);
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg",searchResult);
        return  JSONObject.fromObject(msg);

    }

    //搜一搜


    //评论
    @RequestMapping(value = "/commnity/commentsadd")
    @ResponseBody()
    JSONObject commentadd(@RequestParam(name = "content")String content,
                          @RequestParam(name = "sub_comment_id")int sub_comment_id
            ,@RequestParam(name = "post_id",defaultValue = "0")int post_id,HttpServletRequest request){

        HttpSession session=request.getSession();
        int student_id= (int) session.getAttribute("id");//账号

        posts_comments record=new posts_comments();
        record.setCommentsContent(content);
        record.setCommentsTime(new Date());
        if (post_id>0){
            record.setPostsId(post_id);
        }

        record.setStudentId(student_id);
        record.setSubCommentId(sub_comment_id);

        postsCommentsService.insert(record);
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg",record);
        return  JSONObject.fromObject(msg);

    }
    //搜索模糊
    @RequestMapping(value = "/commnity/keyword")
    @ResponseBody()
    JSONObject findkeyword(@RequestParam(name = "title")String title) throws IOException, SolrServerException {

        postSolr postsolr=new postSolr();
        List<posts>postsList=postsolr.Searchkeyword(title);
        List<String>titles=new ArrayList<>();
        for (posts p:postsList){
            titles.add(p.getPostsTitle());
        }
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg",titles);
        return  JSONObject.fromObject(msg);
    }
    //页面
    @RequestMapping(value = "/commnity/postsid")
    @ResponseBody()
    JSONObject postid(@RequestParam(name = "post_id")int post_id,HttpServletRequest request){


        HttpSession session=request.getSession();
        int student_id= (int) session.getAttribute("id");//账号
        posts post=postsservice.findbypostid(post_id);

        postmodel pmodel=new postmodel();
        pmodel.setIsanonymity(post.getIsanonymity());
        if (!post.getIsanonymity()){
            student s= studentservice.findstudentByid(post.getStudentId());
            pmodel.setName(s.getStuName());
        }
        pmodel.setPostsContent(post.getPostsContent());
        pmodel.setPostsTags(post.getPostsTags());
        Date date=post.getPostsTime();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = formatter.format(date);
        pmodel.setPostsTime(dateString);
        pmodel.setPostsTitle(post.getPostsTitle());


        //插入阅读过
        if(recentlyReadService.findbypostid(post_id,student_id)==null){
            recently_readKey record=new recently_readKey();
            record.setPostsId(post_id);
            record.setStudentId(student_id);
            recentlyReadService.insert(record);
        }

        //插入redis中排行榜单

        String postname= post_id+":"+pmodel.getPostsTitle();
        redisUtil.incrementScore(POSTS_RANK,postname,1);
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg",pmodel);
        return  JSONObject.fromObject(msg);
    }


    //评论
    @RequestMapping(value = "/commnity/commentsid")
    @ResponseBody()
    JSONObject commentid(@RequestParam(name = "post_id")int post_id,@RequestParam(name = "start",defaultValue = "0")int start,@RequestParam(name = "rows",defaultValue = "10")int rows){
//        SearchResult searchResult=new SearchResult();
        PageHelper.startPage(start, rows);
        List<posts_comments>postsList=postsCommentsService.findbypostid(post_id);
        List<postcommentomdel>postcommentomdelList=new ArrayList<>();
        //查找信息
        for (posts_comments p :postsList){
            postcommentomdel postcommentomdel1=new postcommentomdel();

            System.out.println(p.getStudentId());
            student s= studentservice.findstudentByid(p.getStudentId());
            studentmodel stu=new studentmodel();
            stu.setAvatarPath(s.getAvatarPath());
            stu.setStuId(s.getStuId());
            stu.setStuName(s.getStuName());
            postcommentomdel1.setStudentmodel(stu);
            Date date=p.getCommentsTime();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = formatter.format(date);

            postcommentomdel1.setCommentstime(dateString);
            postcommentomdel1.setId(p.getId());
            postcommentomdel1.setPostsId(p.getPostsId());
            postcommentomdel1.setSubCommentId(p.getSubCommentId());
            postcommentomdel1.setCommentsContent(p.getCommentsContent());
            postcommentomdelList.add(postcommentomdel1);

        }

        PageInfo<postcommentomdel> pageInfo=new PageInfo<postcommentomdel>(postcommentomdelList);
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg",pageInfo);
        return  JSONObject.fromObject(msg);

    }
    //关键词查找页面
    @RequestMapping(value = "/commnity/findkeywordposts")
    @ResponseBody()
    JSONObject findkeywordpost(@RequestParam(name = "title")String title,@RequestParam(name = "start",defaultValue = "0")int start,@RequestParam(name="rows",defaultValue = "10")int rows) throws IOException, SolrServerException {

        postSolr postsolr=new postSolr();
        List<posts>postsList=postsolr.Search(title,start,rows);
        List<postdetailmodel> postdetailmodelList =new ArrayList<>();


        for(posts post:postsList){
            postdetailmodel postmodels=new postdetailmodel();
            postmodel pmodel=new postmodel();
            pmodel.setIsanonymity(post.getIsanonymity());
            if (!post.getIsanonymity()){
                student s= studentservice.findstudentByid(post.getStudentId());

                pmodel.setName(s.getStuName());
            }
            pmodel.setPostsContent(post.getPostsContent());
            pmodel.setPostsTags(post.getPostsTags());
            Date date=post.getPostsTime();
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = formatter.format(date);
            pmodel.setPostsTime(dateString);
            pmodel.setPostsTitle(post.getPostsTitle());
            int count=postsCommentsService.findrowsbypostid(post.getId());
            postmodels.setComments(count);
            postmodels.setPost(pmodel);
            postdetailmodelList.add(postmodels);
        }
        SearchResult searchResult=new SearchResult();
        searchResult.setObjectList(postdetailmodelList);
        searchResult.setTotalnums(postdetailmodelList.size());
        int totalpages= postdetailmodelList.size()%rows==0?(postdetailmodelList.size()/rows):(postdetailmodelList.size()/rows+1);
        searchResult.setTotalpage(totalpages);
        Map<String,Object> msg=new HashMap<>();
        msg.put("msg",searchResult);
        return  JSONObject.fromObject(msg);
    }
    //收藏帖子
    @RequestMapping(value = "/commnity/collection")
    @ResponseBody()
    JSONObject collection(@RequestParam(name = "postid")int postid,HttpServletRequest request)throws IOException, SolrServerException {
        HttpSession session=request.getSession();
        int student_id= (int) session.getAttribute("id");//账号
        posts_collectionKey record=new posts_collectionKey();
        record.setPostsId(postid);
        record.setStudentId(student_id);
        postsCollectionService.insert(record);

        Map<String,Object> msg=new HashMap<>();
        msg.put("msg","success");
        return  JSONObject.fromObject(msg);
    }
    //收藏帖子
    @RequestMapping(value = "/commnity/iscollection")
    @ResponseBody()
    JSONObject iscollection(@RequestParam(name = "postid")int postid,HttpServletRequest request) throws IOException, SolrServerException {

        HttpSession session=request.getSession();
        int student_id= (int) session.getAttribute("id");//账号
        posts_collectionKey postsCollectionKey=postsCollectionService.findbypostidandstuid(postid,student_id);
        Map<String,Object> msg=new HashMap<>();
        if (postsCollectionKey!=null){

            msg.put("msg","已收藏");
        }else {
            msg.put("msg","未收藏");
        }

        return  JSONObject.fromObject(msg);
    }



}
