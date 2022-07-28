写程序用A* search算法解决8拼图问题  
Board data type.  
A* search 算法:  
    建模:  
        define a search node to be a board.  
            number of moves  
            previous seach node  
    步骤:  
        1. insert initial search node(0 moves, a null previous search node) into PQ.
        2. delMin in minPQ, and insert PQ all neighbors(that not be deleted)
        3. 重复直到goal board  
    效率:取决与优先级函数  
        hamming priority function = hamming-distance * moves.hamming优先级越小越接近goal  
        Manhattan priority function = manhattan-distance * moves.  
Game tree:
    view the computation as a game tree.  
        The root of the tree is initial  
        at each step, A* remove smallest priority and processes it(adding its children both game tree and PQ)  
Two optimizations.  
    The critical optimization:  
    Caching the Hamming and Manhattan priorities 
    
    
    
          
        
    