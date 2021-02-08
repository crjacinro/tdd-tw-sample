package com.tdd.graph

class Graph(routeList: String) {
    private var routes = mutableListOf<Route>()

    init {
        routeList.split(",").forEach {
            routes.add(Route(it.substring(2).toInt()))
        }
    }

    fun getShortestRoute(): Int {
        return routes.first().distance
    }
}


