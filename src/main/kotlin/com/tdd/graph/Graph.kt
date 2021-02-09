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
        val route = lookForRoute(start, end)
        return route?.distance ?: -1
    }

    private fun lookForRoute(start: String, end: String): Route? {
        routes.forEach { route ->
            if (route.start == start && route.end == end) {
                return route
            }

            if (route.start == start) {
                val downStreamRoute = lookForRoute(route.end, end)
                downStreamRoute?.let {
                    return Route(start, end, route.distance + it.distance)
                }
            }
        }

        return null
    }
}


