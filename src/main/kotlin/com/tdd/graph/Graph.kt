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
        routes.forEach { firstRoute ->
            if (firstRoute.start == start && firstRoute.end == end) {
                return firstRoute
            }

            if (firstRoute.start == start) {
                routes.forEach { secondRoute ->
                    if (secondRoute.start == firstRoute.end && secondRoute.end == end) {
                        return Route(start, end, firstRoute.distance + secondRoute.distance)
                    }

                    if (secondRoute.start == firstRoute.end) {
                        routes.forEach { thirdRoute ->
                            if (thirdRoute.start == secondRoute.end && thirdRoute.end == end) {
                                return Route(start, end, firstRoute.distance + secondRoute.distance + thirdRoute.distance)
                            }
                        }
                    }
                }
            }
        }

        return null
    }
}


