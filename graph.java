import java.io.*;
import java.util.*;

//creates a directed graph

public class graph {
    private int V; // number of vertices
    private LinkedList<Integer> adj [];
    private boolean directed;

    public graph(boolean directed, int value){
        this.directed = directed;
        adj = new LinkedList[value];
        V = value;
        for (int i=0; i< value; i++){
            adj[i] = new LinkedList<Integer>();
        }
    }

    public void addEdge(int u, int v){
        if (u >=0 && u<=V){
            if (v >=0 && v<=V){
                adj[u].add(v);

                if (directed){
                    adj[v].add(u);
                }
            }
        }
    }

    public void bfs(int s){
        LinkedList<Integer> queue = new LinkedList<>();
        boolean visited [] = new boolean [V];

        //mark first seen and add to queue
        visited[s] = true;
        queue.add(s);

        while(!queue.isEmpty()) {
            s = queue.pop();
            System.out.println(s);
            Iterator<Integer> it = adj[s].listIterator();

            while(it.hasNext()){
                int n = it.next();

                if(visited[n] == false){
                    visited[n] = true;
                    queue.add(n);
                }
            }

        }

    }

    public boolean isConnected(int u, int v){
        Iterator<Integer> it = adj[u].listIterator();
        while(it.hasNext()){
            if(v == it.next()){
                return true;
            }

        }
        it = adj[v].listIterator();
        while(it.hasNext()){
            if(u == it.next()){
                return true;
            }

        }
        return false;
    }

    public String toString(){
        String res = "";
        for (int i=0; i< V; i++){
            res += i;
            res += adj[i] + "\n";

        }
        return res;
    }
}
