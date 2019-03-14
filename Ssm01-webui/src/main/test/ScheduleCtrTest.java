import com.IMBA.service.BackgroundService;
import com.IMBA.service.memoService;
import com.IMBA.service.stu_courseService;
import com.IMBA.utils.DownloadFile;
import controller.ScheduleController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.*;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
@ContextConfiguration(locations = { "classpath:applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@Rollback
public class ScheduleCtrTest {

    protected MockMvc mockMvc;

    @InjectMocks
    ScheduleController scheduleController;

    @Mock
    memoService memoservice;

    @Mock
    BackgroundService backgroundService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Mock
    stu_courseService stuCourseService;

    @Autowired
    stu_courseService stuCourseService2;



    @Before
    public void setUp(){
        MockitoAnnotations.initMocks(this);
        this.mockMvc=MockMvcBuilders.standaloneSetup(scheduleController).build();
    }

    @Test
    public void test() throws Exception {
        Mockito.when(memoservice.addMemo(1,1,"上课别迟到")).thenReturn(123);

        RequestBuilder rb=get("/schedule/addMemo")
                .param("stuId","1")
                .param("courseId","1")
                .param("content","上课别迟到")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED);
        String data=mockMvc.perform(rb).andReturn().getResponse().getContentAsString();
        System.out.println("data"+data);

    }

    @Test
    public void BgImgTest() throws Exception {
        File file=new File("F:/图片资源/haha.jpg");
        MockMultipartFile  mulFile = new MockMultipartFile(
                "file",                                        //文件名
                "haha.jpg",                           //originalName 相当于上传文件在客户机上的文件名
                "image/jpeg" ,                           //文件类型
                new FileInputStream(file)                           //文件流
        );
        RequestBuilder rb= MockMvcRequestBuilders.fileUpload("/schedule/uploadBgImg")
                .file(mulFile)
                .param("stuId","1");
        String data=mockMvc.perform(rb).andReturn().getResponse().getContentAsString();
        System.out.println("multipartFileile"+mulFile);
        System.out.println("data"+data);
    }

    @Test
    public void testQRCode() throws Exception {
        List list=stuCourseService2.findCourseOfSemester(1,"2019年上半学期");
        Mockito.when(stuCourseService.findCourseOfSemester(1,"2019年上半学期")).thenReturn(list);
        RequestBuilder rb=get("/schedule/qrcode")
                .param("stuId","1")
                .param("year","2019年上半学期")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED);
        MockHttpServletResponse response=mockMvc.perform(rb).andReturn().getResponse();
       // System.out.println("data"+);
        File file=new File("D:/test.png");
        file.createNewFile();
        FileOutputStream fileOutputStream=new FileOutputStream(file);
        byte[] bytes=response.getContentAsByteArray();
        for (int i=0;i<bytes.length;i++){
            fileOutputStream.write(bytes[i]);
        }

    }

    @Test
    @Rollback
    public void testDonwloadFile() throws IOException {
        File file=new File("D:/test.txt");
        OutputStream outputStream=new FileOutputStream(file);
        String path="F:\\作业\\项目\\服创-小程序项目\\fuchuang\\IMBA\\Ssm01-webui\\target\\test-classes\\upload\\test.txt";
        DownloadFile.download(outputStream,path);
    }

    @Test
    @Rollback
    public void restRedis(){
        redisTemplate.opsForValue().set("test", "测试");
        System.out.println("value："+redisTemplate.opsForValue().get("test"));
    }


}
