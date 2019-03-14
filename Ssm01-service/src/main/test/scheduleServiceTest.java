
import com.IMBA.dto.electiveResultDto;
import com.IMBA.dto.examResultDto;
import com.IMBA.dto.noticesDto;
import com.IMBA.dto.teachInfoDto;
import com.IMBA.entity.*;
import com.IMBA.utils.DownloadFile;
import com.IMBA.utils.JsonUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.notification.RunListener;
import org.springframework.beans.factory.annotation.Autowired;
import com.IMBA.service.*;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@ContextConfiguration(locations = { "classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)

public class scheduleServiceTest {

    @Autowired
    ScheduleService scheduleService;
    @Autowired
    studentService studentService;
    @Autowired
    majorService majorservice;
    @Autowired
    courseService courseservice;
    @Autowired
    bullet_commentsService bulletCommentsService;
    @Autowired
    memoService memoservice;
    @Autowired
    stu_courseService stuCourseService;
    @Autowired
    notificationService noticesService;
    @Autowired
    stu_notificationService stuNotificationService;
    @Autowired
    video_seriesService videoSeriesService;
    @Autowired
    clock_inService clockInService;
    @Autowired
    teacherService teacherservice;
    @Autowired
    electiveService electiveservice;
    @Autowired
    scoreService scoreservice;
    @Autowired
    examinationService examinationservice;
    @Autowired
    sentenceService sentenceservice;
    @Autowired
    matchService matchservice;

    @Test
    @Rollback
    public void testInsert()  {
        major newMajor=new major();
        newMajor.setClasses(2);
        newMajor.setGrade(2016);
        newMajor.setMarjorName("数字媒体技术");
        majorservice.addMajor(newMajor);
        student stu=new student();
        stu.setMajorId(newMajor.getId());
        stu.setAvatarPath("123");
        stu.setStuId("153453");
        stu.setIsadmin(false);
        stu.setPassword("123");
        stu.setPersonalizedSignatures("123231");
        stu.setSex("男");
        stu.setStuName("张三");
        int stu_id=studentService.insertAndGetId(stu);
        scheduleService.addCourse(stu_id,"高数","教室","2019上半学年",1,1,1,1);
    }

    @Test
    @Rollback
    public void testShowCourseDetail(){
        course c=courseservice.findCourseById(1);
        System.out.println(JsonUtil.toJson(c));

    }

    @Test
    @Rollback
    public void testBulletComments(){
        //添加弹幕
//        for (int i=0;i<6;i++){
//            bullet_comments bc=new bullet_comments();
//            bc.setStudentId(1);
//            bc.setMajorId(1);
//            bc.setAcademicYear("2019上半学期");
//            bc.setWeekOfSemester((byte) (i%2+1));
//            bc.setContent("课真多-"+i);
//            bulletCommentsService.addBulletComments(bc);
//        }

        //显示一周弹幕
        List list=bulletCommentsService.showWeekComments(3,"2019上半学期",1);
        if(!list.isEmpty()){
            for (int i=0;i<list.size();i++){
                System.out.println(list.get(i));
            }
        }
    }

    @Test
    @Rollback
    public void testMemo(){
        //添加备忘录
       // memoservice.addMemo(1,1,"别迟到");

        /*
        显示一周备忘录
        先找到该学生一周课程的id
        在通过id查找备忘录表
         */
       // List idList=courseservice.findCourseIdInWeek(1,"2019年上学期",1);
//        List<course> courses=stuCourseService.findCoursesOfWeek(1,"2019年上半学期", (byte) 1);
//        System.out.println("courses---"+courses);
//        if(courses!=null){
//            for (int i=0;i<courses.size();i++){
//                System.out.println(courses.get(i));
//            }
//        }
//
//        List<memo> memos=memoservice.showMemoInWeek(1,courses);
//        if(memos!=null){
//            for (int i=0;i<memos.size();i++){
//                System.out.println(memos.get(i));
//            }
//        }

        /*
        修改备忘录
         */
//        int n=memoservice.editMemo(1,"认真听课");
//        System.out.println(n);

        /*
        删除备忘录
         */
        int n=memoservice.deleteMemo(1);
        System.out.println(n);

    }

    @Test
    @Rollback
    public void testAddCourse(){
        course c=new course();
        c.setCourseName("日本概况");
        c.setClassroom("5号楼101");
        c.setDayOfWeek((byte) 2);
        c.setCourseYear("2019年上学期");
        c.setWeekOfSemester((byte) 1);
        c.setLessonOfDay((byte) 1);
        int courseId=courseservice.addCourse(c);
       // boolean m=stuCourseService.addStuCourse(2,courseId);
      //  System.out.println("m--"+m);

    }

    @Test
    @Rollback
    public void testNotification(){
        //添加通知
//        notification n=new notification();
//        n.setNotiDate(new Date(System.currentTimeMillis()));
//        n.setNotiSummarized("通知概要2");
//        n.setNotiContent("通知内容2");
//        n.setNotiTitle("标题2");
//        noticesService.addNotices(n);

       // 查询通知列表
     //   List<noticesDto> list=noticesService.findNoticesByStuId(1);

        //查询收藏通知
//        List<noticesDto> list2=noticesService.findCollectionsByStuId(4);
//        if (list2!=null){
//            for (int i=0;i<list2.size();i++){
//                System.out.println(list2.get(i).getNotiTitle());
//            }
//        }

        //通知详情
        //notification n=noticesService.noticesDetail(1,2);
       noticesService.getViewRecently(1,0,2);
//        System.out.println(n);
      //  stuNotificationService.addItem(5,5);
    }

    @Test
    public void editSignature(){
        studentService.updateSignature(1,"  ");
    }

    @Test
    public void testVideo(){
        videoSeriesService.watchedRecentlyByStuId(1);
    }

    @Test
    @Rollback
    public void testAttendanceRecord(){
        Map map=clockInService.getAttendanceRecord(1,"2019年上半学期");
        String result=JsonUtil.toJson(map);
        System.out.println(result);

    }

    @Test
    @Rollback
    public void testDownloadFile(){
       // DownloadFile.download();
    }

    @Test
    @Rollback
    public void testCourseList(){
       // stuCourseService.findCoursesList(1);
        List<teachInfoDto> result=teacherservice.getTeachersInfo(1);
        for (int i=0;i<result.size();i++){
            System.out.println("test1::"+result.get(i).getTeacherName());
            System.out.println("test1::"+result.get(i).getCoursesName());
            System.out.println("test1::"+result.get(i).isLike());
        }
    }

    @Test
    @Rollback
    public void testElective(){
        List<electiveResultDto> result1=electiveservice.findElectiveByType(2,"人文");
      //  List result2=electiveservice.findCollectionsByStuId(2);
        System.out.println(JsonUtil.toJson(result1));

    }

    @Test
    @Rollback
    public void searchForScore(){
//        for (int i=3;i<8;i++){
//            float result=scoreservice.getGPAByTerm(i,"2019年上半学期");
//            System.out.println("学生id----"+i+"      绩点---"+result);
//        }
//        List result2=scoreservice.getScoresByTerm(1,"2019年上半学期");
//
//        System.out.println(JsonUtil.toJson(result2));


//        float result2=scoreservice.getGPAByTerm(4,"2019年上半学期");
//      //  System.out.println(result2);
//
//        int rank=scoreservice.getRankInMajor(4,"2019年上半学期");
//        System.out.println(rank);

        float averageGPA=scoreservice.getAverageGPA(1);
        float semesterGPA=scoreservice.getGPAByTerm(1,"2019年上半学期");
        int rank=scoreservice.getRankInMajor(1,"2019年上半学期");
        List courseScore=scoreservice.getScoresByTerm(1,"2019年上半学期");
        Map map=new HashMap();
        map.put("averageGPA",averageGPA);
        map.put("semesterGPA",semesterGPA);
        map.put("rank",rank);
        map.put("courseScore",courseScore);
        System.out.println(JsonUtil.toJson(map));

    }

    @Test
    @Rollback
    public void testExam(){
        List<examResultDto> list=examinationservice.getExams(1);
        System.out.println(JsonUtil.toJson(list));
    }

    @Test
    public void testSentence(){
        System.out.println(JsonUtil.toJson(sentenceservice.getSentence()));
    }

    @Test
    public void testCourse(){
        List list=stuCourseService.findCourseOfSemester(1,"2019年上半学期");
        System.out.println(JsonUtil.toJson(list));

    }

    @Test
    public void testMatch(){
        matchservice.getMatchByType(1,2,3);
        int n=matchservice.getCount(1);
        System.out.println(n);
    }

    @Test
    public void testEvaluate(){
        System.out.println(teacherservice.evaluteTeacher(2,3, (float) 4.0));
        System.out.println(teacherservice.getEvaluateById(3));
    }

    @Test
    @Rollback(true)
    public void testAddExam(){
        //标记到课表
        int result=examinationservice.addToSchedule(1,2,2);

        //取消标记
       // examinationservice.cancelAddToSchedule(2,46);
        System.out.println(result);
    }



}


















