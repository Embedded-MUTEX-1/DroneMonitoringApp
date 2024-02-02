package fr.lenny.dronemonitorv2.util

import com.google.gson.Gson

fun <T> JsonToObject(json: String, clazz: Class<T>): T {
    return  Gson().fromJson(json, clazz)
}

fun <T> ObjectToJson(jsonObject: T) : String {
    return Gson().toJson(jsonObject)
}