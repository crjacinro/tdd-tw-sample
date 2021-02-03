package com.tdd.graph

import org.junit.Test
import kotlin.test.assertEquals

class GraphTest {
    @Test
    fun `Graph_newInstance_shouldReceiveListOfPoints`() {
        val routeList = "AB5"
        val graph = Graph(routeList)

        val shortestDistance = graph.getShortestRoute("A", "B")

        assertEquals(5, shortestDistance)
    }
}