"""
Find the shortest range that would have at least one entry from each of the input sorted integer arrays?

A1 = [11, 17, 22, 31, 33] 
A2 = [7, 16, 19, 27] 
A3=  [12, 25, 29, 37]
.
.
N
1) 7-12
   7 8 9 10 11 12
   A2       A1 A3
   
   Ans: 7-12 --> 6
   
   27-31
 
 11, 7, 12 - 12 - 7 = 6
 11, 16, 12 - 16 - 11 = 6
 17, 16, 12 - = 6
 17, 16, 25 = 10
 17, 19, 25 = 9
 22, 19, 25 = 7.. 
 
 11, 7, 25 - 
 
 7-12
 7 8 9 10 11 12
 -->        <--
 
 veera: I will pick up the solution from the pad at 3:15 PST
 varad:  Okay. Will see where the bug is and fix it. Thanks.
 
 Do you want to check  before you call find_range()?
 
 VM: I think I should the active check, as you suggested.. rather than defer checking after all the updates. Weell
 
 Varad I have to step outside. I will take the solution once I come back. All the best.


Not an issue. Thanks for your time..

Varad: Veera, the output comes like this - 
-------------------------------------- 
Varad Meru running 103 lines of Python 
-------------------------------------- 
Global Range 5 
Global min 27 
Global max 31

try now
Sorry I might have reverted your last two changes

Got it.
Done!

Thanks for your time and sorry taking time of your


"""

a1 = [11, 17, 22, 31, 33] 
a2 = [7, 16, 19, 27] 
a3 = [12, 25, 29, 37]
# For A[N] = [[1,2,4,...],[1,5,7,...],...]
# with varied length arrays, the process can be automated,
# with lengths of each array stored in an array lengths[N] and the indices of the current array maintained at 

def find_min_range():    
    index_array = [0, 0, 0]
    
    lengths_of_array = [len(a1), len(a2), len(a3)]
    index_array[0] = 0
    index_array[1] = 0
    index_array[2] = 0
    
    global_min = 0
    global_max = 0
    global_range = 10000000
    
    
    index_min, min, max = find_range(index_array)
    range = max - min + 1
    
    while (True):
        if lengths_of_array[index_min] == index_array[index_min] + 1:
            # The cause of the problem. I was doing -1, where I should've done a +1 to take the 0 offset into account.
            if range < global_range:
                global_min = min
                global_max = max
                global_range = global_max - global_min + 1
            # Need to check one last time, to confirm if I am not mission anything.
            break
        else:
            if range < global_range:
                global_min = min
                global_max = max
                global_range = global_max - global_min + 1
            index_array[index_min] += 1
            
        index_min, min, max = find_range(index_array)
        range = max - min + 1
        
    print "Global Range", global_range
    print "Global min", global_min
    print "Global max", global_max
        
        
def find_range(temp_array_from_func):
    temp_array = [a1[temp_array_from_func[0]] ,
                 a2[temp_array_from_func[1]] ,
                 a3[temp_array_from_func[2]]]
    index = -1
    temp_min = 10000000
    temp_max = -10000000
    for i in range(len(temp_array)):
        if temp_min > temp_array[i]:
            temp_min = temp_array[i]
            index = i
        if temp_max < temp_array[i]:
            temp_max = temp_array[i]
            
    return index, temp_min, temp_max


find_min_range()