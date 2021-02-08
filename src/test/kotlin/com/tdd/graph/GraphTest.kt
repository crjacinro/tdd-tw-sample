package com.tdd.graph

import org.junit.Test
import kotlin.test.assertEquals

class GraphTest {
    @Test
    fun `Graph should give the shortest route when the input has single and direct route`() {
        var graph = Graph("AB5,AC3")
        var shortestDistance = graph.getShortestRoute("A", "B")
        assertEquals(5, shortestDistance)

        graph = Graph("AB5")
        shortestDistance = graph.getShortestRoute("A", "B")
        assertEquals(5, shortestDistance)
    }
}