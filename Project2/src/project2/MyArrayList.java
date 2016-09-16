
package project2;
/**
 * date 9-6-2015
 * @author Rio Weber
 */

// MyArrayList Class - (Step 1)
public class MyArrayList
{
    //Used for making an empty instance.
    private static final Object[] NO_DATA = {};
    // non-private to simplify nested class access
    public Object[] elementData;
    // The size of the ArrayList (the number of elements it contains).
    private int size;

    /**
     * Constructs an empty list with the specified initial capacity.
     * @param  initialCapacity  the initial capacity of the list
     * @throws IllegalArgumentException if the capacity is negative
     */
    public MyArrayList(int initialCapacity)
    {
        if (initialCapacity > 0)
        {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0)
        {
            this.elementData = NO_DATA;
        } else
        {
            throw new IllegalArgumentException("Illegal Capacity: "
                    + initialCapacity);
        }
    }

    //-- Constructs an empty list with an initial capacity of ten.
    public MyArrayList()
    {
        this.elementData = NO_DATA;
    }
    
    // ADD - (Step 2)
    //-- Appends the specified element to the end of this list.
    /**
     * @param e element to be appended to this list
     */
    public void add(Object e)
    {
        elementData[size++] = e;
    }
    
    // ADD - (Step 3)
    //-- Inserts the specified element at the specified element at the
    //         specified position in this list.
    /**
     * @param index index at which the specified element is to be inserted
     * @param element element to be inserted
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public void add(int index, Object element)
    {
        //rangeCheckForAdd(index);
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));

        //ensureCapacityInternal(size + 1);  // Increments modCount!!
        System.arraycopy(elementData, index, elementData, index + 1,
                         size - index);
        elementData[index] = element;
        size++;
    }
    
    // CLEAR - (Step 4)
    //-- Removes all of the elements from this list.
    public void clear()
    {
        for (int i = 0; i < size; i++)
            elementData[i] = null;

        size = 0;
    }
    
    // CONTAINS - (Step 5)
    //-- Returns true if this list contains the specified element.
    /**
     * @param o element whose presence in this list is to be tested
     * @return true if this list contains the specified element
     */
    public boolean contains(Object o)
    {
        return indexOf(o) >= 0;
    }
    
    // GET - (Step 6)
    //-- Returns the element at the specified position in this list.
    /**
     * @param  index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException when the index is not in the array
     */
    public Object get(int index)
    {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        return (Object) elementData[index];
    }
    
    // INDEXOF - (Step 7)
    //-- Returns the index of the first occurrence of the specified element in
    //      this list, of -1 if this list does not contain the element.
    /**
     * @param o Object parameter for indexOf
     * @return -1 or the location of the Object
     */
    public int indexOf(Object o)
    {
        if (o == null) {
            for (int i = 0; i < size; i++)
                if (elementData[i]==null)
                    return i;
        } else {
            for (int i = 0; i < size; i++)
                if (o.equals(elementData[i]))
                    return i;
        }
        return -1;
    }
    
    // ISEMPTY - (Step 8)
    //-- Returns true if this list contains nothing
    /**
     * @return true if this list contains no elements
     */
    public boolean isEmpty()
    {
        return size == 0;
    }
    
    // REMOVE - (Step 9)
    //-- Removes the element at the specified position in this list.
    /**
     * @param index the index of the element to be removed
     */
    public void remove(int index)
    {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));

        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elementData, index+1, elementData, index,
                             numMoved);
        elementData[--size] = null;
    }
    
    // REMOVE - (Step 10)
    //-- Removes the first occurrence of the specified element from this list
    //      if it is present. Return false if the object is not in the list.
    /**
     * @param o element to be removed from this list, if present
     * @return true if this list has the element
     */
    public boolean remove(Object o)
    {
        if (o == null)
        {
            for (int index = 0; index < size; index++)
                if (elementData[index] == null)
                {
                    int numMoved = size - index - 1;
                    if (numMoved > 0)
                        System.arraycopy(elementData, index+1, 
                                elementData, index, numMoved);
                    elementData[--size] = null; // clear
                    
                    return true;
                }
        } else {
            for (int index = 0; index < size; index++)
                if (o.equals(elementData[index]))
                {
                    int numMoved = size - index - 1;
                    if (numMoved > 0)
                        System.arraycopy(elementData, index+1, 
                                elementData, index, numMoved);
                    elementData[--size] = null; // clear
                    
                    return true;
                }
        }
        return false;
    }
    
    // SET - (Step 11)
    //-- Replaces the element at the specified position in this list 
    //      with the specified element.
    /**
     * @param index index of the element to replace
     * @param element element
     * @throws IndexOutOfBoundsException when the index is not in the array
     */
    public void set(int index, Object element)
    {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));

        //Setting the element value at passes index
        elementData[index] = element;
    }
    
    // SIZE - (Step 12)
    //-- Returns the number of elements in this list.
    /**
     * @return the number of elements in this list
     */
    public int size()
    {
        return size;
    }
    
    // SUBLIST - (Step 13)
    //-- Returns a view of the portion of this list between the
    //      specified fromIndex, inclusive, and toIndex, exclusive.
    public MyArrayList subList(int fromIndex, int toIndex)
    {
        if (fromIndex > size || fromIndex < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(fromIndex));
        if (toIndex > size || toIndex < 0)
            throw new IndexOutOfBoundsException(outOfBoundsMsg(toIndex));
        
        MyArrayList ar2 = new MyArrayList(size);
        
        for (int i = fromIndex; i <= toIndex; i++)
            ar2.add(elementData[i]);
        
        return ar2;
    }
    
    // TOSTRING - (Step 14)
    //-- Returns a string of the format [data1, data2, ...]
    //      that contains all the data in this list.
    @Override
    public String toString()
    {
        if(this.isEmpty() == true)
            return "";
        
        String st1 = new String();
        for (int i = 0; i < size; i++)
            st1 += elementData[i] + ", ";
        
        return st1;
    }
    
    // OUTOFBOUNDSMSG - Part of (Step: 3, 6, 9, 11, )
    /**
     * OutOfBoundsException for when index is not in array
     */
    private String outOfBoundsMsg(int index)
    {
        return "Index: " + index + ", Size: "+size;
    }
}
