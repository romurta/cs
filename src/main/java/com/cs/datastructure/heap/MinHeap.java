package com.cs.datastructure.heap;

public class MinHeap {

    private int[] heap;
    private int capacity = 0;
    private int size = 0;


    public int getSize(){return size;}

    public MinHeap(int capacity){
        this.capacity = capacity;
        heap = new int[this.capacity];
    }

    private int getParentIndex(int index){
        return (index - 1)/2;
    }

    private int getRightChild(int index){
        return (index*2)+2;
    }

    private int getLeftChild(int index){
        return (index*2)+1;
    }

    public int extractMin(){
        int result = heap[0];

        int lastIndex = size - 1;
        swap(0,lastIndex);

        heap[lastIndex] = 0;
        size--;

        heapfyDown();



        return result;
    }

    private void heapfyDown() {
        int index = 0;

        while(getLeftChild(index) < size){

            int smallestIndex = getLeftChild(index);

            if(getRightChild(index) < size && heap[smallestIndex] > heap[getRightChild(index)]){ // smallest index
                smallestIndex = getRightChild(index);
            }

            if(heap[index] > heap[smallestIndex]){
                swap(index,smallestIndex);
            } else{
                break;
            }

            index = smallestIndex;

        }
    }

    public void add(int data){
        heap[size] = data;
        size++;
        heapfyUp();
    }

    private void heapfyUp() {
        int index = size - 1;

        while(getParentIndex(index) >= 0 && heap[getParentIndex(index)] > heap[index]){
            swap(index, getParentIndex(index));
            index = getParentIndex(index);
        }

    }



    private void swap(int from, int to){
        int temp = heap[to];
        heap[to] = heap[from];
        heap[from] = temp;
    }


}
