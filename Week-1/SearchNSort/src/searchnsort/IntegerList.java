package searchnsort;

// ****************************************************************
// FILE: IntegerList.java
//
// Purpose: Define an IntegerList class with methods to create, fill,
// sort, and search in a list of integers.
//
// ****************************************************************

import java.util.Scanner;
import java.util.*;

public class IntegerList
{
    int[] list; //values in the list
    
    //------------------------------------------------------------
    // Constructor -- takes an integer and creates a list of that
    // size. All elements default to value 0.
    //------------------------------------------------------------
    public IntegerList(int size)
    {
        list = new int[size];
    }
    //------------------------------------------------------------
    // randomize -- fills the array with randomly generated integers
    // between 1 and 100, inclusive
    //------------------------------------------------------------
    public void randomize()
    {
        int max = list.length;
        for (int i=0; i<list.length; i++)
            list[i] = (int)(Math.random() * max) + 1;
    }
    
    //------------------------------------------------------------
    // fillSorted -- fills the array with sorted values
    //------------------------------------------------------------
    public void fillSorted()
    {
        for (int i=0; i<list.length; i++)
            list[i] = i + 2;
    }
    
    //------------------------------------------------------------
    // print -- prints array elements with indices, one per line
    //------------------------------------------------------------
    public String toString()
    {
        String s = "";
        for (int i=0; i<list.length; i++)
            s += i + ":\t" + list[i] + "\n";
        return s;
    }
    
    //------------------------------------------------------------
    // linearSearch -- takes a target value and returns the index
    // of the first occurrence of target in the list. Returns -1
    // if target does not appear in the list
    //------------------------------------------------------------
    public int linearSearch(int target)
    {
        int location = -1;
        for (int i=0; i<list.length && location == -1; i++)
            if (list[i] == target)
                location = i;
        return location;
    }
    
    //------------------------------------------------------------
    // sortIncreasing -- uses selection sort
    //------------------------------------------------------------
    public void sortIncreasing()
    {
        for (int i=0; i<list.length-1; i++)
        {
            int minIndex = minIndex(list, i);
            swap(list, i, minIndex);
        }
    }
    
    //find smallest element in list starting at location i
    private int minIndex(int[] list, int i) {
        int minIndex = i;
        for (int j = i+1; j < list.length; j++){
            if (list[j] < list[minIndex]){
                minIndex = j;
            }
        }
        return minIndex;
    }
    
    //swap list[i] with smallest element
    public void swap(int[] list, int a, int b){
        int temp = list[a];
        list[a] = list[b];
        list[b] = temp;
    }
    
    // ------------------------------------------------------------------------
    //  Sorts the list into descending order using the insertion sort algorithm.
    // -----------------------------------------------------------------------
    public void sortDecreasing()
    {
        for (int i = 1; i < list.length; i++) {
            int key = list[i];
            int j = i - 1;
 
            while (j >= 0 && list[j] < key) {
                list[j + 1] = list[j];
                j = j - 1;
            }
            list[j + 1] = key;
        }
    }
    
    //   Returns the index of the first occurrence of target in the list.
    //   Returns -1 if target does not appear in the list.
    //   Using binary search algorithm.
    // ------------------------------------------------------------------
    public int binarySearch(int target)
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