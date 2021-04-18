import java.util.ArrayList;

public class BigInt {
    static int [] saveNumber(String num){
        int index=num.length()-1;
        int [] number;
        //System.out.println(index);
        if(num.length()%3>0) {
             number=new int[num.length()/3+1];
        }else {
             number=new int[num.length()/3];
        }

        System.out.println(number.length);
        System.out.println(num.length()%3);
        int c=num.length()%3;
        switch (c) {
            case 0:
                for(int i=number.length-1;i>=0;i--) {
                    String tmp = "";
                    for (int j = index - 2; j <= index; j++) {
                        tmp += num.charAt(j);
                        System.out.println(tmp);
                    }
                    number[i] = Integer.valueOf(tmp);
                    index-=3;
                }
                break;

            case 1:
                for(int i=number.length-1;i>0;i--) {
                    String tmp = "";
                    for (int j = index - 2; j <= index; j++) {
                        tmp += num.charAt(j);
                        System.out.println(tmp);
                    }
                    number[i] = Integer.valueOf(tmp);
                    index-=3;
                }
                String tmp="";
                tmp+=num.charAt(0);
                number[0]=Integer.valueOf(tmp);
                break;

            case 2:
                for(int i=number.length-1;i>0;i--) {
                    String tmp1 = "";
                    for (int j = index - 2; j <= index; j++) {
                        tmp1 += num.charAt(j);
                        System.out.println(tmp1);
                    }
                    number[i] = Integer.valueOf(tmp1);
                    index-=3;
                }
                String tmp1="";
                tmp1+=num.charAt(0);
                tmp1+=num.charAt(1);
                number[0]=Integer.valueOf(tmp1);
                break;
        }

        return number;

        }


    static int[] plus(ArrayList<int []> data ){
        int max=0;
        for(int i=0;i<data.size();i++){
            if(data.get(i).length>max) {
                max = data.get(i).length;
            }
        }

        int [] result=new int[max+1];
        int sum=0;
        if(data.get(0).length-1>=data.get(1).length-1) {

            for (int i=result.length-1,j=data.get(0).length-1,z=data.get(1).length-1;j>=0;i--,j--,z--){
                if(j>=0 && z>=0){
                    sum+=data.get(0)[j];
                    sum+=data.get(1)[z];
                }
                else if (z<0)
                    sum+=data.get(0)[j];
                if (sum/1000>0 && j!=0){
                    result[i]=sum%1000;
                    data.get(0)[j-1]+=sum/1000;
                    sum=0;
                }else{
                    result[i]=sum;
                    sum=0;
                }
        }
        }else{
            for (int i=result.length-1,j=data.get(0).length-1,z=data.get(1).length-1;z>=0;i--,j--,z--){
                if(j>=0 && z>=0){
                    sum+=data.get(0)[j];
                    sum+=data.get(1)[z];
                }
                else if (j<0)
                    sum+=data.get(1)[z];
                if (sum/1000>0 && j!=0){
                    result[i]=sum%1000;
                    data.get(1)[z-1]+=sum/1000;
                    sum=0;
                }else{
                    result[i]=sum;
                    sum=0;
                }
            }
        }

        return result;

    }

    static int[] minus(ArrayList<int []> data){
        int max=0;
        for(int i=0;i<data.size();i++){
            if(data.get(i).length>max) {
                max = data.get(i).length;
            }
        }

        int [] result=new int[max];
        int sub=0;
        if(data.get(0).length-1>data.get(1).length-1) {

            for (int i=result.length-1,j=data.get(0).length-1,z=data.get(1).length-1;j>=0;i--,j--,z--){
                if(j>=0 && z>=0){
                    if(data.get(0)[j]>=data.get(1)[z]){
                        sub+=data.get(0)[j]-data.get(1)[z];
                    }else{
                            sub+=data.get(0)[j]+1000-data.get(1)[z];
                            data.get(0)[j-1]-=1;
                    }

                } else if (z<0)
                    sub+=data.get(0)[j];



                    result[i]=sub;
                    sub=0;
            }
        }else if(data.get(0).length-1==data.get(1).length-1){
            for (int i=result.length-1,j=data.get(0).length-1,z=data.get(1).length-1;z>=0;i--,j--,z--){
                    if(data.get(0)[j]>=data.get(1)[z]){
                        sub+=data.get(0)[j]-data.get(1)[z];
                    }else{
                        if (j!=0) {
                            sub += (data.get(0)[j] + 1000) - data.get(1)[z];
                            data.get(0)[j - 1] -= 1;
                        }else{
                            sub+=data.get(0)[j]-data.get(1)[z];
                        }
                    }

                    result[i]=sub;
                    sub=0;

            }
        }else{
            for (int i=result.length-1,j=data.get(0).length-1,z=data.get(1).length-1;z>=0;i--,j--,z--){
                if(j>=0 && z>=0){
                    if(data.get(1)[z]>=data.get(0)[j]){
                        sub+=data.get(1)[z]-data.get(0)[j];
                    }else{
                        sub+=(data.get(1)[z]+1000)-data.get(0)[j];
                        data.get(1)[z-1]-=1;
                    }
                }
                else if (j<0)
                    sub+=data.get(1)[z];


                result[i]=sub;
                sub=0;
            }
            if (result[0]!=0)
            result[0]*=-1;
            else
                result[1]*=-1;
        }

        return result;
    }

