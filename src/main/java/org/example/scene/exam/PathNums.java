package org.example.scene.exam;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 用一串英文代表一个城市的代号，A->B代表A城市可以直达B城市，可到达的城市可能有多个用-分割
 * 给定：A->B、A->C、B->E、B->F、E->G-H、F->H-I
 * 求A到H可能的路径数有多少条？用Java语言实现
 */
public class PathNums {
    private static Map<Character, Set<Character>> graph = new HashMap<>();
    private static int count = 0;
    public static void main(String[] args) {
        // 建立城市地图
        buildGraph();
        // 计算路径数
        countPaths('A', 'H');
        System.out.println(count);
    }

    private static void countPaths(char start, char end) {
        HashSet<Character> visited = new HashSet<>();
        dfs(start, end, visited);
    }

    private static void dfs(char cur, char end, HashSet<Character> visited) {
        if (cur == end) {
            count++;
            return;
        }
        visited.add(cur);
        if (graph.containsKey(cur)) {
            for (Character c : graph.get(cur)) {
                if (!visited.contains(c)) {
                    dfs(c, end, visited);
                }
            }
        }
    }

    private static void buildGraph() {
        HashSet<Character> set1 = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        HashSet<Character> set3 = new HashSet<>();
        HashSet<Character> set4 = new HashSet<>();
        set1.add('B');
        set1.add('C');
        set2.add('E');
        set2.add('F');
        set3.add('G');
        set3.add('H');
        set4.add('H');
        set4.add('I');
        graph.put('A', set1); graph.put('B', set2); graph.put('E', set3); graph.put('F', set4);
    }
}
