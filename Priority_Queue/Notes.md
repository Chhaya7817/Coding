# Priority Queue: 

    -it is a Complete binary tree

# Heap :
    y>x<z min heap --> value of x is less  and priority of x is more
	y<x>z max heap --> value of x and priority of x is more
			
	     15
	/	   \
	18	    20
    /    \     /  \
   19	    27   23  21
  /  \
 36   120
why heap?
		 	Sorted Array		Unsorted Array		Heap

add element		O(n) {Data shifting	O(1) {insert anywhere}	log(n)
			at insertion}	
 
remove min		O(n)				O(n)				O(log n) 
element

get min		O(1)				O(n)				O(1)

2*pi +1 =Li (left index)
2*pi +2=Ri(right index)
pi-parent index