# Dijkstra-study
Here is all I learned on Dijkstra including my final project 
Dijkstra's algorithem is sued to find the shortest path on weighted graphs ( we know the path values "how long")

 By using adjecancy matrix, we will detarmin the shortest path by building a table following this algorithm:
 
 void table(vertex,start,graph g,table t){
 readGraph(B,T);
 for(i=numberofvertex;i>0;i--){
 T[I].known = false;
 T[I].dist = MAXINT;
 T[I].path = 0 // this is to tell that tere is no vertex leading to it , we prefare using 0 insted of null.
 }
 T[Start].dist=0;
 }
 
 
This will lead to making a traceable table so we can see where did we reach that vertex from , shortest distance from exploared vertices , explored or not.

The Dijkstra algorithm used :


void di(table t){
vertex v,w;
for(;;)// vertex v
v=smallest unkown distance available.
if(v is not a vertex(v=0))
break;
T[v].known=true; //(or 1 in case using intger)
for(eachadjacent to v)
  if(vektor is known)
    if(t[v].dist + COASTv,w <T[w].dist){
    T[W].dist=T[V].dist+COASTv,w;
    T[W].path= V
}

Printing the path will lead to t(n)= O(V^2)

These algorithms will be fount implemented  at https://github.com/Vloxin/Dijkstra-study/blob/main/DijkstrasAlgorithm.java



