package com.pd.sportsnetwork.network.adapter


import com.squareup.moshi.FromJson
import com.squareup.moshi.JsonReader
import com.squareup.moshi.JsonWriter
import com.squareup.moshi.ToJson
import okio.Buffer
import org.json.JSONObject

internal object JSONObjectAdapter {

    @FromJson
    fun fromJson(reader: JsonReader): JSONObject? = runCatching {
        JSONObject(reader.readJsonValue() as Map<*, *>)
    }.getOrNull()

    @ToJson
    fun toJson(writer: JsonWriter, value: JSONObject?) {
        value?.let { writer.value(Buffer().writeUtf8(value.toString())) }
    }
}