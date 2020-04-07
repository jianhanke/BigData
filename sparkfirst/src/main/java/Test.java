import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.hadoop.util.hash.Hash;
import scala.Int;

import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        int[]  array = new int[] {7,1,3,10,5,2,8,9,6};
        System.out.println(Arrays.toString(array));
        test01(array);
        System.out.println(Arrays.toString(array));
        System.out.println(args[11]);

    }

    static public void test01(int[] array){
        array[0]=100;
        array[1]=200;
    }




}
