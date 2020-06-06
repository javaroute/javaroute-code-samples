import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.javaroute.model.Student;
import org.javaroute.model.User;
import org.javaroute.util.SqlSessionFactoryUtils;
import org.junit.Test;

public class StudentTest {
    @Test
    public void testInsert(){
        SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getInstance();
        SqlSession sqlSession=sqlSessionFactory.openSession();
        Student student=new Student();
        student.setName("赵小豪");
        student.setAge(28);
        int rows=sqlSession.insert("org.javaroute.mapper.StudentMapper.insertStudent",student);
        System.out.println("rows = " + rows);
        sqlSession.commit();
    }
}
