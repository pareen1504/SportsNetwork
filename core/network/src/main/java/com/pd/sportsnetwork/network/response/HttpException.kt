package com.pd.sportsnetwork.network.response

import java.io.IOException

class HttpException(
    val statusCode: Int,
    val headers: Map<String, List<String>>,
) : IOException("HTTP error: $statusCode")
