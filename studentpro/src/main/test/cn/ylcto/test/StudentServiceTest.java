package cn.ylcto.test;

import cn.ylcto.student.service.IStudentService;
import cn.ylcto.student.vo.Classes;
import cn.ylcto.student.vo.Student;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class StudentServiceTest {
    private static ApplicationContext ctx ;
    private static IStudentService studentService;

    static {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        studentService = ctx.getBean("studentServiceImpl",IStudentService.class);
    }
    @Test
    public void insert()throws Exception{
        Student vo = new Student();
        vo.setSid("YLCTO832");
        vo.setName("张三");
        vo.setAge(23);
        vo.setSex(1); //1表示男  0表示女
        vo.setAddress("XXXX路XXXX号");
        Classes classes = new Classes();
        classes.setCid(1);
        vo.setClasses(classes);
        TestCase.assertTrue(this.studentService.insert(vo));
    }

    @Test
    public void list() throws Exception {
        Map<String, Object> map = this.studentService.listSplit(1,2);
        System.out.println(map.get("allStudent"));
        System.out.println(map.get("studentCount"));
        TestCase.assertTrue(map.size() == 2);
    }

    @Test
    public void update() throws Exception{
        Student vo = new Student();
        vo.setName("王五");
        vo.setAge(20);
        vo.setSex(1);
        vo.setAddress("联系地址");
        vo.setSid("YLCTO832");
        Classes classes = new Classes();
        classes.setCid(5);
        vo.setClasses(classes);
        TestCase.assertTrue(this.studentService.update(vo));
    }

    @Test
    public void delete() throws Exception {
        List<String> all = new ArrayList<>();
        all.add("YLCTO95653");
        TestCase.assertTrue(this.studentService.delete(all));
    }

}
