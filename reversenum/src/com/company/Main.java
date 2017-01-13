package com.company;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
import java.util.jar.Pack200;

public class Main {

//    public static void main(String[] args) {

	// write your code here
            /*int num =0;
            int reversenum =0;
            System.out.println("Please enter your number: ");
            Scanner in= new Scanner(System.in);
            num=in.nextInt();
        while(num!=0){
            reversenum=reversenum*10;
            reversenum=reversenum+num%10;
            num/=10;
        }
        System.out.println("Your reversed number is: ");
        System.out.println("***********");
        System.out.println(reversenum);

        int num1,num, num2, count=0,x, random;
        Scanner in= new Scanner(System.in);
        System.out.println("Enter multiplier: ");
        num1= in.nextInt();
        System.out.println("Enter starting number: ");
        num= in.nextInt();
        System.out.println("Enter the amount of products wanted: ");
        num2= in.nextInt();
        random= num+num2;

        for(x=num;x <= random;x++) {
         System.out.println("The multiplication table of: "+x);

            for (count = 0; count <= num1; count++) {
                System.out.println(x + "*" + count + " = " + (x * count));
            }
        }


        int even=0,odd=0,num,numb, count;
        int[] testarr=new int[20];
        Scanner in= new Scanner(System.in);
        System.out.println("Enter beginning number: ");
        num=in.nextInt();
        System.out.println("Enter ending number: ");
        numb= in.nextInt();
        count=num;
        int x=0;
        while(count<=numb) {
            testarr[x]=count;
            if ((count % 2) == 0) {
                even++;
            } else {
                odd++;
            }
            count++;
            x++;
        }
        x=0;
        System.out.println("There are " +even+ " even numbers between " +num+ " and " +numb);
        System.out.print("These numbers are: ");
        for(count=0; count<=numb;count++){
                if((testarr[count]%2)==0) {
                    System.out.print(testarr[count]);
                    System.out.print(", ");
                }

            }

        System.out.println("There are " +odd+ " odd numbers between " +num+ " and " +numb);
        System.out.print("These numbers are: ");
        for(count=0; count<=numb;count++){
            if((testarr[count]%2)!=0) {
                System.out.print(testarr[count]);
                System.out.print(", ");
            }
        }
int test=Arrays.binarySearch(testarr, 3);
    System.out.println("3 is found at index " +test);
        printarr("In this array:", testarr);
    }
    private static void printarr(String Random, int arr[]) {
        System.out.println(Random + ": [Length: " + arr.length + "]");
        }
        */
    public static void main(String args[]) throws Exception{
        int array[]={2,-5,-2,6,-3,8,0,-7,-9,4};
        Arrays.sort(array);
        printArray("Sorted Array", array);
        int index=Arrays.binarySearch(array,1);
        System.out.println("Didn't find 1 @ " + index);
        int newIndex= -index - 1;
        array=insertElement(array,1, newIndex);
        printArray("With 1 added ", array);
        }
    private static void printArray(String message, int array[]){
        System.out.println(message + ":[length: "+array.length + "]");
        for(int i=0; i<array.length;i++) {
            if(i!=0){
                System.out.print(", ");
            }
                System.out.print(array[i]);
        }
       System.out.println();
    }
    private  static int[] insertElement(int original[], int element, int index){
        int length=original.length;
        int destination[]=new int[length+1];
        System.arraycopy(original,0,destination,0,index);
        destination[index]=element;
        System.arraycopy(original,index,destination,index+1,length-index);
        return destination;
    }

    }





