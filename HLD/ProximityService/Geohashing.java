package Lecture12_HLD.ProximityService;

public class Geohashing {
    private static final int WORLD_SIZE = 5000;
    private static final String BASE32 = "abcdefghijklmnopqrstuvwxyz123456";

    private static String encodeToBase32(String input){
        StringBuilder output = new StringBuilder();
        for(int i=0;i<input.length();i+=5){
            String currentChunk = input.substring(i,Math.min(i+5,input.length()));
            int index = Integer.parseInt(currentChunk,2);
            output.append(BASE32.charAt(index));
        }
        return output.toString();
    }

    static String encode(double lat,double lngt,int precision){
        double startX = 0, endX = WORLD_SIZE;
        double startY = 0, endY = WORLD_SIZE;


        StringBuilder hash = new StringBuilder();
        while(precision>0){
            //single partition
            double midX = (startX + endX)/2;
            if(lat<midX){
                hash.append("0");
                endX = midX;
            }
            else{
                hash.append("1");
                startX = midX;
            }
            double midY = (startY + endY)/2;
            if(lngt<midY){
                hash.append("0");
                endY = midY;
            }
            else{
                hash.append("1");
                startY = midY;
            }
            precision--;
        }
        return encodeToBase32(hash.toString());
    }

    public static void main(String[] args) {
        String geohash1 = encode(1038,1427,10);
        String geohash2 = encode(1048,1434,10);
        System.out.println(geohash1);
        System.out.println(geohash2);
    }
}
