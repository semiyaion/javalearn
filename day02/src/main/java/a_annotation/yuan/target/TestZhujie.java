
package a_annotation.yuan.target;


@ZhuJie(Name="麻辣烫")
@A("数据")
@SuppressWarnings("all")
public class TestZhujie {
    @ZhuJie(Name = "河北",Price = 5412)
    int a;

    public static void main(String[] args) {

    }
    @ZhuJie(Name = "江苏")
    public void show(@ZhuJie(Name ="山东")String s){

    }

}
