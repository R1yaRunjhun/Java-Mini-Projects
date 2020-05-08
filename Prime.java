import java.math.*;
public class Prime {
   
    public static void main(String args[]) 
    {
    
    for(int i=10;i<=99;i++)
    {
        boolean flag= true;
        for(int j=2;j<=Math.sqrt(i);j++){
            if(i%j==0)
            {
                flag= false;
                break;
            }
        }
        if(flag == true){ 
            System.out.println(i);
        }
       
    }
}

}