import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;
import java.util.Stack;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.Queue;
import java.util.PriorityQueue; 
import java.util.LinkedList;

public class tryyy
{
    // 0: Haven't been colored yet.
    // 1: Blue.
    // -1: Red.
/////////////////////////////Others  BFS/////////////////////////////
    // public boolean isBipartite(int[][] graph) {
    //     int len = graph.length;
    //     int[] colors = new int[len];

    //     for (int i = 0; i < len; i++) {
    //         if (colors[i] != 0) 
    //             continue;
    //         Queue<Integer> queue = new LinkedList<>();
    //         queue.offer(i);
    //         colors[i] = 1;   // Blue: 1; Red: -1.
            
    //         while (!queue.isEmpty()) {
    //             int cur = queue.poll();
    //             for (int next : graph[cur]) {
    //                 if (colors[next] == 0) {          // If this node hasn't been colored;
    //                     colors[next] = -colors[cur];  // Color it with a different color;
    //                     queue.offer(next);
    //                 } 
    //                 else if (colors[next]==colors[cur])// If it is colored and its color is different, return false;
    //                     return false;
    //             }
    //         }
    //     }
    //     return true;
    // }

/////////////////////////////Others  DFS/////////////////////////////
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n];          
                
        for (int i = 0; i < n; i++) {              
        //This graph might be a disconnected graph. So check each unvisited node.
            if (colors[i] == 0 && !validColor(graph, colors, 1, i)) {
                return false;
            }
        }
        return true;
    }
    
    public boolean validColor(int[][] graph, int[] colors, int color, int node) {
        if (colors[node] != 0) {
            return colors[node] == color;
        }       
        colors[node] = color;       
        for (int next : graph[node]) {
            if (!validColor(graph, colors, -color, next)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args){
        tryyy tr=new tryyy(); 
        //int[][] graph={{1,3},{0,2},{1,3},{0,2}};
        int[][] graph={{1,2,3}, {0,2}, {0,1,3}, {0,2}};
        boolean ans=tr.isBipartite(graph);
        System.out.println(ans);           
    }
}