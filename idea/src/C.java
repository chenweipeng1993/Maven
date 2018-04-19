public class C {
    public static void main(String[] args){
        StringBuilder str = new StringBuilder("aaa");
        StringBuilder str2 = str.append("bbb");
        System.out.println(str2);
        StringBuilder str3 = str.append("ccc");
        System.out.println(str3);
    }
}
