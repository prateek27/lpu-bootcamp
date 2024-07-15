package CompetitiveProgramming.SearchingSorting.LadderProblem;

public class GenerateBrackets {

    public static void generate(int N,String currentOutput,int open,int close){
        if(currentOutput.length()==2*N){
            System.out.println(currentOutput);
            return;
        }
        //rec
        //option 1 close
        if(close<open){
            generate(N,currentOutput + ")",open,close+1);
        }
        //option 2 open
        if(open<N){
            generate(N,currentOutput+"(",open+1,close);
        }
    }

    public static void main(String[] args) {
        generate(2,"",0,0);
    }
}
