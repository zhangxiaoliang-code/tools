package com.zxl.daily.base.algorithm;

import java.util.*;
import java.util.function.Function;

/**         A
 *      6>      1>
 * 起点      3^     终点
 *      2>      5>
 *          B
 *  <p>狄克斯特拉算法
 *
 *  First Graph Program.
 */
public class Test {

    public static void main(String[] args) {
        // 每个节点到其邻居节点的开销
        Map<String, Double> start = new HashMap<>();
        start.put("a", 6D);
        start.put("b", 2D);

        Map<String, Double> a = new HashMap<>();
        a.put("fin", 1D);

        Map<String, Double> b = new HashMap<>();
        b.put("a", 3D);
        b.put("fin", 5D);

        Map<String, Double> fin = new HashMap<>();

        // 整个图: key 为每个节点名称，value 为每个节点到其邻居节点的开销
        Map<String, Map<String, Double>> graph = new HashMap<>();
        graph.put("start", start);
        graph.put("a", a);
        graph.put("b", b);
        graph.put("fin", fin);

        // 从起点到每个节点的开销
        Map<String, Double> costs = new HashMap<>();
        costs.put("a", 6.0D);
        costs.put("b", 2.0D);
        costs.put("fin", Double.POSITIVE_INFINITY);

        // 已经处理过的节点
        List<String> processed = new ArrayList<>();

        // 路径中每个节点的父节点
        Map<String, String> parents = new HashMap<>();
        parents.put("a", "start");
        parents.put("b", "start");
        parents.put("fin", null);

        // 找出剩下的没有处理过的节点中花费最少的节点
        Function<Map<String, Double>, String> findLowestCostNode = t -> {
            Double lowestCost = Double.POSITIVE_INFINITY;
            String lowestCostNode = null;

            for (Map.Entry<String, Double> entry : t.entrySet()) {
                if (entry.getValue() < lowestCost && !processed.contains(entry.getKey())) {
                    lowestCostNode = entry.getKey();
                    lowestCost = entry.getValue();
                }
            }

            return lowestCostNode;
        };

        String currentLowestCostNode = findLowestCostNode.apply(costs);

        // 当前花费最小的节点到其邻居节点的开销如果相比之前更少，则更新其邻居节点的开销并标记父节点为当前节点；
        // 重复执行这一步直到所有的节点都处理完成
        while (currentLowestCostNode != null) {
            Double cost = costs.get(currentLowestCostNode);

            // 处理当前节点的每一个邻居节点，计算其开销
            Map<String, Double> neighbors = graph.get(currentLowestCostNode);
            for (Map.Entry<String, Double> entry : neighbors.entrySet()) {
                final String name = entry.getKey();
                final Double value = entry.getValue();

                Double newCost = cost + value;
                if (costs.get(name) > newCost) {
                    costs.put(name, newCost);
                    parents.put(name, currentLowestCostNode);
                }
            }

            // 标记当前节点为已处理
            processed.add(currentLowestCostNode);

            // 当前结点处理完成后找出下一个开销最小的节点
            currentLowestCostNode = findLowestCostNode.apply(costs);
        }

        // 打印结果
        System.out.println(costs);
        System.out.println(parents);

        // 格式化打印从出发点到终点的最短路径
        Stack<String> stack = new Stack<>();
        String parentNode = "fin";
        while (parentNode != null) {
            stack.push(parentNode);
            parentNode = parents.get(parentNode);
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());

            if (!stack.isEmpty()) {
                System.out.print(" --> ");
            }
        }
    }
}
