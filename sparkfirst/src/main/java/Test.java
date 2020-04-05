import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.hadoop.util.hash.Hash;
import scala.Int;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<String>();
        list.add("fsad");
        System.out.println(list);

        HashMap<String,String> map=new HashMap<String,String>();
        map.put("haha","31231");
        map.put("hanke","312312");
        map.put("haha88","321312312");
        System.out.println(map);
        System.out.println(map.hashCode());
        System.out.println("haha".hashCode());
        System.out.println(map);

        System.out.println("2^3运算的结果是 :"+(2^3));
        System.out.println("2<<3运算的结果是 :"+(2<<3));
        System.out.println("16>>>2运算的结果是 :"+((16)>>> 2));
        System.out.println("16>>>2运算的结果是 :"+((16)>> 2));

        while( (2>1) || (2<1) ){
            System.out.println("进来了");
        }
    }




}
