package com.IMBA.solr;

import com.IMBA.entity.posts;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class postSolr{
//    private static final String URL="http://192.168.80.128:8080/solr/post_core"; //solr服务器地址
    private static final String URL="https://campus.gbdev.cn:8080/solr/post_core"; //solr服务器地址
    private static HttpSolrClient solrClient = null;
    private void init(){
        solrClient = new HttpSolrClient.Builder(URL).build();
        solrClient.setConnectionTimeout(3000);
    }
    public List<posts> getpostList(SolrDocumentList solrDocumentList) throws IOException, SolrServerException {
        List<posts> postsList=new ArrayList<posts>();
        for (SolrDocument solrDocument:solrDocumentList){
            posts p=new posts();
            String id= (String) solrDocument.getFieldValue("id");
            p.setId(Integer.valueOf(id));
            String isAnonymity= (String) solrDocument.getFieldValue("isAnonymity");
            p.setIsanonymity(Boolean.valueOf(isAnonymity));
            p.setPostsTitle((String) solrDocument.getFieldValue("posts_title"));
            p.setPostsContent((String) solrDocument.getFieldValue("posts_content"));
            p.setPostsTime((Date) solrDocument.getFieldValue("posts_time"));
            p.setStudentId((Integer) solrDocument.getFieldValue("student_id"));
            postsList.add(p);

        }
        return postsList;


    }

    public SolrDocumentList search(SolrQuery query) throws IOException, SolrServerException {
            SolrDocumentList solrDocumentList=null;
            //查询
            QueryResponse response = solrClient.query(query);
            //返回索引文本集合
            solrDocumentList = response.getResults();
        return solrDocumentList;
    }
    /**
     * 传入关键字查询索引
     */
    public List<posts> Searchkeyword(String keyword) throws IOException, SolrServerException {
        init();
        SolrQuery query=new SolrQuery();
        //排序规则
        query.addSort("id", SolrQuery.ORDER.asc);
        //从什么id开始
        query.setStart(0);
        //要显多少条记录
        query.setRows(5);
        //查询关键字
        query.set("q","posts_title:"+"*"+keyword+"*");
        SolrDocumentList solrDocumentList=null;
        solrDocumentList=search(query);
        return getpostList(solrDocumentList);
    }



//分页
public List<posts> Search(String keyword, int start, int rows) throws IOException, SolrServerException {
    init();
    SolrQuery query=new SolrQuery();
    //排序规则
    query.addSort("id", SolrQuery.ORDER.asc);
    //从什么id开始
    query.setStart(start);
    //要显多少条记录
    query.setRows(rows);
    //查询关键字
    query.set("q","posts_title:"+"*"+keyword+"*");
    SolrDocumentList solrDocumentList=null;
    solrDocumentList=search(query);
    return getpostList(solrDocumentList);
}
    public List<posts> Searchpostlist(int start, int rows) throws IOException, SolrServerException {
        init();
        SolrQuery query=new SolrQuery();
        //排序规则
        query.addSort("id", SolrQuery.ORDER.asc);
        //从什么id开始
        query.setStart(start);
        //要显多少条记录
        query.set("q","*:*");
        query.setRows(rows);
        SolrDocumentList solrDocumentList=null;
        solrDocumentList=search(query);
        return getpostList(solrDocumentList);
    }


}
