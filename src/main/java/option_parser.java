public class option_parser {
    public static int[] parse(String[] arr){
        int[] res = new int[arr.length];
        for(int i=0;i< arr.length;i++){
            res[i]=Integer.parseInt(arr[i]);
        }
        return res;
    }
}
