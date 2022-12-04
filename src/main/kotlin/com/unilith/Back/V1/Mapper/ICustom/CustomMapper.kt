package com.unilith.Back.V1.Mapper.ICustom

interface CustomMapper <O,E>{

    fun convertVo(entity:E):O

    fun convertEntity(vo:O):E

    fun convertListVo(listaEntity:ArrayList<E>):ArrayList<O>{
        val lista:ArrayList<O> = ArrayList()

        for (entity in listaEntity) {
            val vo = convertVo(entity)
            lista.add(vo)
        }

        return lista;
    }

    fun convertListEntity(listaVo:ArrayList<O>):ArrayList<E>{
        val lista:ArrayList<E> = ArrayList()

        for (vo in listaVo) {
            val entity = convertEntity(vo)
            lista.add(entity)
        }

        return lista;
    }
}