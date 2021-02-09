package com.tdd.graph

class Graph(routeList: String) {
    private var routes = mutableListOf<Route>()

    init {
        routeList.split(",").forEach {
            val start = it.substring(0, 1)
            val end = it.substring(1, 2)
            val distance = it.substring(2).toInt()

            routes.add(Route(start, end, distance))
        }
    }

    fun getShortestRoute(start: String, end: String): Int {
        return lookForRoute(start, end).map { it.distance }.minOrNull() ?: -1
    }

    private fun lookForRoute(start: String, end: String): List<Route> {
        val listOfRoutes = mutableListOf<Route>()
        routes.filter { it.start == start }.forEach {
            if (it.end == end) {
                listOfRoutes.add(it)
            }

            val downStreamRoute = lookForRoute(it.end, end)
            downStreamRoute.forEach { downRoute ->
                listOfRoutes.add(Route(start, end, it.distance + downRoute.distance))
            }
        }

        return listOfRoutes
    }
}


