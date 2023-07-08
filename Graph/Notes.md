# Graph: 
    Finite set of edges and vertices

# Type:
    1) Undirected and directed
    2) weighted and unweighted
# relation : 
    neighbour - have to store neighbours in vertices of graph 
# Implementation:
    1) uing adjacency matrix
        disadva: wastage of storage
            storing values even if edge not there
    2) Adjacency list --store grpgh in the from of linkedlist
        disad: to find a node- require traversing complete corresponding list
                this means time complexity more ie. O(n)
    3) HashMap : 
            strore vertices in map and keep another hashmap addresses corresponding to these
            which contains all the neighbors as key and their weights in values
                                                        HashMap
            int (vertices)       hashmap              neighbout  weight
            |   1       |          1k       |  ->   | 2         | 5 |
                                                    |3          | 6 | 
            |   2       |          2k       |  ->   | 2         | 5 |
                                                    |3          | 6 | 
            |   3       |          3k       |  ->   | 2         | 5 |
                                                    |3          | 6 | 
            


# BFS:
1) remove
2) Ignore   (already visited vertex in queue then ignore)-----graph have cycle
3) visites
4) self work
5) nbrs add

# DFS :
    uses stack in plavce of queueue

# traversal
    grapgh can be disconnected or graph can have multiple components
    4) self work: 

# Bipartite graph: 
    1. if graph is acyclic then it is bipartite
    2. if cyclic--odd length cycle --not bipartite
                --even length cycle--always bipartite

                1
                /\ 