    static int[] multiply(ArrayList<int []> data){

//        int [] result=new int[data.get(0).length+data.get(1).length];
        ArrayList<int []> innertmpResult=new ArrayList<>();
        ArrayList<int []> outertmpResult=new ArrayList<>();
        ArrayList<int []> parttmpResult=new ArrayList<>();
        int mult;

        if(data.get(0).length-1>=data.get(1).length-1) {

            for (int z=data.get(1).length-1;z>=0;z--){
                for (int j=data.get(0).length-1;j>=0;j--){
                        String multString= "";
                        mult=data.get(0)[j] * data.get(1)[z];
                        multString=String.valueOf(mult);
                        for (int x=j,y=z;x<data.get(0).length-1 && y<data.get(1).length-1;x++,y++){
                            //Concating "000" with the result because of the order
                            multString+="000";
                        }
                        System.out.println("This is multstriing"+multString);
                        innertmpResult.add(saveNumber(multString));
                        System.out.println("This is innerresult"+innertmpResult.get(0)[0]);

                }
                // add the multiply result of that part which is saved in innertmpResult together
                outertmpResult.add(innertmpResult.get(0));
                System.out.println("This is outerresult"+outertmpResult.get(0)[0]);
                outertmpResult.add(innertmpResult.get(1));
                if (innertmpResult.size()>=3) {
                    for (int x = 2; x < innertmpResult.size(); x++) {

                        outertmpResult.set(0, plus(outertmpResult));
                        System.out.println("This is result" + outertmpResult.get(0)[0]);
                        outertmpResult.set(1, innertmpResult.get(x));
                    }
                }else{
                        outertmpResult.set(0, plus(outertmpResult));
                        System.out.println("This is result" + outertmpResult.get(0)[0]);
                    }

                parttmpResult.add(outertmpResult.get(0));

            }
            // add the multiply result of that part which is saved in innertmpResult together
            if (parttmpResult.size()>=2) {
                outertmpResult.add(parttmpResult.get(0));
                outertmpResult.add(parttmpResult.get(1));
                if (parttmpResult.size() >= 3) {
                    for (int x = 2; x < parttmpResult.size(); x++) {

                        outertmpResult.set(0, plus(outertmpResult));
                        System.out.println("This is result" + outertmpResult.get(0)[0]);
                        outertmpResult.set(1, parttmpResult.get(x));
                    }
                }else {
                        outertmpResult.set(0, plus(outertmpResult));
                        System.out.println("This is result" + outertmpResult.get(0)[0]);
                    }

            }else
                outertmpResult.add(parttmpResult.get(0));

        }else{
            for (int z=data.get(0).length-1;z>=0;z--){
                for (int j=data.get(1).length-1;j>=0;j--){
                    String multString= "";
                    mult=data.get(0)[j] * data.get(1)[z];
                    multString=String.valueOf(mult);
                    for (int x=j,y=z;x<data.get(0).length-1 && y<data.get(1).length-1;x++,y++){
                        //Concating "000" with the result because of the order
                        multString+="000";
                    }
                    System.out.println("This is multstriing"+multString);
                    innertmpResult.add(saveNumber(multString));
                }
                // add the multiply result of that part which is saved in innertmpResult together
                outertmpResult.add(innertmpResult.get(0));
                outertmpResult.add(innertmpResult.get(1));
                if (innertmpResult.size()>=3) {
                    for (int x = 2; x < innertmpResult.size(); x++) {

                        outertmpResult.set(0, plus(outertmpResult));
                        System.out.println("This is result" + outertmpResult.get(0)[0]);
                        outertmpResult.set(1, innertmpResult.get(x));
                    }
                }
                else{
                        outertmpResult.set(0, plus(outertmpResult));
                        System.out.println("This is result" + outertmpResult.get(0)[0]);
                    }

                parttmpResult.add(outertmpResult.get(0));

            }
            // add the multiply result of that part which is saved in innertmpResult together
            if (parttmpResult.size()>=2) {
                outertmpResult.add(parttmpResult.get(0));
                outertmpResult.add(parttmpResult.get(1));
                if (parttmpResult.size() >= 3) {
                    for (int x = 2; x < parttmpResult.size(); x++) {

                        outertmpResult.set(0, plus(outertmpResult));
                        outertmpResult.set(1, parttmpResult.get(x));
                    }
                }else
                        outertmpResult.set(0, plus(outertmpResult));

            }else
                outertmpResult.add(parttmpResult.get(0));
        }

        return outertmpResult.get(0);
    }


    public static void main(String[] args){
        String str="1234";
        String str1="123";
        ArrayList<int []> data=new ArrayList<>();
         data.add(saveNumber(str));
         data.add(saveNumber(str1));
         int []res=plus(data);
         for (int i=0;i<res.length;i++)
             if (res[i]!=0)
             System.out.print(res[i]);

             System.out.println();
        int []res1=minus(data);
        for (int i=0;i<res1.length;i++)
            if (res1[i]!=0)
                System.out.print(res1[i]);

        System.out.println();
        int []res2=multiply(data);
        for (int i=0;i<res2.length;i++)
            if (res2[i]!=0)
                System.out.print(res2[i]);



    }


}



