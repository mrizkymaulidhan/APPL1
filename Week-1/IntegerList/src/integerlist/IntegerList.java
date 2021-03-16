package integerlist;

// ****************************************************************
// IntegerList.java
//
// Define an IntegerList class with methods to create & fill
// a list of integers.
//          
// ****************************************************************

import java.util.Scanner;

public class IntegerList
{
    int[] list; // values in the list

    // -------------------------------------------------------
    // create a list of the given size
    // -------------------------------------------------------
    public IntegerList(int size)
    {
        list = new int[size];
    }

    // -------------------------------------------------------
    // fill array with integers between 1 and 100, inclusive
    // -------------------------------------------------------
    public void randomize()
    {
        for (int i = 0; i < list.length; i++)
        list[i] = (int) (Math.random() * 100) + 1;
    }

    // -------------------------------------------------------
    // print array elements with indices
    // -------------------------------------------------------
    public void print()
    {
        for (int i = 0; i < list.length; i++)
        System.out.println(i + ":\t" + list[i]);
    }

    // ------------------------------------------------------------------
    //   Returns the index of the first occurrence of target in the list.
    //   Returns -1 if target does not appear in the list.
    // ------------------------------------------------------------------
    public int search(int target)
    {
	int location = -1;
	for (int i=0; i<list.length && location == -1; i++)
	    if (list[i] == target)
		    location = i;
	return location;
    }

    // ------------------------------------------------------------------------
    //  Sorts the list into ascending order using the selection sort algorithm.
    // ------------------------------------------------------------------------
    public void selectionSort()
    {
	int minIndex;
	for (int i=0; i < list.length-1; i++)
            {
                //find smallest element in list starting at location i
                minIndex = i;
                for (int j = i+1; j < list.length; j++)
                    if (list[j] < list[minIndex])
                        minIndex = j;

                //swap list[i] with smallest element
                int temp = list[i];
                list[i] = list[minIndex];
                list[minIndex] = temp;
            }
    }
    
    // -----------------------------------------------------------------
    //  Replaces the first occurence of oldVal in the list with newVal.
    // -----------------------------------------------------------------
    public void replaceFirst(int oldVal, int newVal)
    {
        int oldIndex;
        oldIndex = search(oldVal);
        list[oldIndex] = newVal;
    }
    
    // ------------------------------------------------------------
    //  Replaces all occurence of oldVal in the list with newVal.
    // ------------------------------------------------------------
    public void replaceAll(int oldVal, int newVal)
    {
        for (int i = 0; i < list.length - 1; i++)
        {
          if (list[i] == oldVal)
            list[i] = newVal;
        }
    }
    
    // ------------------------------------------------------------------------
    //  Sorts the list into descending order using the selection sort algorithm.
    // ------------------------------------------------------------------------
    public void sortDecreasing()
    {
	int maxIndex;
	for (int i=0; i < list.length-1; i++)
            {
                //find smallest element in list starting at location i
                maxIndex = i;
                for (int j = i+1; j < list.length; j++)
                    if (list[j] > list[maxIndex])
                        maxIndex = j;

                //swap list[i] with smallest element
                int temp = list[i];
                list[i] = list[maxIndex];
                list[maxIndex] = temp;
            }
    }
    
    // ------------------------------------------------------------------
    //   Returns the index of the first occurrence of target in the list.
    //   Returns -1 if target does not appear in the list.
    //   Using binary search algorithm.
    // ------------------------------------------------------------------
    public int binarySearchD(int target)
    {
        int tail, mid, head;
        this.sortDecreasing();
        tail = 0;
        head = (list.length - 1);
        mid = (tail + head) / 2;
        while (list[mid] != target && tail <= head)
        {
            if (target < list[mid])
                tail = mid + 1;
            else
                head = mid - 1;

            mid = (tail + head) / 2;
        }
        if (list[mid] == target)
            return mid;
        else
            return -1;
    }
}