#include <stdio.h>

int example_array[] = {8000, -2, 1, 30, 12, -20, -99999};
int array_size = 7;
_Bool use_linked_list = 0;


void print_array(int array[], int length) {
  int i;
  for(i = 0; i < length; i++)
    printf("%d, ", array[i]);
  putchar('\n');
}

void array_separate(int array[], int length) { //separate negative ints using swaps in an array
  int last_dest_used = -1; //track the index that we last moved a negative int to
  int i;
  for(i = 0; i < length; i++) //check every int to see if it's negative
    if(array[i] < 0) { //swap negative int to first unused spot in array
      int negative_int = array[i]; //hold onto negative int to swap with
      array[i] = array[last_dest_used+1]; //move int currently in unused spot to spot with negative int
      array[last_dest_used+1] = negative_int; // move negative int to new spot
      last_dest_used++; //update our track of the last index used
    }
  print_array(array, length);
}

void list_separate(int array[], int length) { //separate negative ints using a linked list
  return;
}

int main(void) {
  print_array(example_array, array_size);
  int* pointer = 0;
  if(!use_linked_list)
    array_separate(example_array, array_size);
  else
    list_separate(example_array, array_size);
}

/*
Loop invariant for array_separate()
  for each loop, we know that the integers inclusively between 0 and
  last_dest_used are negative, and that the integers inclusively between
  last_dest_used and i are positive.
  We know this because last_dest_used only increases when negatives are placed at
  the right edge of the section, and because i only increases when the number passed
  is positive, or a positive number is placed at i.
  This means, as i increases, more and more of the array is separated out, and
  when i reaches len(array), the entire array is separated.
*/
