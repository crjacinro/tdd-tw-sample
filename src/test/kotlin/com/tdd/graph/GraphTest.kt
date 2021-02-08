package com.tdd.graph

import org.junit.Test
import kotlin.test.assertEquals

class GraphTest {
    @Test
    fun `Graph should give the shortest route when the input has direct route`() {
        val routeList = "AB5"
        val graph = Graph(routeList)

        val shortestDistance = graph.getShortestRoute()

        assertEquals(5, shortestDistance)
    }

    @Test
    fun `Graph should give the shortest route when the input has direct and indirect route`() {
        val routeList = "AB5,AC3"
        val graph = Graph(routeList)

        val shortestDistance = graph.getShortestRoute()

        assertEquals(5, shortestDistance)
    }
}