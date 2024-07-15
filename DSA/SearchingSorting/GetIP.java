package CompetitiveProgramming.SearchingSorting;

import java.util.ArrayList;
import java.util.List;

public class GetIP {
    static boolean isValid(String token){
        if(token.charAt(0)=='0'){
            if(token.length()==1){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            int intToken = Integer.parseInt(token);

            if(token.length()<=2){
                return true;
            }
            else if(token.length()==3 && intToken<=255){
                return true;
            }
        }
        return false;
    }

    static void partition(String input,List<String> tokens,List<String> output){
        //base case
        if(tokens.size()==4){
            if(input.length()==0){
                //print the IP
                StringBuilder stringBuilder = new StringBuilder(100);
                for(int i=0;i<tokens.size();i++){
                    if(i==tokens.size()-1){
                        stringBuilder.append(tokens.get(i));
                    }
                    else{
                        stringBuilder.append(tokens.get(i) + ".");
                    }
                }
                output.add(stringBuilder.toString());
            }
            return;
        }

        //rec case
        for(int i=1;i<=3 && i<=input.length();i++){
            String token = input.substring(0,i);
            if(isValid(token)){
                tokens.add(token);
                partition(input.substring(i,input.length()),tokens,output);
                tokens.remove(tokens.size()-1);
            }
        }

    }
    public static void main(String[] args) {
        String input = "1132135";
        List<String> tokens = new ArrayList<>();
        List<String> output = new ArrayList<>();
        partition(input,tokens,output);
        System.out.println(output);
    }
}
