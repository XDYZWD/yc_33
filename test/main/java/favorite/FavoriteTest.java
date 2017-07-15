package favorite;

import java.util.List;

import com.yc.bean.Favorite;
import com.yc.dao.FavoriteDao;
import com.yc.dao.impl.FavoriteDaoImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FavoriteTest extends TestCase {
	
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FavoriteTest( String testName )//TestCase测试用例：可以有多个测试的方法
    {
        super( testName );
    }

	/**
     * @return the suite of tests being tested
     */
    public static Test suite()  //测试套件
    {
        return new TestSuite( FavoriteTest.class );
    }
    public void testAddFavorite(){
    	Favorite f=new Favorite();
    	f.setFdesc("");
    	f.setFlabel("baidu");
    	f.setFurl("http://www.baidu.com");
    	f.setFtags("门户");
    	FavoriteDao fd=new FavoriteDaoImpl();
    	fd.addFavorite(f);
    }
    
    public void testSelectFavoriteAll(){
    	Favorite f=new Favorite();
    	f.setFtags("");
    	FavoriteDao fd=new FavoriteDaoImpl();
    	List<Favorite> list=fd.selectFavoriteAll(f);
    	System.out.println(list);
    }
    

}
