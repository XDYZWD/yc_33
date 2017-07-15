package favorite;

import java.util.List;

import com.yc.bean.Favorite;
import com.yc.bean.Tag;
import com.yc.biz.FavoriteBiz;
import com.yc.biz.Impl.FavoriteBizImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FavoriteBizTest extends TestCase {
	/**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public FavoriteBizTest( String testName )//TestCase测试用例：可以有多个测试的方法
    {
        super( testName );
    }

	/**
     * @return the suite of tests being tested
     */
    public static Test suite()  //测试套件
    {
        return new TestSuite( FavoriteBizTest.class );
    }
    public void testAddFavorite(){
    	Favorite f=new Favorite();
    	f.setFdesc("good");
    	f.setFlabel("google");
    	f.setFtags("门户,军事,娱乐,搜搜");
    	f.setFurl("http://www.google.com");
    	FavoriteBiz fd=new FavoriteBizImpl();
    	fd.addFavrite(f);
    }
    public void testFindAllTag(){
    	FavoriteBiz fd=new FavoriteBizImpl();
    	List<Tag> list=fd.findAllTag();
    	for(Tag t:list){
    		System.out.println(t);
    	}
    }
    public void testFindFavorite1(){
    	FavoriteBiz fd=new FavoriteBizImpl();
    	List<Favorite> list=fd.findFavorite("全部");
    	for(Favorite f:list){
    		System.out.println(f);
    	}
    }
    public void testFindFavorite2(){
    	FavoriteBiz fd=new FavoriteBizImpl();
    	List<Favorite> list=fd.findFavorite("未分类");
    	for(Favorite f:list){
    		System.out.println(f);
    	}
    }
    public void testFindFavorite3(){
    	FavoriteBiz fd=new FavoriteBizImpl();
    	List<Favorite> list=fd.findFavorite("军事");
    	for(Favorite f:list){
    		System.out.println(f);
    	}
    }
}
