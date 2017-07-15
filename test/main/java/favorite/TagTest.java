package favorite;

import java.util.List;

import com.yc.bean.Favorite;
import com.yc.bean.Tag;
import com.yc.dao.TagDao;
import com.yc.dao.impl.TagDaoImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TagTest extends TestCase {
	/**
	 * Create the test case
     *
     * @param testName name of the test case
     */
    public TagTest( String testName )//TestCase测试用例：可以有多个测试的方法
    {
        super( testName );
    }

	/**
     * @return the suite of tests being tested
     */
    public static Test suite()  //测试套件
    {
        return new TestSuite( TagTest.class );
    }
    
    public void testAddTag(){
    	Tag t=new Tag();
    	t.setTname("军事");
    	TagDao td=new TagDaoImpl();
    	td.addTag(t);
    }
   public void testIncreaseCount(){
    	Tag t=new Tag();
    	t.setTname("军事");
    	TagDao td=new TagDaoImpl();
    	td.increassCount(t);
    }
    public void testSelectTagAll(){
    	TagDao td=new TagDaoImpl();
    	List<Tag> list=td.selectTagAll();
    	System.out.println(list);
    }
    public void testSelectFavoriteByName(){
    	Tag t=new Tag();
    	t.setTname("12");
    	TagDao td=new TagDaoImpl();
    	List<Favorite> list=td.selectFavoriteByTname(t);
    	System.out.println(list);
    }
    public void testSelectTagByName(){
    	Tag t=new Tag();
    	t.setTname("军事");
    	TagDao td=new TagDaoImpl();
    	Tag tag=td.selectTagByName(t);
    	System.out.println(tag);
    }
}
