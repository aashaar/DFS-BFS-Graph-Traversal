/*
 ******************************************************************************
 * Title: DFS & BFS Graph traversal
 * Author : Aashaar Panchalan
 ******************************************************************************  */


import java.io.*;
import java.util.*;

public class Graph {
    private int vertices;
    private LinkedList<Integer> adjList[]; // list of all vertices

    Graph(int vertices) //constructor
    {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i=0; i <vertices; i++)
        {
            adjList[i]=new LinkedList<>(); //adjacency list for each vertex
        }
    }

    void addEdge(int v, int n) // to add egge v --> n
    {
        adjList[v].add(n);
    }
    void DFS(int v)
    {
        boolean isVisited[] = new boolean[vertices];
        DFS_Traverse(isVisited,v);

    }

    void DFS_Traverse(boolean isVisited[],int v)
    {
        System.out.println(v);
        isVisited[v] =true;
        Iterator<Integer> i = adjList[v].listIterator();
        while (i.hasNext())
        {
            int x = i.next();
            if(isVisited[x] == false) // vertex is not visited
            {
                DFS_Traverse(isVisited, x);
            }
        }
    }

    void BFS(int b)
    {
        boolean isVisited[] = new boolean[vertices];
        LinkedList<Integer> queue = new LinkedList<Integer>();

        queue.add(b);
        isVisited[b] = true;

        while (queue.size() != 0)
        {
            int front = queue.poll();
            System.out.println(front);
            Iterator<Integer> i = adjList[front].listIterator();
            while (i.hasNext())
            {
                int x = i.next();
                if(isVisited[x] == false)
                {
                    queue.add(x);
                    isVisited[x]= true;
                }
            }

        }
    }

    public static void main(String args[])
    {
        Graph g = new Graph(10);
        g.addEdge(1, 2);
        g.addEdge(1, 8);
        g.addEdge(2, 9);
        g.addEdge(3, 2);
        g.addEdge(3, 4);
        g.addEdge(4, 5);
        g.addEdge(5, 6);
        g.addEdge(5, 0);
        g.addEdge(6, 5);
        g.addEdge(6, 7);
        g.addEdge(6, 9);
        g.addEdge(7, 1);
        g.addEdge(7, 8);
        g.addEdge(7, 0);
        g.addEdge(8, 6);
        g.addEdge(8, 9);
        g.addEdge(9, 3);
        g.addEdge(9, 4);
        g.addEdge(9, 5);
        g.addEdge(0, 6);

        System.out.println("Nodes & Edges :\n0: 6\n1: 2,8\n2: 9\n3: 2,4\n4: 5\n5: 6,10\n6: 5,7,9\n7: 1,8,10,\n8: 6,9\n9: 3,4,5");
        System.out.println("=======================");
        System.out.println("DFS from vertex 2: ");
        g.DFS(2);
        System.out.println("=======================");
        System.out.println("BFS from vertex 2: ");
        g.BFS(2);
        System.out.println("=======================");
    }
}


