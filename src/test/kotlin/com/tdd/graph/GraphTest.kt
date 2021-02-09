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

    @Test
    fun `Graph should give the shortest route when the input has a route in between`() {
        var graph = Graph("AC3,CB4")
        var shortestDistance = graph.getShortestRoute("A", "B")
        assertEquals(7, shortestDistance)

        graph = Graph("AC3,CD4,DB5")
        shortestDistance = graph.getShortestRoute("A", "B")
        assertEquals(12, shortestDistance)
    }

    @Test
    fun `Graph should give the shortest route when the input has multiple routes`() {
        var graph = Graph("AC3,CB4,AB5")
        var shortestDistance = graph.getShortestRoute("A", "B")
        assertEquals(5, shortestDistance)
    }
}