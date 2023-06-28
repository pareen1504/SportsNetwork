package com.pd.domain.entity

enum class SportsType(val sportType: String, val type: Int) {
    NONE("none",-1),
    F1("F1",0),
    NBA("NBA",1),
    Tennis("Tennis",2),
    ;

    companion object {
        fun getFromSportsType(sportType: String) = values().firstOrNull { it.sportType.equals(sportType, true) }?.type ?: NONE.type
    }
}