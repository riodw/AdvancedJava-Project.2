
package project2;
/**
 * date 9-6-2015
 * @author Rio Weber
 */
public class Project2
{
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        //- STEP 1
        // create an empty array list with an initial capacity
        System.out.println("Rio Weber \nProject2\n--------\n" 
              + "Creating an empty array list with an initial capacity");
        MyArrayList ar = new MyArrayList(20);

        //- STEP 2
        System.out.println("Adding 0, 15, 22, 30, 40 and 42 to String 1\n");
        ar.add(0); // use add() method to add elements in the list
        ar.add(15);
        ar.add(22);
        ar.add(30);
        ar.add(40);
        ar.add(42);
        System.out.println(ar.toString());
        
        //- STEP 3
        System.out.println("\nString 1, adding 25 to position 2");
        // adding element 25 at third position
        ar.add(2,25);
        System.out.println(ar.toString());
        
        //- STEP 5
        System.out.println("\nString 1, searching if string contains 22");
        // searching for 22
        System.out.println(ar.contains(22));
        
        //- STEP 6
        System.out.println("\nString 1, get location of element 2");
        // get location of element 2
        System.out.println(ar.get(2));
        
        //- STEP 7
 System.out.println("\nString 1, searching for first instance of element 100");
        // searching for first instance of element 100
        System.out.println(ar.indexOf(100));
        
        //- STEP 9
        System.out.println("\n" + ar.toString());
        System.out.println("String 1, removing element at position 3");
        // removing element at postion 3
        ar.remove(3);
        System.out.println(ar.toString());
        
        //- STEP 10
        System.out.println("\nString 1, removing element 0");
        // removing element 0
        ar.remove(0);
        System.out.println(ar.toString());
        
        //- STEP 11
        System.out.println("\nString 1, setting element at positon 5 to 5");
        // setting element at positon 5 to 5
        ar.set(4, 5);
        System.out.println(ar.toString());
        
        //- STEP 12
        System.out.println("\nString 1, getting the size of the array");
        // getting the size of the array
        System.out.println(ar.size());
        
        //- STEP 13
 System.out.println("\nString 1, a view of a portion of the list from 2 to 4");
        // searching for first instance of element 100
        System.out.println(ar.subList(2, 4));
        
        
        // CLEARING STRING ================
        //-STEP 4
        System.out.println("\nString 1, clearing string");
        // clearing the String
        ar.clear();
        System.out.println(ar.toString());
        
        //- STEP 8
        System.out.println("\nString 1, testing if string is empty");
        // testing if string is empty
        System.out.println(ar.isEmpty());
    }
}
